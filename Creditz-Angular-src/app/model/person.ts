import { User } from "./user";

export class Person {
  personId: number;
  personName: String;
  contact: String;
  address: String;
  user: User;
  constructor(
    personId: number,
    personName: String,
    contact: String,
    address: String,
    user: User
  ) {}
}
