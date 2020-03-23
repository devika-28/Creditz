import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PersonApplicationListComponent } from './person-application-list.component';

describe('PersonApplicationListComponent', () => {
  let component: PersonApplicationListComponent;
  let fixture: ComponentFixture<PersonApplicationListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PersonApplicationListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PersonApplicationListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
