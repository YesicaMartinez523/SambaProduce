import { TestBed } from '@angular/core/testing';

import { GuardarLocalIdCategoriaService } from './guardar-local-id-categoria.service';

describe('GuardarLocalIdCategoriaService', () => {
  let service: GuardarLocalIdCategoriaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GuardarLocalIdCategoriaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
