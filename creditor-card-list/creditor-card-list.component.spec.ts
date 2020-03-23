import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreditorCardListComponent } from './creditor-card-list.component';

describe('CreditorCardListComponent', () => {
  let component: CreditorCardListComponent;
  let fixture: ComponentFixture<CreditorCardListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreditorCardListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreditorCardListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
