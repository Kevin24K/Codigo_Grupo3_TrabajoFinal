import { Component, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

import { FormsModule } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';

// Material
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';

import { SleepPlan } from '../../models/slee-plan';
@Component({
  selector: 'app-sleep-plan',
  standalone: true,
  imports: [
    FormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule
  ],
  templateUrl: './sleep-plan.html',
  styleUrls: ['./sleep-plan.css']
})
export class SleepPlanComponent {

  constructor(
    public dialogRef: MatDialogRef<SleepPlanComponent>,
    @Inject(MAT_DIALOG_DATA) public data: SleepPlan
  ) {
    // Normalizamos datos
    this.data.routine = this.data.routine ?? '';
    this.data.notes = this.data.notes ?? '';
    this.data.sleepTime = this.data.sleepTime ?? '';
    this.data.wakeTime = this.data.wakeTime ?? '';
  }

  onSave() {
    this.dialogRef.close(this.data);
  }

  onDelete() {
    this.dialogRef.close({ delete: true, id: this.data.id });
  }

  onCancel() {
    this.dialogRef.close(null);
  }
}
