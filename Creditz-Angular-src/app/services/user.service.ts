import { Injectable } from "@angular/core";
import { HttpParams } from "@angular/common/http";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Router } from "@angular/router";

@Injectable({
  providedIn: "root",
})
export class UserService {
  constructor(private http: HttpClient) {}

  deleteAnalyst(userEmail: any): Observable<any> {
    let params = new HttpParams().set("userEmail", userEmail);
    return this.http.delete("http://localhost:9999/deleteAnalyst", { params });
  }

  updateUser(userEmail: any, password: any): Observable<any> {
    const body = { userEmail: userEmail, password: password };
    return this.http.post(
      "http://localhost:9999/updateUserPassword",
      this.createBasicAuthToken(userEmail, password)
    );
  }

  createBasicAuthToken(username: String, password: String) {
    return "Basic " + window.btoa(username + ":" + password);
  }

  findUserByEmailAndPassword(userEmail: any, password: any): Observable<any> {
    return this.http.post(
      "http://localhost:9999/verifyUser",
      this.createBasicAuthToken(userEmail, password)
    );
  }

  findUserByUserEmail(userEmail: any): Observable<any> {
    let params = new HttpParams().set("userEmail", userEmail);
    return this.http.get("http://localhost:9999/checkUniqueUser", { params });
  }
}
