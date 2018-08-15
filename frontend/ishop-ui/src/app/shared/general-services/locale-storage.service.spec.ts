import { TestBed, inject } from '@angular/core/testing';

import { LocaleStorageService } from './locale-storage.service';

describe('LocaleStorageService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [LocaleStorageService]
    });
  });

  it('should be created', inject([LocaleStorageService], (service: LocaleStorageService) => {
    expect(service).toBeTruthy();
  }));
});
