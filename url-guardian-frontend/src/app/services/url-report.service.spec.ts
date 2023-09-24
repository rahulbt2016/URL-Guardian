import { TestBed } from '@angular/core/testing';

import { UrlReportService } from './url-report.service';

describe('UrlReportService', () => {
  let service: UrlReportService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UrlReportService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
