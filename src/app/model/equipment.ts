export class Equipment {
    nameEquipment: string='';
    quantitiofEquipment: string = '';
   
    constructor(obj?: any) {
      if (obj) {

        this.nameEquipment = obj.nameEquipment;
        this.quantitiofEquipment = obj.quantitiofEquipment;
       
      }
    }
  }