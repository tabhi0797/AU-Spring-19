import { Component, OnInit } from '@angular/core';
import { DeptServiceService } from '../dept-service.service';
@Component({
  selector: 'app-dept-list-component',
  templateUrl: './dept-list-component.component.html',
  styleUrls: ['./dept-list-component.component.css']
})
export class DeptListComponentComponent implements OnInit {

  depts: any;
  constructor(private deptService: DeptServiceService) { }

  ngOnInit() {

    this.deptService.getDepts().subscribe(data => {
      this.depts = data;
    });

  }

}
