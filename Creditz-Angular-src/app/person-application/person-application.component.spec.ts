import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PersonApplicationComponent } from './person-application.component';

describe('PersonApplicationComponent', () => {
  let component: PersonApplicationComponent;
  let fixture: ComponentFixture<PersonApplicationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PersonApplicationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PersonApplicationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
