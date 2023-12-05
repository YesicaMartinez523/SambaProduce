import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BPaginaComponent } from './b-pagina.component';

describe('BPaginaComponent', () => {
  let component: BPaginaComponent;
  let fixture: ComponentFixture<BPaginaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BPaginaComponent]
    });
    fixture = TestBed.createComponent(BPaginaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
