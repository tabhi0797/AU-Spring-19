import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';

@Component({
  selector: 'app-emp-form-component',
  templateUrl: './emp-form-component.component.html',
  styleUrls: ['./emp-form-component.component.css']
})
export class EmpFormComponentComponent implements OnInit {

  genders = ['male', 'female'];
  model = new Employee(undefined, '', '', '');
  onSubmit() {
    console.log(this.model);
    alert('Employee Info Submitted');
  }

  constructor() { }

  ngOnInit() {
  }

}
