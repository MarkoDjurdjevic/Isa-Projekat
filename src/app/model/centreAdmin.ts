import { User } from "./user";

export class CentreAdmin extends User {
    centre: any;
    terms: any[];
  
    constructor(obj?: any) {
      super(obj);
      if (obj) {
        this.centre = 1;
        this.terms = obj.rateForCenters;
      }
    }
  }