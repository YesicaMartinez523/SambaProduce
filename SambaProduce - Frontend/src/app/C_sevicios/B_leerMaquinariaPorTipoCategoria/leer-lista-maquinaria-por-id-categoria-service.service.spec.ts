import { TestBed } from '@angular/core/testing';

import { LeerListaMaquinariaPorIdCategoriaServiceService } from './leer-lista-maquinaria-por-id-categoria-service.service';

describe('LeerListaMaquinariaPorIdCategoriaServiceService', () => {
  let service: LeerListaMaquinariaPorIdCategoriaServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LeerListaMaquinariaPorIdCategoriaServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
