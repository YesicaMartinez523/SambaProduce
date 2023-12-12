import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GPaginaComponent } from './g-pagina.component';

describe('GPaginaComponent', () => {
  let component: GPaginaComponent;
  let fixture: ComponentFixture<GPaginaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [GPaginaComponent]
    });
    fixture = TestBed.createComponent(GPaginaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
