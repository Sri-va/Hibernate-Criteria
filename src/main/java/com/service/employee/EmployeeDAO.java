package com.service.employee;

import java.util.List;

public interface EmployeeDAO {

	public void viewInfo();
	public String checkLogin(String name, String password);
	public String submitRequest();
	public List viewpendingRequests();
	public List resolvedRequests();
	public String updateInfo();
}
