import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CollapsedComponent } from './collapsed.component';

describe('CollapsedComponent', () => {
  let component: CollapsedComponent;
  let fixture: ComponentFixture<CollapsedComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CollapsedComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CollapsedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
