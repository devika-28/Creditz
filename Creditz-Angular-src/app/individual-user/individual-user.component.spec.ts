import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IndividualUserComponent } from './individual-user.component';

describe('IndividualUserComponent', () => {
  let component: IndividualUserComponent;
  let fixture: ComponentFixture<IndividualUserComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IndividualUserComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IndividualUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
