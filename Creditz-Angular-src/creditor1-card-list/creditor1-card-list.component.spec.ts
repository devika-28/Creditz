import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Creditor1CardListComponent } from './creditor1-card-list.component';

describe('Creditor1CardListComponent', () => {
  let component: Creditor1CardListComponent;
  let fixture: ComponentFixture<Creditor1CardListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Creditor1CardListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Creditor1CardListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
