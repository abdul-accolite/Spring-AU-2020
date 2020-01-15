import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ReactFormComponent } from './react-form/react-form.component';
import { DispFormComponent } from './disp-form/disp-form.component';
import { ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    AppComponent,
    ReactFormComponent,
    DispFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
