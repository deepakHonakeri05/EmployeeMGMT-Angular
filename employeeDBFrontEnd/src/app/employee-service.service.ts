import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from './employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeServiceService {

  private baseURL : String = "http://localhost:8080/api/v1/employees";

  constructor(private httpClient:HttpClient) {
    
  }

  getEmployeeList() : Observable<Employee[]>{
    return this.httpClient.get<Employee[]>(`${this.baseURL}`);
  }

  addEmployee(employee : Employee):Observable<Object>{
    return this.httpClient.post('http://localhost:8080/api/v1/add',employee);
  }

  getEmployeeById(id:number) : Observable<Employee>{
    return this.httpClient.get<Employee>('http://localhost:8080/api/v1/employee/'+id);
  }

  updateEmployee(id:number, employee:Employee) : Observable<Object>{
    return this.httpClient.put('http://localhost:8080/api/v1/employee/'+id,employee);
  }

  deleteEmployee(id:number) : Observable<Object>{
    return this.httpClient.delete('http://localhost:8080/api/v1/employee/'+id);
  }
}
