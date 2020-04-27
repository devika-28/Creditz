import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OrganizationalUserComponent } from './organizational-user.component';

describe('OrganizationalUserComponent', () => {
  let component: OrganizationalUserComponent;
  let fixture: ComponentFixture<OrganizationalUserComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OrganizationalUserComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OrganizationalUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
