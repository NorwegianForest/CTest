package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DBQuery.DataProcess;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class EditSimulationServlet
 */
@WebServlet("/EditSimulationServlet")
public class EditSimulationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditSimulationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
	    response.setContentType("text/html");  
	    response.setCharacterEncoding("utf-8");
	    request. setCharacterEncoding("UTF-8");
	    
		String[] title = request.getParameterValues("title");		
		String[] option_a = request.getParameterValues("option_a");
		String[] option_b = request.getParameterValues("option_b");
		String[] option_c = request.getParameterValues("option_c");
		String[] option_d = request.getParameterValues("option_d");
		String tableName = (String) request.getSession().getAttribute("tableName");
		
		int n = 0;
		Connection con = DataProcess.getConnection();
		Statement state;
		try {
			state = (Statement) con.createStatement();
			state.executeUpdate("truncate " + tableName);
			state.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		while(n < title.length) {			
			String answer = null;
			switch(request.getParameter(String.valueOf(n+1))) {
			case "A":answer = "1";break;
			case "B":answer = "2";break;
			case "C":answer = "3";break;
			case "D":answer = "4";break;
			default:break;
			}			
			try {		
				Connection con1 = DataProcess.getConnection();
				Statement state1 = (Statement) con1.createStatement();
				String sql = "insert into " + tableName + "(title,a_option,b_option,c_option,d_option,answer)values("
						+ "'" + title[n] + "',"
						+ "'" + option_a[n] + "',"
						+ "'" + option_b[n] + "',"
						+ "'" + option_c[n] + "',"
						+ "'" + option_d[n] + "',"
						+ "'" + answer + "')";
				state1.executeUpdate(sql);
				con1.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			n ++;
		}

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("success.jsp");			
		requestDispatcher.forward(request,response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
