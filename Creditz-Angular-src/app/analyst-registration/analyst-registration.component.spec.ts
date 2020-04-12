import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AnalystRegistrationComponent } from './analyst-registration.component';

describe('AnalystRegistrationComponent', () => {
  let component: AnalystRegistrationComponent;
  let fixture: ComponentFixture<AnalystRegistrationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AnalystRegistrationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AnalystRegistrationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
