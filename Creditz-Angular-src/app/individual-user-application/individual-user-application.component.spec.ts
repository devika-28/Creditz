import { async, ComponentFixture, TestBed } from "@angular/core/testing";

import { IndividualUserApplicationComponent } from "./individual-user-application.component";

describe("IndividualUserApplicationComponent", () => {
  let component: IndividualUserApplicationComponent;
  let fixture: ComponentFixture<IndividualUserApplicationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [IndividualUserApplicationComponent],
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IndividualUserApplicationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it("should create", () => {
    expect(component).toBeTruthy();
  });
});
