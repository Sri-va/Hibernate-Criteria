package com.service.employee;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Employee implements EmployeeDAO {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="firstname")
	private String first_name;
	
	@Column(name="lastname")
	private String last_name;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name ="salary")
	private double salary;
	
	@Column(name="email")
	private String email;
	
	@Column(name="phonenum")
	private String phonenum;
	
	@OneToMany(mappedBy = "Employee")
	private List<SupportCase> cases;
	
	Employee(){
		
	}
	
	
	public Employee(String first_name, String last_name, String username, String password, double salary, String email,
			String phonenum) {
		
		this.first_name = first_name;
		this.last_name = last_name;
		this.username = username;
		this.password = password;
		this.salary = salary;
		this.email = email;
		this.phonenum = phonenum;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhonenum() {
		return phonenum;
	}


	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}


	@Override
	public void viewInfo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String checkLogin(String name, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String submitRequest() {
		// TODO Auto-generated method stub
		SupportCase s=new SupportCase();
		s.setDate_of_expense(new Date());
		s.setEmp(this);
		s.setPayment_method("Creditcard");
		s.setPurpose("Test");
		cases.add(s);
		return "Submitted sucessfully";
	}

	@Override
	public List<SupportCase> viewpendingRequests() {
		// TODO Auto-generated method stub
		return cases;
	}

	@Override
	public List<SupportCase> resolvedRequests() {
		// TODO Auto-generated method stub
		return cases;
	}

	@Override
	public String updateInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	

	
}
