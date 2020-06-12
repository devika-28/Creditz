import { Injectable } from "@angular/core";
import { HttpClient, HttpParams } from "@angular/common/http";
import { Observable } from "rxjs";
import { User } from "../model/user";

@Injectable({
  providedIn: "root",
})
export class MailService {
  constructor(private http: HttpClient) {}

  sendMail(userEmail: any, password: any): Observable<any> {
    const params = new HttpParams()
      .set("userEmail", userEmail)
      .append("password", password);
    return this.http.get("http://localhost:9999/send-mail", { params });
  }
}
