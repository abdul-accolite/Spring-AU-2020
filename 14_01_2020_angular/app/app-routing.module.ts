import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ReactFormComponent } from './react-form/react-form.component';
import { DispFormComponent } from './disp-form/disp-form.component';

const routes: Routes = [
  {path:"fillForm", component:ReactFormComponent},
  {path:"dispForm", component:DispFormComponent},
  {path:"**", redirectTo:""}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
