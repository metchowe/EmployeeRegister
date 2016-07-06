package com.dao;

import java.util.ArrayList;


import com.model.Employee;

public interface EmployeeDAO {
	public int insert(String fName) ;
	public int delete(int id) ;
	public int update(int id,String name) ;
	public ArrayList<Employee> Searh(String fName) ;
	
}
