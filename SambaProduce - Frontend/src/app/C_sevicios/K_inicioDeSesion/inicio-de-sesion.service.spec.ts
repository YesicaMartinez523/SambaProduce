import { TestBed } from '@angular/core/testing';

import { InicioDeSesionService } from './inicio-de-sesion.service';

describe('InicioDeSesionService', () => {
  let service: InicioDeSesionService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(InicioDeSesionService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
