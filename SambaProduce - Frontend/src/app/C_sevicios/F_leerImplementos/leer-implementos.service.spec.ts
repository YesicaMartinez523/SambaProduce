import { TestBed } from '@angular/core/testing';

import { LeerImplementosService } from './leer-implementos.service';

describe('LeerImplementosService', () => {
  let service: LeerImplementosService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LeerImplementosService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
