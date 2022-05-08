import { TestBed } from '@angular/core/testing';

import { DepotDeGarantiesService } from './depot-de-garanties.service';

describe('DepotDeGarantiesService', () => {
  let service: DepotDeGarantiesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DepotDeGarantiesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
