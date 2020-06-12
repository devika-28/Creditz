import { TestBed } from "@angular/core/testing";

import { IndividualApplicationService } from "./individual-application.service";

describe("IndividualApplicationService", () => {
  let service: IndividualApplicationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(IndividualApplicationService);
  });

  it("should be created", () => {
    expect(service).toBeTruthy();
  });
});
