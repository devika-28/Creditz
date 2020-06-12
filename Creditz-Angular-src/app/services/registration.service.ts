import { Injectable } from "@angular/core";
import { HttpClient, HttpParams } from "@angular/common/http";
import { Person } from "../model/person";
import { Organization } from "../model/organization";
import { Observable } from "rxjs";

@Injectable({
  providedIn: "root",
})
export class RegistrationService {
  private _url = "http://localhost:9999/api";
  constructor(private _http: HttpClient) {}

  registerPerson(person: Person) {
    person.user.role = "Person";
    return this._http.post<any>(`${this._url}/save_person`, person);
  }

  registerOrganization(organization: Organization) {
    organization.user.role = "Organization";
    return this._http.post<any>(`${this._url}/save_organization`, organization);
  }

  sendotp(userEmail: any): Observable<any> {
    let params = new HttpParams().set("userEmail", userEmail);
    return this._http.get(`${this._url}/otp`, { params });
  }
}
