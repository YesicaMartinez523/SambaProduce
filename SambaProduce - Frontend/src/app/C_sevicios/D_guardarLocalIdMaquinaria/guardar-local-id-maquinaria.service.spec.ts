import { TestBed } from '@angular/core/testing';

import { GuardarLocalIdMaquinariaService } from './guardar-local-id-maquinaria.service';

describe('GuardarLocalIdMaquinariaService', () => {
  let service: GuardarLocalIdMaquinariaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GuardarLocalIdMaquinariaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
