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
 * Servlet implementation class AddQuestionServlet
 */
@WebServlet("/AddQuestionServlet")
public class AddQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddQuestionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
	    response.setContentType("text/html");  
	    response.setCharacterEncoding("utf-8");
	    request. setCharacterEncoding("UTF-8");
	    
	    String title = request.getParameter("title");
	    String option_a = request.getParameter("option_a");
	    String option_b = request.getParameter("option_b");
	    String option_c = request.getParameter("option_c");
	    String option_d = request.getParameter("option_d");
	    
		String answer = null;
		switch(request.getParameter("key")) {
		case "A":answer = "1";break;
		case "B":answer = "2";break;
		case "C":answer = "3";break;
		case "D":answer = "4";break;
		default:break;
		}
		
		String id = (String) request.getSession().getAttribute("id");
		String tableName = "chapter_" + id;
		
		Connection con = DataProcess.getConnection();
		Statement state;
		try {
			state = (Statement) con.createStatement();
			String sql = "insert into " + tableName + "(title,a_option,b_option,c_option,d_option,answer)values("
					+ "'" + title + "',"
					+ "'" + option_a + "',"
					+ "'" + option_b + "',"
					+ "'" + option_c + "',"
					+ "'" + option_d + "',"
					+ "'" + answer + "')";
			state.executeUpdate(sql);
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("edit.jsp?id=" + id);			
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
