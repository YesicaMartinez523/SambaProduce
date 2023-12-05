import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BSeccionDosComponent } from './b-seccion-dos.component';

describe('BSeccionDosComponent', () => {
  let component: BSeccionDosComponent;
  let fixture: ComponentFixture<BSeccionDosComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BSeccionDosComponent]
    });
    fixture = TestBed.createComponent(BSeccionDosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
