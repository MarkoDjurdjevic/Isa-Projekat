import { Centre } from "./centre";

export class User {
  id: number = 0;
  email: string = '';
  password:string='';
  username:string='';
  active:boolean=true;
  role:any='';
  address:string = '';
  jmbg:string = '';
  gender:any='';
  name:string = '';
  lastname:string = '';
  phoneNumber:string = '';





  public constructor(obj?: any) {
    if (obj) {
      this.email = obj.email;
      this.password = obj.password;
      this.id = obj.id;
      this.username = obj.username;
      this.active = true;
      this.role = obj.role;
      this.address = obj.address;
      this.jmbg = obj.jmbg;
      this.gender = obj.gender;
      this.name= obj.name;
      this.lastname = obj.lastname;
      this.phoneNumber = obj.phoneNumber;
    }
  }
}
