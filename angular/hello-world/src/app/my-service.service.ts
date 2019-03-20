import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MyServiceService {

  constructor() { }

  getColors(){
    return ["Red","Green","Blue"]
  }
}
