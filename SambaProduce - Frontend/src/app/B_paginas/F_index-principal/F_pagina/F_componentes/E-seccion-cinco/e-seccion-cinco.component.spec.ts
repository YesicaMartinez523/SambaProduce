import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ESeccionCincoComponent } from './e-seccion-cinco.component';

describe('ESeccionCincoComponent', () => {
  let component: ESeccionCincoComponent;
  let fixture: ComponentFixture<ESeccionCincoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ESeccionCincoComponent]
    });
    fixture = TestBed.createComponent(ESeccionCincoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
