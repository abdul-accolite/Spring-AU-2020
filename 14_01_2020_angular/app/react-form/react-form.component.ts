import { Component, OnInit } from '@angular/core';
import { FormControl,FormGroup, Validators } from '@angular/forms';

import { ServiceService } from '../service.service';

@Component({
  selector: 'app-react-form',
  templateUrl: './react-form.component.html',
  styleUrls: ['./react-form.component.scss']
})
export class ReactFormComponent implements OnInit {
  myForm= new FormGroup({
    Name: new FormControl(''),
    email: new FormControl('',Validators.email)
  })
  constructor(public service: ServiceService) { }

  ngOnInit() {
    console.log("hello react-form");
  }
  doThis()
  {
      this.service.name=this.myForm.value.Name;
      this.service.email=this.myForm.value.email;
  }

}
