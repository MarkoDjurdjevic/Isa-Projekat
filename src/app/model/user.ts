import { GenderEnum } from '../enums/genderEnum';
import { UserCategoryEnum } from '../enums/userCategoryEnum';
import { UserRoleEnum } from '../enums/userRoleEnum';
import { Centre } from './centre';

export interface Users {
  id: number;
  email: string;
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
  category: UserCategoryEnum;
  centre: Centre;
  genderEnum: GenderEnum;
  userRoleEnum: UserRoleEnum;
}
