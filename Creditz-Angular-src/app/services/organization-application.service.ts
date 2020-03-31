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

    findAllIndividualApplication(pageNo:Number ,pageSize:Number): Observable<any> {
        const params = new HttpParams()
        .set('pageNo', pageNo+"")
        .append('pageSize', pageSize+"");
         return this.http.get("http://localhost:9999/getPersonApplicants",{params});
            
    }
    findAllOrganizationApplication(pageNo: any ,pageSize: any): Observable<any>
    {
        const params = new HttpParams()
        .set('pageNo', pageNo+"")
        .append('pageSize', pageSize+"");
         return this.http.get("http://localhost:9999/getOrganizationApplicants",{params});
             
    }

   
}
