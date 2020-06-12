import { Component, OnInit, ViewChild } from "@angular/core";
import { MatSort } from "@angular/material/sort";
import { MatPaginator, PageEvent } from "@angular/material/paginator";
import { MatTableDataSource } from "@angular/material/table";
import { OrganizationApplicationService } from "../services/organization-application.service";

@Component({
  selector: "app-organization-creditor-table-list",
  templateUrl: "./organization-creditor-table-list.component.html",
  styleUrls: ["./organization-creditor-table-list.component.css"],
})
export class OrganizationCreditorTableListComponent implements OnInit {
  store = window.sessionStorage.getItem("userId");
  storeRole = window.sessionStorage.getItem("role");
  displayedColumns: string[] = [
    "applicationId",
    "organizationName",
    "contact",
    "address",
    "loanAmount",
    "loanTenure",
    "applicationStatus",
    "emailStatus",
  ];
  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(MatPaginator) paginator: MatPaginator;
  dataSource = new MatTableDataSource<any[]>();
  searchKey: String;
  length = 1000;
  pageSizeOptions: number[] = [10, 20, 25, 100, 150, 200];
  pageSize = 10;

  setPageSizeOptions(setPageSizeOptionsInput: string) {
    if (setPageSizeOptionsInput) {
      this.pageSizeOptions = setPageSizeOptionsInput
        .split(",")
        .map((str) => +str);
    }
  }
  constructor(
    private organizataionApplication: OrganizationApplicationService
  ) {}
  ngOnInit() {
    this.organizataionApplication
      .findAllOrganizationApplication()
      .subscribe((stream) => {
        this.dataSource.data = stream as any;
        this.dataSource.paginator = this.paginator;
      });
  }

  ngAfterViewInit() {
    this.dataSource.sort = this.sort;
  }
  applyFilter(filterValue: string) {
    filterValue = filterValue.trim(); // Remove whitespace
    filterValue = filterValue.toLowerCase(); // MatTableDataSource defaults to lowercase matches
    this.dataSource.filter = filterValue;
  }
  onSearchClear() {
    this.searchKey = "";
  }
}
