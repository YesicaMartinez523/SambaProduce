import { TestBed } from '@angular/core/testing';

import { LeerMaquinariaPorIdService } from './leer-maquinaria-por-id.service';

describe('LeerMaquinariaPorIdService', () => {
  let service: LeerMaquinariaPorIdService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LeerMaquinariaPorIdService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
