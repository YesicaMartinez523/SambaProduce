import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ASeccionUnoComponent } from './a-seccion-uno.component';

describe('ASeccionUnoComponent', () => {
  let component: ASeccionUnoComponent;
  let fixture: ComponentFixture<ASeccionUnoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ASeccionUnoComponent]
    });
    fixture = TestBed.createComponent(ASeccionUnoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
