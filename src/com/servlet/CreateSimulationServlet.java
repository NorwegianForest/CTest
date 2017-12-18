package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.DBQuery.DataProcess;;

/**
 * Servlet implementation class CreateSimulationServlet
 */
@WebServlet("/CreateSimulationServlet")
public class CreateSimulationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateSimulationServlet() {
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
	    
	    String title = request.getParameter("title");
	    String type = (String) request.getSession().getAttribute("type");
	    
	    if (DataProcess.titleExist(title, "simulation") || DataProcess.titleExist(title, "questions")) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("error_simulation_exist.jsp");			
			requestDispatcher.forward(request,response); 	    	
	    } 
	    else {
		    DataProcess.addSimulation(title, type);
		    DataProcess.createSimulationTable(title);
		    
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("success.jsp");			
			requestDispatcher.forward(request,response);
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
