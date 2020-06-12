import { async, ComponentFixture, TestBed } from "@angular/core/testing";

import { CreditorTableListComponent } from "./creditor-table-list.component";

describe("CreditorTableListComponent", () => {
  let component: CreditorTableListComponent;
  let fixture: ComponentFixture<CreditorTableListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [CreditorTableListComponent],
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreditorTableListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it("should create", () => {
    expect(component).toBeTruthy();
  });
});
