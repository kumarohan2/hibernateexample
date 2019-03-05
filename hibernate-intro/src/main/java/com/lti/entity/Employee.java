package com.lti.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TBL_EMPLOYE")


public class Employee {
	
	
	@Id
	@GeneratedValue
	private int empNo;
	private String name;
	private int salary;
	
	@ManyToOne
	@JoinColumn(name="depNo")
	private Department deptnum;
	
	public Department getDeptnum() {
		return deptnum;
	}
	public void setDeptnum(Department deptnum) {
		this.deptnum = deptnum;
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}


}
