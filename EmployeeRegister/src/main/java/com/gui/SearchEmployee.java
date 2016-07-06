package com.gui;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.JDBCEmployeeDAO;
import com.google.gson.Gson;
import com.model.Employee;

/**
 * Servlet implementation class main
 */

@WebServlet("/SearchEmployee")
public class SearchEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String sName = request.getParameter("sName");
		System.out.println(sName);
		JDBCEmployeeDAO da = new JDBCEmployeeDAO();
		ArrayList<Employee> result = da.Searh(sName);

		// Set response content type
		response.setContentType("text/html");

		Gson gson = new Gson();
		String json = gson.toJson(result);
		System.out.println(json);
		// Actual logic goes here.
		PrintWriter out = response.getWriter();
		out.println(json);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}