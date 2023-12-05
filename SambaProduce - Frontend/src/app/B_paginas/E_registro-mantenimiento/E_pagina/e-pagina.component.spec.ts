import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EPaginaComponent } from './e-pagina.component';

describe('EPaginaComponent', () => {
  let component: EPaginaComponent;
  let fixture: ComponentFixture<EPaginaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EPaginaComponent]
    });
    fixture = TestBed.createComponent(EPaginaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
