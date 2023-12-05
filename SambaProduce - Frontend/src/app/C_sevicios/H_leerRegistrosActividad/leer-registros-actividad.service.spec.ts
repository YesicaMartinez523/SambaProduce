import { TestBed } from '@angular/core/testing';

import { LeerRegistrosActividadService } from './leer-registros-actividad.service';

describe('LeerRegistrosActividadService', () => {
  let service: LeerRegistrosActividadService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LeerRegistrosActividadService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
