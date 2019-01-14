import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmpComponentComponent } from './emp-component/emp-component.component';
import { MyIfDirective } from './my-if.directive';
import { DeptComponentComponent } from './dept-component/dept-component.component';
import { EmpListComponentComponent } from './emp-list-component/emp-list-component.component';
import { EmpServiceService } from './emp-service.service';
import { HttpClientModule } from '@angular/common/http';
import { EmpDescComponentComponent } from './emp-desc-component/emp-desc-component.component';
import { EmpFormComponentComponent } from './emp-form-component/emp-form-component.component';
import { DeptFormComponentComponent } from './dept-form-component/dept-form-component.component';
import { DeptListComponentComponent } from './dept-list-component/dept-list-component.component';

@NgModule({
  declarations: [
    AppComponent,
    EmpComponentComponent,
    MyIfDirective,
    DeptComponentComponent,
    EmpListComponentComponent,
    EmpDescComponentComponent,
    EmpFormComponentComponent,
    DeptFormComponentComponent,
    DeptListComponentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [EmpServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
