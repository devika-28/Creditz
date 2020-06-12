import { async, ComponentFixture, TestBed } from "@angular/core/testing";

import { FinancialAnalystComponent } from "./financial-analyst.component";

describe("FinancialAnalystComponent", () => {
  let component: FinancialAnalystComponent;
  let fixture: ComponentFixture<FinancialAnalystComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [FinancialAnalystComponent],
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FinancialAnalystComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it("should create", () => {
    expect(component).toBeTruthy();
  });
});
