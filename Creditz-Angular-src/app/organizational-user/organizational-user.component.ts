import { Component, OnInit } from "@angular/core";
import { OrganizationApplicant } from "../model/organizationapplicant";
import { Organization } from "../model/organization";
import { OrganizationUserApplicationService } from "../services/organization-user-application.service";
import { FormGroup, FormBuilder, Validators } from "@angular/forms";

@Component({
  selector: "app-organizational-user",
  templateUrl: "./organizational-user.component.html",
  styleUrls: ["../forgot-password/forgot-password.component.css"],
})
export class OrganizationalUserComponent implements OnInit {
  store = window.sessionStorage.getItem("userId");
  storeRole = window.sessionStorage.getItem("role");
  selected = "None";
  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;
  isEditable = false;
  isThisStepDone = false;
  minAmount = 200000;
  maxAmount = 7000000;
  minTenure = 6;
  maxTenure = 100;
  maxTenureValue: any = function (principle: number) {
    if (principle < 255320) {
      var tenure = Math.floor(
        (1200 * principle) / (6000000 - principle * 11.5)
      );
      console.log(tenure);
      if (tenure > 0) {
        if (tenure <= 100) {
          return tenure;
        }
      } else return 100;
    } else return 100;
  };

  constructor(
    private applicationService: OrganizationUserApplicationService,
    private _formBuilder: FormBuilder
  ) {}

  ngOnInit(): void {
    this.firstFormGroup = this._formBuilder.group({
      pancard: ["", Validators.required],
      loanAmount: [
        "",
        [
          Validators.required,
          Validators.min(this.minAmount),
          Validators.max(this.maxAmount),
        ],
      ],
      revenue: ["", Validators.required],
      employeeCount: ["", Validators.required],
      businessAge: ["", Validators.required],
      licenseNumber: ["", Validators.required],
      loanTenure: [
        "",
        [
          Validators.required,
          Validators.min(this.minTenure),
          Validators.max(this.maxTenure),
        ],
      ],
      organizationType: ["", Validators.required],
    });
    this.secondFormGroup = this._formBuilder.group({
      bankruptcy: ["", Validators.required],
      criminalRecord: ["", Validators.required],
    });
  }
  apply() {
    window.alert(
      "We will use the information submitted by you during registration as your contact details."
    );
    this.applicationService.applyService(
      this.firstFormGroup.controls["pancard"].value,
      this.firstFormGroup.controls["loanAmount"].value,

      this.firstFormGroup.controls["revenue"].value,
      this.firstFormGroup.controls["employeeCount"].value,
      this.firstFormGroup.controls["businessAge"].value,
      this.firstFormGroup.controls["licenseNumber"].value,
      this.selected,
      this.secondFormGroup.controls["criminalRecord"].value,
      this.secondFormGroup.controls["bankruptcy"].value,
      this.firstFormGroup.controls["loanTenure"].value
    );
  }
}
