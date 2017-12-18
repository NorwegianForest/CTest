package com.taglib;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.DBQuery.DataProcess;

public class EditSimulationTag extends TagSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String method;
	
	public void setMethod(String method) {
		this.method = method;
	}

	public int doEndTag() throws JspException {
		JspWriter out = pageContext.getOut();
		
		String sql = "select * from simulation";
		Connection con = DataProcess.getConnection();
		ResultSet rs = DataProcess.getResult(sql, con);
		
		try {
			out.print("<table align=left>");
			while (rs.next()) {
				String title = rs.getString("title");
				out.print("<tr><td><a href=\"edit_simulation.jsp?title=" + title + "\">" + title + "</a></td></tr>");
			}
			out.print("</table>");
			rs.close();
			con.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("method=" + method);
		return SKIP_BODY;
	}
}
