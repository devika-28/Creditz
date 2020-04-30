import { User } from './user';
import { Organization } from './organization';

export class OrganizationApplicant
{
    pancard:string;
    loanAmount:number;
    revenue:number;
    employeeCount:number;
    businessAge:number;
    licenseNumber:string;    
    organizationType:string;
    applicationStatus:string;
    criminalRecord:number;
    bankruptcy:number;
    loanTenure:number;
    organizationId:number; 
    userId:number;
    applicationDate:Date;
    applicationTime:string;
    constructor( 
        pancard:string,
        loanAmount:number,
        revenue:number,
        employeeCount:number,
        businessAge:number,
        licenseno:string,  
        organizationType:string,
        applicationStatus:string,
        criminalRecord:number,
        bankruptcy:number,
        loanTenure:number,
         ){}
    
}

    
   
    
   