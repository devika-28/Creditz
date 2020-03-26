import {Injectable} from "@angular/core";
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
@Injectable()
export class PersonService {
    // private url = "http//:localhost:9092/api";
    constructor(private http:HttpClient) {
    
 }

   findAllTopIndividualCreditors(): Observable<any> {
        console.log("hello");
        return this.http.get("http://localhost:9999/api/getPerson");
            
}
findApplicationByAppliId(userid:Number):Observable<any>
    {
        const params = new HttpParams()
       .set('userId', userid+"");
        return this.http.get("http://localhost:9999/api/getPersonApplicant",{params});
             
    }
}