import { Component } from '@angular/core';
import { Employee } from '../employee';
import { EmployeeServiceService } from '../employee-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent {
  employee : Employee = new Employee();

  constructor(private emplService : EmployeeServiceService, private router : Router){}

  onSubmit(){
    this.saveEmployee();
  }
  saveEmployee(){
    this.emplService.addEmployee(this.employee).subscribe(data=>{
      console.log(data);
      this.goToEmployeeList();
    }, 
    error=>console.log(error))
  }

  goToEmployeeList(){
    this.router.navigate(['/employees'])
  }

}
