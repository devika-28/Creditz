import {Injectable} from "@angular/core";
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable(
    {
    providedIn: 'root'
    }
)
export class OrganizationApplicationService {
    
    constructor(private http:HttpClient) {
}

    findAllIndividualApplication(): Observable<any> {
        // const params = new HttpParams()
        // .set('pageNo', pageNo+"")
        // .append('pageSize', pageSize+"");
         return this.http.get("http://localhost:9999/getPersonApplicants");
            
    }
    findAllOrganizationApplication(): Observable<any>
    {
      return this.http.get("http://localhost:9999/getOrganizationApplicants");
             
    }

    

   
}
