import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { ActivatedRoute } from '@angular/router';
import { EmployeeServiceService } from '../employee-service.service';

@Component({
  selector: 'app-employee-details',
  templateUrl: './employee-details.component.html',
  styleUrls: ['./employee-details.component.css']
})
export class EmployeeDetailsComponent implements OnInit{
  id:number = 0;
  employee:Employee = new Employee();

  constructor(private route:ActivatedRoute, private employeeService:EmployeeServiceService){}
  
  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.employeeService.getEmployeeById(this.id).subscribe(data=>{
      this.employee = data;
    })
  }

}
