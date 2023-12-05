import { TestBed } from '@angular/core/testing';

import { LeerTipoCategoriasServiceService } from './leer-tipo-categorias-service.service';

describe('LeerTipoCategoriasServiceService', () => {
  let service: LeerTipoCategoriasServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LeerTipoCategoriasServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
