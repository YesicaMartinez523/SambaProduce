import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DSeccionCuatroComponent } from './d-seccion-cuatro.component';

describe('DSeccionCuatroComponent', () => {
  let component: DSeccionCuatroComponent;
  let fixture: ComponentFixture<DSeccionCuatroComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DSeccionCuatroComponent]
    });
    fixture = TestBed.createComponent(DSeccionCuatroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
