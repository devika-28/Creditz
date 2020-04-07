import { User } from './user';

export class Organization
{
    organizationId:number;
    organizationName:String; 
    contact:String;
    address:String;
    directorName:String;
    user:User;
    // constructor( user:User){ }

    constructor(
        organizationId:number,
        organizationName:String,
        contact:String,
        address:String,
        directorName:String,
        user:User){}
}
