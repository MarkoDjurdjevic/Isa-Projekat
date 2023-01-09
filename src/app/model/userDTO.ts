import { GenderEnum } from '../enums/genderEnum';
import { UserCategoryEnum } from '../enums/userCategoryEnum';
import { UserRoleEnum } from '../enums/userRoleEnum';
import { Centre } from './centre';

export interface UsersDTO {
  password: string;
  name: string;
  lastname: string;
  adress: string;
  city: string;
  country: string;
  phone: string;
  jmbg: string;
  profession: string;
  information: string;
}
