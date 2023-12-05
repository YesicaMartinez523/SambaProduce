import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DPaginaComponent } from './d-pagina.component';

describe('DPaginaComponent', () => {
  let component: DPaginaComponent;
  let fixture: ComponentFixture<DPaginaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DPaginaComponent]
    });
    fixture = TestBed.createComponent(DPaginaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
