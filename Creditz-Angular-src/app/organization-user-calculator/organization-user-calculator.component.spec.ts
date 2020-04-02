import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OrganizationUserCalculatorComponent } from './organization-user-calculator.component';

describe('OrganizationUserCalculatorComponent', () => {
  let component: OrganizationUserCalculatorComponent;
  let fixture: ComponentFixture<OrganizationUserCalculatorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OrganizationUserCalculatorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OrganizationUserCalculatorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
