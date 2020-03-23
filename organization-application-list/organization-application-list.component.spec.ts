import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OrganizationApplicationListComponent } from './organization-application-list.component';

describe('OrganizationApplicationListComponent', () => {
  let component: OrganizationApplicationListComponent;
  let fixture: ComponentFixture<OrganizationApplicationListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OrganizationApplicationListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OrganizationApplicationListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
