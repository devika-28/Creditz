import { async, ComponentFixture, TestBed } from "@angular/core/testing";

import { ApplicationSubmittionComponent } from "./application-submittion.component";

describe("ApplicationSubmittionComponent", () => {
  let component: ApplicationSubmittionComponent;
  let fixture: ComponentFixture<ApplicationSubmittionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ApplicationSubmittionComponent],
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ApplicationSubmittionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it("should create", () => {
    expect(component).toBeTruthy();
  });
});
