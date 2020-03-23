import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OurPoliciesComponent } from './our-policies.component';

describe('OurPoliciesComponent', () => {
  let component: OurPoliciesComponent;
  let fixture: ComponentFixture<OurPoliciesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OurPoliciesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OurPoliciesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
