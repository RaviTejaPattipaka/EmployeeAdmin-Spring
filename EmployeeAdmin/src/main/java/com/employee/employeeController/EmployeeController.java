package com.employee.employeeController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/employees")
public class EmployeeController {
private List<Employee> employees = new ArrayList<Employee>();
EmployeeController() {
this.employees = buildEmployees();
}
@RequestMapping(method = RequestMethod.GET)
public List<Employee> getEmployees() {
return this.employees;
}
@RequestMapping(value = "/{empNo}", method = RequestMethod.GET)
public Employee getEmployee(@PathVariable("empNo") Long empNo) {
return this.employees.stream().filter(emp -> emp.getEmpNo() == empNo).findFirst().orElse(null);
}
@RequestMapping(method = RequestMethod.POST)
public List<Employee> saveEmployee(@RequestBody Employee emp) {
Long nextId = 0L;
if (this.employees.size() != 0) {
Employee lastEmp = this.employees.stream().skip(this.employees.size() - 1).findFirst().orElse(null);
nextId = lastEmp.getEmpNo() + 1;
}
emp.setEmpNo(nextId);
this.employees.add(emp);
return this.employees;
}
@RequestMapping(value = "/{empNo}", method = RequestMethod.DELETE)
public List<Employee> deleteEmployee(@PathVariable Long empNo) {
for(Iterator<Employee> itr=this.employees.iterator();itr.hasNext();)
{
Employee emp = itr.next();
Long inId = emp.getEmpNo();
if(inId == (empNo)){
itr.remove();
}
}
return this.employees;
}
List<Employee> buildEmployees() {
List<Employee> emps = new ArrayList<>();
Employee emp1 = buildEmployee(1L, "venu", "Test");
Employee emp2 = buildEmployee(2L, "krishna", "Veni");
emps.add(emp1);
emps.add(emp2);
return emps;
}
Employee buildEmployee(Long empNo, String firstName, String lastName) {
Employee emp = new Employee(empNo, firstName,lastName);
return emp;
}
}