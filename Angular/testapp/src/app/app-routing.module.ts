import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EmpComponentComponent } from './emp-component/emp-component.component';
import { DeptComponentComponent } from './dept-component/dept-component.component';
import { EmpDescComponentComponent } from './emp-desc-component/emp-desc-component.component';
import { EmpFormComponentComponent } from './emp-form-component/emp-form-component.component';
import { DeptFormComponentComponent } from './dept-form-component/dept-form-component.component';

const routes: Routes = [
  {path: 'employee', component: EmpComponentComponent},
  {path: 'employee/:employeeid', component: EmpDescComponentComponent},
  {path: 'dept', component: DeptComponentComponent},
  {path: 'newEmp' , component: EmpFormComponentComponent},
  {path: 'newDept' , component: DeptFormComponentComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
