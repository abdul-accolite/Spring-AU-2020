import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {
  name:any="";
  email:any="";
  
  constructor() { }
  serviceRunning(){
    console.log("yes service is running");
  }

}
