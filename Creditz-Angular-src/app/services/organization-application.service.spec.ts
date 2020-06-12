import { TestBed } from "@angular/core/testing";

import { OrganizationApplicationService } from "./organization-application.service";

describe("OrganizationApplicationService", () => {
  let service: OrganizationApplicationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OrganizationApplicationService);
  });

  it("should be created", () => {
    expect(service).toBeTruthy();
  });
});
