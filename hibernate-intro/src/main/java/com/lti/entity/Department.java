package com.lti.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TBL_DEPARTMENT")
public class Department {

	@Id
	@GeneratedValue
	
private int deptNo;
private String dname;
private String location;

public int getDeptNo() {
	return deptNo;
}
public void setDeptNo(int deptNo) {
	this.deptNo = deptNo;
}
@OneToMany(mappedBy="deptnum",cascade=CascadeType.ALL)
private Set<Employee>employees;
public String getDname() {
	return dname;
}
public void setDname(String dname) {
	this.dname = dname;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public Set<Employee> getEmployees() {
	return employees;
}
public void setEmployees(Set<Employee> employees) {
	this.employees = employees;
}

}
