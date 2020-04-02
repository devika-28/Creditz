import { TestBed } from '@angular/core/testing';

import { OrganizationUserApplicationService } from './organization-user-application.service';

describe('OrganizationUserApplicationService', () => {
  let service: OrganizationUserApplicationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OrganizationUserApplicationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
