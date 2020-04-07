import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import { Observable } from 'rxjs';

@Injectable(
    {
    providedIn: 'root'
    }
)
export class ScheduleService {
    
    constructor(private http:HttpClient) {
}

     scheduleEmailUpdatePersonApplicant():Observable<any>{
     return this.http.get("http://localhost:9999/sendUpdatePerson");
            
    }
    scheduleEmailUOdateOrganizaionApplicant():Observable<any>
    {
      return this.http.get("http://localhost:9999/sendUpdateOrganization");
    }

   
}
