import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CSeccionTresComponent } from './c-seccion-tres.component';

describe('CSeccionTresComponent', () => {
  let component: CSeccionTresComponent;
  let fixture: ComponentFixture<CSeccionTresComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CSeccionTresComponent]
    });
    fixture = TestBed.createComponent(CSeccionTresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
