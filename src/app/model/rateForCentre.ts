import { User } from "./user";

export class RateForCentre {
    rate: number;
    constructor(obj?: any) {
      if (obj) {
        this.rate = obj.rate;
      }
    }
  }