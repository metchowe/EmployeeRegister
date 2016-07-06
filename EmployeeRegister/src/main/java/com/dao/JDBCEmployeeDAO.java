package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.db.MysqlConnect;
import com.model.Employee;


public class JDBCEmployeeDAO implements EmployeeDAO {
	private MysqlConnect dataSource;

	public void setDataSource(MysqlConnect db) {
		this.dataSource = db;
	}

	public JDBCEmployeeDAO() {
		setDataSource(MysqlConnect.getDbCon());
	}

	public int insert(String fName) {

		String sql = "INSERT INTO employee.employers " + "(first_name) VALUES ('" + fName + "')";
		int result = 0;
		try {
			result = dataSource.insert(sql);
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return result;
	}
	
	public int delete(int id) {

		String sql = "DELETE FROM employee.employers where id='"+id+"'";
		int result = 0;
		try {
			result = dataSource.insert(sql);
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return result;
	}

	public ArrayList<Employee> Searh(String name) {

		ArrayList<Employee> employers = new ArrayList<Employee>();
		String sql = "SELECT * FROM employee.employers WHERE first_name REGEXP '^" + name +  "' ";

		ResultSet rs;
		try {
			rs = dataSource.query(sql);
			while (rs.next()) {

	
				employers.add(new Employee(rs.getString("first_name")).setID(rs.getInt("id")));
			}

			rs.close();
			dataSource.stopStatment();
		} catch (SQLException e) {

		}
		return employers;
	}

	public int update(int id, String name) {
		// TODO Auto-generated method stub
	
		
		
		String sql = "UPDATE  employee.employers  SET first_name='"+name+"' where id='"+id+"'";
		int result = 0;
		try {
			result = dataSource.insert(sql);
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return result;
	}


}
