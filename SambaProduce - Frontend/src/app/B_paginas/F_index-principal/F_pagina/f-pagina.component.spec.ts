import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FPaginaComponent } from './f-pagina.component';

describe('FPaginaComponent', () => {
  let component: FPaginaComponent;
  let fixture: ComponentFixture<FPaginaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FPaginaComponent]
    });
    fixture = TestBed.createComponent(FPaginaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
