import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CPaginaComponent } from './c-pagina.component';

describe('CPaginaComponent', () => {
  let component: CPaginaComponent;
  let fixture: ComponentFixture<CPaginaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CPaginaComponent]
    });
    fixture = TestBed.createComponent(CPaginaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
