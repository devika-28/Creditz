import { Component, OnInit, Inject } from "@angular/core";
import { AnalystRegistrationComponent } from "../analyst-registration/analyst-registration.component";
import { MAT_DIALOG_DATA, MatDialogRef } from "@angular/material/dialog";

@Component({
  selector: "app-analyst-dialog-box",
  templateUrl: "./analyst-dialog-box.component.html",
  styleUrls: ["./analyst-dialog-box.component.css"],
})
export class AnalystDialogBoxComponent {
  constructor(
    public dialogRef: MatDialogRef<AnalystRegistrationComponent>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData
  ) {}

  onNoClick(): void {
    this.dialogRef.close();
  }
}
export interface DialogData {
  animal: string;
  name: string;
}
