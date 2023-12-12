import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HPaginaComponent } from './h-pagina.component';

describe('HPaginaComponent', () => {
  let component: HPaginaComponent;
  let fixture: ComponentFixture<HPaginaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [HPaginaComponent]
    });
    fixture = TestBed.createComponent(HPaginaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
