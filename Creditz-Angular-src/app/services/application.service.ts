import {Injectable} from "@angular/core";
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
@Injectable(
    {
        providedIn: 'root'
    }
)
export class ApplicationService {
    
    constructor(private http:HttpClient) {
    
 }

   findAllTopIndividualCreditors(): Observable<any> {
        console.log("hello");
        return this.http.get("http://localhost:9999/getTopPersonApplicants");
            
}
findAllTopOrganizationCreditors(): Observable<any> {
    console.log("hello");
    return this.http.get("http://localhost:9999/getTopOrganizationApplicants");
        
}
   
}