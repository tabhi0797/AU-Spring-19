import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { EmpServiceService } from '../emp-service.service';

@Component({
  selector: 'app-emp-desc-component',
  templateUrl: './emp-desc-component.component.html',
  styleUrls: ['./emp-desc-component.component.css']
})
export class EmpDescComponentComponent implements OnInit {

  @Input() userid: string;
  emp: any;

  constructor(private empService: EmpServiceService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.userid = this.route.snapshot.paramMap.get('employeeid');
    this.empService.getUserInfo(this.userid).subscribe(data => {
      this.emp = data;
    });
  }

}
