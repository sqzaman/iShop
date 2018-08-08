import { TestBed, inject } from '@angular/core/testing';

import { Globals } from './globals.service';

describe('GlobalsService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [Globals]
    });
  });

  it('should be created', inject([Globals], (service: Globals) => {
    expect(service).toBeTruthy();
  }));
});
