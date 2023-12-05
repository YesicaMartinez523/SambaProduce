import { TestBed } from '@angular/core/testing';

import { CrearRegistroActividadService } from './crear-registro-actividad.service';

describe('CrearRegistroActividadService', () => {
  let service: CrearRegistroActividadService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CrearRegistroActividadService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
