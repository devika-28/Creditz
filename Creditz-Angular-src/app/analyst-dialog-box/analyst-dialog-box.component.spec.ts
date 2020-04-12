import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AnalystDialogBoxComponent } from './analyst-dialog-box.component';

describe('AnalystDialogBoxComponent', () => {
  let component: AnalystDialogBoxComponent;
  let fixture: ComponentFixture<AnalystDialogBoxComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AnalystDialogBoxComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AnalystDialogBoxComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
