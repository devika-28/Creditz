import { Component, OnInit, ViewChild } from "@angular/core";
import { MatTableDataSource } from "@angular/material/table";
import { HistoryService } from "../services/history.service";
import { MatSort, Sort } from "@angular/material/sort";

export interface History {
  applicationId: bigint;
  loanAmount: Number;
  applicationStatus: String;
  loanTenure: Number;
  emailStatus: String;
}

const ELEMENT_DATA: History[] = [];

@Component({
  selector: "app-history",
  templateUrl: "./history.component.html",
  styleUrls: ["./history.component.css"],
})
export class HistoryComponent implements OnInit {
  store = window.sessionStorage.getItem("userId");
  constructor(private historyService: HistoryService) {}

  dataSource = new MatTableDataSource(ELEMENT_DATA);
  displayedColumns = [
    "date",
    "applicationId",
    "loanAmount",
    "loanTenure",
    "applicationStatus",
  ];

  @ViewChild(MatSort, { static: false }) sort: MatSort;

  ngOnInit() {
    this.historyService
      .showHistory(window.sessionStorage.getItem("userId"))
      .subscribe((history: History[]) => {
        history.forEach((i) => {
          status = "Pending: Contact customer care.";
          switch (i["applicationStatus"]) {
            case "Rejected":
              status =
                "Rejected: Please see out privacy policy for further insight.";
              break;
            case "Rejected Bad History":
              status =
                "Rejected: An issue with past credit history, Please contact CIBIL Dispute Resolution.";
              break;
            case "Rejected Low Credits":
              status = "Rejected: Low credits.";
              break;
            case "Approved":
              status = "Approved: Application Approved.";
              break;
            case "Rejected Amount Declined":
              status = "Rejected: The amount is Declined.";
              break;
            case "Pending Internal Error":
              status = "Pending: Contact customer care.";
              break;
            case "Record Not Found":
              status = "Rejected: It looks like you are new to CIBIL.";
              break;
            case "Rejected Early":
              status =
                "Rejected: Apply after six months from the date of the last application.";
              break;
          }
          var temp = {
            applicationId: i["applicationId"],
            loanAmount: i["loanAmount"],
            loanTenure: i["loanTenure"],
            applicationStatus: status,
            emailStatus: i["emailStatus"],
            date: i["date"],
          };
          ELEMENT_DATA.push(temp);
        });
      });

    this.dataSource.sort = this.sort;

    const sortState: Sort = { active: "applicationId", direction: "desc" };
    this.sort.direction = sortState.direction;
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }
}
