import { Component, OnInit } from '@angular/core';

import { ServiceService } from '../service.service';
@Component({
  selector: 'app-disp-form',
  templateUrl: './disp-form.component.html',
  styleUrls: ['./disp-form.component.scss']
})
export class DispFormComponent implements OnInit {
  name:any;
  email:any;
  constructor(public service: ServiceService) { 
    
  }

  ngOnInit() {
    //this.service.serviceRunning();
    console.log("hello");
    this.name=this.service.name;
    this.email=this.service.email; 
    //console.log(this.name);
   // console.log(this.email);
  }
 
}
