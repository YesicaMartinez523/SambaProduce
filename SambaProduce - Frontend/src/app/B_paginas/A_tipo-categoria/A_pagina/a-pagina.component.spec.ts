import { ComponentFixture, TestBed } from '@angular/core/testing';

import { APaginaComponent } from './a-pagina.component';

describe('APaginaComponent', () => {
  let component: APaginaComponent;
  let fixture: ComponentFixture<APaginaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [APaginaComponent]
    });
    fixture = TestBed.createComponent(APaginaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
