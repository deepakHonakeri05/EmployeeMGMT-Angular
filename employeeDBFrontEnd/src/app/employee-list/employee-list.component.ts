import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { EmployeeServiceService } from '../employee-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit{

  constructor (private employeeService : EmployeeServiceService, private router : Router){}
  ngOnInit(): void {
    this.getEmployees();
  }
  employee:Employee[] = [];

  getEmployees(){
    this.employeeService.getEmployeeList().subscribe(data => {this.employee = data;})
  }

  updateEmployee(id:number){
    this.router.navigate(['update-employee',id])
  }

  deleteEmployee(id:number){
    this.employeeService.deleteEmployee(id).subscribe(data=>{
      console.log(data);
      this.getEmployees();
    },error=>console.log(error));
    
  }

  viewEmployee(id:number){
    this.router.navigate(['employee-details',id])
  }
}
