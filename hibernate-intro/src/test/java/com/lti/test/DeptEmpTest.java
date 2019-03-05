package com.lti.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.lti.dao.GenericDao;
import com.lti.entity.Department;
import com.lti.entity.Employee;

public class DeptEmpTest {

	@Test
	public void TestDept() {
		
		Department dept = new Department();
dept.setDeptNo(10);
dept.setDname("Production");
dept.setLocation("delhi");

Department dept1 = new Department();
dept1.setDeptNo(20);
dept1.setDname("Electrical");
dept1.setLocation("mumbai");

Department dept2 = new Department();
dept2.setDeptNo(30);
dept2.setDname("IT");
dept2.setLocation("hyderabad");
GenericDao dao=new GenericDao();
		dao.merge(dept);
		dao.merge(dept1);
		dao.merge(dept2);

	}

	@Test
	public void addEmploye() {
GenericDao dao = new GenericDao();
Department dept=dao.fetch(Department.class,10);
Department dept1=dao.fetch(Department.class,20);
Department dept2=dao.fetch(Department.class,30);

Employee emp = new Employee();
emp.setEmpNo(10);
emp.setName("Male");
emp.setSalary(2000);
emp.setDeptnum(dept);

Employee emp1 = new Employee();
emp1.setEmpNo(20);
emp1.setName("F");
emp1.setSalary(3000);
emp1.setDeptnum(dept1);

Employee emp2 = new Employee();
emp2.setEmpNo(30);
emp2.setName("F");
emp2.setSalary(3400);
emp2.setDeptnum(dept2);

dao.merge(emp);
dao.merge(emp1);
dao.merge(emp2);
	}
}


