package com.service.employee;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class SupportCase {

	@ManyToOne
	@JoinColumn(name = "emp_id" , referencedColumnName = "id")
	private Employee emp;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="sid")
	private int sid;
	
	@Column(name="emp_id")
	private int emp_id;
	
	@Column(name="date")
	private Date date_of_expense;
	
	@Column(name="method")
	private String payment_method;
	
	@Column(name="purpose")
	private String purpose;
	
	@Column(name="status")
	private String status;
	
	SupportCase(){
		
	}
	
	

	public SupportCase(Date date_of_expense, String payment_method, String purpose, String status) {
		
		this.date_of_expense = date_of_expense;
		this.payment_method = payment_method;
		this.purpose = purpose;
		this.status = status;
	}



	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public Date getDate_of_expense() {
		return date_of_expense;
	}

	public void setDate_of_expense(Date date_of_expense) {
		this.date_of_expense = date_of_expense;
	}

	public String getPayment_method() {
		return payment_method;
	}

	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
}
