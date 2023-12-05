import { TestBed } from '@angular/core/testing';

import { LeerMantenimientosPorMaquinaService } from './leer-mantenimientos-por-maquina.service';

describe('LeerMantenimientosPorMaquinaService', () => {
  let service: LeerMantenimientosPorMaquinaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LeerMantenimientosPorMaquinaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
