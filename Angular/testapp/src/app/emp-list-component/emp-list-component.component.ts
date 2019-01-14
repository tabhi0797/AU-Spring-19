import { Component, OnInit, Input } from '@angular/core';
import { EmpServiceService } from '../emp-service.service';


class EmpApiResponce {
  name: string;
  id: number;
  email: string;
  dob: string;
}


@Component({
  selector: 'app-emp-list-component',
  templateUrl: './emp-list-component.component.html',
  styleUrls: ['./emp-list-component.component.css']
})
export class EmpListComponentComponent implements OnInit {

  users: Object;

  @Input()
  employees: string[];

  @Input() noOfRecords: number;

  constructor(private empService: EmpServiceService) { }

  ngOnInit() {

    this.empService.getUsers().subscribe(data => {
      this.users = data;
    });

  }

}
