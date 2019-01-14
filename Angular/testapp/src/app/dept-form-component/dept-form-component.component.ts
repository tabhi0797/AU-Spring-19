import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-dept-form-component',
  templateUrl: './dept-form-component.component.html',
  styleUrls: ['./dept-form-component.component.css']
})
export class DeptFormComponentComponent implements OnInit {

  registerForm: FormGroup;
  submitted = false;

  constructor(private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      deptName: ['', Validators.required],
      deptID: ['', Validators.required],
      noOfStaff: ['', [Validators.required, Validators.min(2)]],
    });
  }

  get f() { return this.registerForm.controls; }


  onSubmit() {
    this.submitted = true;
    if (this.registerForm.invalid) {
      return;
    }
    console.log(this.f);
    alert('Department Info Submitted');
  }

}
