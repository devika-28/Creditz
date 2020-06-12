import { async, ComponentFixture, TestBed } from "@angular/core/testing";

import { OrganizationCreditorTableListComponent } from "./organization-creditor-table-list.component";

describe("OrganizationCreditorTableListComponent", () => {
  let component: OrganizationCreditorTableListComponent;
  let fixture: ComponentFixture<OrganizationCreditorTableListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [OrganizationCreditorTableListComponent],
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OrganizationCreditorTableListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it("should create", () => {
    expect(component).toBeTruthy();
  });
});
