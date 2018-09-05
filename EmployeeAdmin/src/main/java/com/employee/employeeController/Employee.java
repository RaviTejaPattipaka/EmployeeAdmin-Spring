package com.employee.employeeController;

import java.io.Serializable;

public class Employee implements Serializable {
private static final long serialVersionUID = -8809089768201955649L;
private Long empNo;
private String firstName;
private String lastName;
public Employee(Long empNo1, String firstName1, String lastName1) {
	this.empNo =empNo1;
	this.firstName = firstName1;
	this.lastName = lastName1;
}
/**
 * @return the empNo
 */
public Long getEmpNo() {
	return empNo;
}
/**
 * @param empNo the empNo to set
 */
public void setEmpNo(Long empNo) {
	this.empNo = empNo;
}
/**
 * @return the firstName
 */
public String getFirstName() {
	return firstName;
}
/**
 * @param firstName the firstName to set
 */
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
/**
 * @return the lastName
 */
public String getLastName() {
	return lastName;
}
/**
 * @param lastName the lastName to set
 */
public void setLastName(String lastName) {
	this.lastName = lastName;
}


}