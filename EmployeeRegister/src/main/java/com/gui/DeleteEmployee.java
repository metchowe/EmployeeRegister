package com.gui;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.JDBCEmployeeDAO;

/**
 * Servlet implementation class main
 */

@WebServlet("/deleteEmployee")
public class DeleteEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		int id = Integer.parseInt(request.getParameter("id"));
		JDBCEmployeeDAO da = new JDBCEmployeeDAO();
		int result=da.delete(id);
		
	      // Set response content type
	      response.setContentType("text/html");
	      String message="Smth got wrong";
if(result==1){
	message="successfully completed deleting";
}
	      // Actual logic goes here.
	      PrintWriter out = response.getWriter();
	      out.println("<h1>"+message+"</h1>");

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
