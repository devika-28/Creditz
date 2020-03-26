import {Injectable} from "@angular/core";
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
@Injectable()
export class OrganizationService {
    
    constructor(private http:HttpClient) {
}

    findAllTopOrganizationCreditors(): Observable<any> {
        return this.http.get("http://localhost:9999/api/getOrganization")
            
    }
    findApplicationByAppliId(organizationid:Number):Observable<any>
    {
        const params = new HttpParams()
        .set('userId', organizationid+"");
        return this.http.get("http://localhost:9999/api/getOrganizationApplicant",{params});
             
    }

   
}
