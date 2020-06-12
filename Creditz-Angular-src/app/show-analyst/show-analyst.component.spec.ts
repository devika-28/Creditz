import { async, ComponentFixture, TestBed } from "@angular/core/testing";

import { ShowAnalystComponent } from "./show-analyst.component";

describe("ShowAnalystComponent", () => {
  let component: ShowAnalystComponent;
  let fixture: ComponentFixture<ShowAnalystComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ShowAnalystComponent],
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowAnalystComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it("should create", () => {
    expect(component).toBeTruthy();
  });
});
