import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';
import { SleepPlan } from '../models/slee-plan';
import { switchMap } from 'rxjs/operators';
import { forkJoin } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class SleepPlanService {
  private baseUrl = 'https://6928666ab35b4ffc50158cba.mockapi.io/api/sleep-plans';
  constructor(private http: HttpClient) {}
    getPlans() {
    const userId = localStorage.getItem('userId'); // usuario actual
    return this.http.get<any[]>(`${this.baseUrl}?userId=${userId}`).pipe(
      map(data => data.map(item => {
        const plan = new SleepPlan();
        plan.id = Number(item.id);
        plan.date = new Date(item.date);
        plan.sleepTime = item.sleepTime ?? '';
        plan.wakeTime = item.wakeTime ?? '';
        plan.napTime = item.napTime ?? '';
        plan.routine = item.routine ?? '';
        plan.notes = item.notes ?? '';
        return plan;
      }))
    );
  }

  createPlan(plan: SleepPlan) {
  const userId = localStorage.getItem('userId');
  return this.http.post(this.baseUrl, {
    ...plan,
    userId: userId,
    date: plan.date.toISOString().substring(0, 10)
  });
  }


  updatePlan(plan: SleepPlan) {
    return this.http.put(`${this.baseUrl}/${plan.id}`, {
      ...plan,
      date: plan.date.toISOString().substring(0, 10),
    });
  }

  deletePlan(id: number) {
    return this.http.delete(`${this.baseUrl}/${id}`);
  }


}
