import { FullCalendarModule } from '@fullcalendar/angular';
import dayGridPlugin from '@fullcalendar/daygrid';
import interactionPlugin from '@fullcalendar/interaction';
import { MatDialog } from '@angular/material/dialog';
import { MatDialogModule } from '@angular/material/dialog';
import { Component, OnInit, OnDestroy } from '@angular/core';
import { Router, NavigationStart } from '@angular/router';
import { Subscription } from 'rxjs';
import { forkJoin } from 'rxjs';
import { SleepPlanComponent } from '../sleep-plan/sleep-plan';
import { SleepPlan } from '../../models/slee-plan';
import { SleepPlanService } from '../../services/sleep-plan-service';

@Component({
  selector: 'app-sleep-calendar',
  standalone: true,
  imports: [
    FullCalendarModule,
    MatDialogModule,
  ],
  templateUrl: './sleep-calendar.html',
  styleUrls: ['./sleep-calendar.css']
})
export class SleepCalendar implements OnInit, OnDestroy {

  calendarOptions: any = {
    plugins: [dayGridPlugin, interactionPlugin],
    initialView: 'dayGridMonth',
    selectable: true,
    dateClick: (info: any) => this.onDateClick(info),
    eventClick: (info: any) => this.onEventClick(info),
    events: []
  };

  private routerSubscription: Subscription | undefined;

  constructor(
    private sleepService: SleepPlanService,
    private dialog: MatDialog,
    private router: Router
  ) {}

  ngOnInit() {
    this.loadEvents();

    // Suscribirse a cambios de ruta para limpiar el calendario
    this.routerSubscription = this.router.events.subscribe(event => {
      if (event instanceof NavigationStart) {
        this.clearCalendar();
      }
    });
  }

  /** CLICK EN DÍA VACÍO → CREAR PLAN */
  onDateClick(info: any) {
    const plan = new SleepPlan();
    plan.date = new Date(info.dateStr);

    const dialogRef = this.dialog.open(SleepPlanComponent, {
      data: plan,
      width: '420px'
    });

    dialogRef.afterClosed().subscribe(result => {
      if (!result) return;

      this.sleepService.createPlan(result).subscribe(() => {
        this.loadEvents();
      });
    });
  }

  /** CLICK EN EVENTO EXISTENTE → VER / EDITAR / ELIMINAR */
  onEventClick(info: any) {
    const id = Number(info.event.id);

    this.sleepService.getPlans().subscribe(plans => {
      const plan = plans.find(p => p.id === id);
      if (!plan) return;

      const dialogRef = this.dialog.open(SleepPlanComponent, {
        data: { ...plan },
        width: '420px'
      });

      dialogRef.afterClosed().subscribe(result => {
        if (!result) return;

        // Eliminar
        if (result.delete) {
          this.sleepService.deletePlan(id).subscribe(() => {
            this.loadEvents();
          });
          return;
        }

        // Actualizar
        this.sleepService.updatePlan(result).subscribe(() => {
          this.loadEvents();
        });
      });
    });
  }

  /** RECARGAR EVENTOS DEL SERVICIO */
  loadEvents() {
    this.sleepService.getPlans().subscribe(plans => {
      this.calendarOptions.events = plans.map(p => ({
        id: p.id,
        title: this.getEventTitle(p),
        date: p.date.toISOString().split('T')[0]
      }));
    });
  }

  /** TEXTO QUE SE MUESTRA EN EL CALENDARIO */
  getEventTitle(plan: SleepPlan): string {
    if (plan.routine?.trim()) return plan.routine;
    if (plan.notes?.trim()) return plan.notes;
    if (plan.sleepTime && plan.wakeTime)
      return `🛌 ${plan.sleepTime} → ${plan.wakeTime}`;
    return 'Plan';
  }

  /** LIMPIAR CALENDARIO */
  clearCalendar() {
    this.calendarOptions.events = [];
  }

  /** LIMPIAR AL DESTRUIR EL COMPONENTE */
  ngOnDestroy() {
    this.clearCalendar();
    if (this.routerSubscription) this.routerSubscription.unsubscribe();
  }
  deleteAllPlans() {
  this.sleepService.getPlans().subscribe(plans => {
    if (plans.length === 0) return; // nada que borrar

    const requests = plans.map(plan => this.sleepService.deletePlan(plan.id));
    forkJoin(requests).subscribe(() => {
      this.loadEvents(); // recarga los eventos solo después de borrar todo
    });
  });
}

}
