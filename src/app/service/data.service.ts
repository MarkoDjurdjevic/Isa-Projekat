import { Injectable } from '@angular/core';
import { Centre } from '../model/centre';

@Injectable({ providedIn: 'root' })
export class DataService {
  private centres: Centre[] = [];

  getCentres(): Centre[] {
    return this.centres;
  }

  setCentres(centres: Centre[]) {
    this.centres = centres;
  }
}
