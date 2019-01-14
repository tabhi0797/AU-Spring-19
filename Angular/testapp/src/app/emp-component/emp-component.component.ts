import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-emp-component',
  templateUrl: './emp-component.component.html',
  styleUrls: ['./emp-component.component.css']
})
export class EmpComponentComponent implements OnInit {

  nameOfEmp: string;
  date: Date;
  printPayables: boolean;
  payables: string[];
  noOfRows: number;


  constructor() {
  }


  ngOnInit() {
   this.date = new Date();
   this.nameOfEmp = 'abhi';
   this.payables = ['one', 'two', 'three'];
   this.printPayables = false;
   this.noOfRows = 10;
  }

  changeNameOfEmp() {
    this.nameOfEmp = 'abhinav';
    alert('changing name of emp');
    return 'function returned';
  }

}
