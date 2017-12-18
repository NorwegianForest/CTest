package com.business;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.DBQuery.DataProcess;

public class QuestionsList {
	private String id;
	private String table_name;
	private int nCount;
	private String out;
	public QuestionsList(){}
	public QuestionsList(String id) {
		this.id = id;
		String strSql = new String("select * from questions where id=\"" + this.id + "\"");
    	Connection con = DataProcess.getConnection();
    	ResultSet rs = DataProcess.getResult(strSql, con);
    	try {
			rs.next();
			this.table_name = rs.getString("table_name");
			rs.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	String sql = new String("select * from " + this.table_name);
    	Connection con1 = DataProcess.getConnection();
    	ResultSet rs1 = DataProcess.getResult(sql, con1);
    	try {
			this.out = "<table>";
			while(rs1.next()) {
			this.out +=	"<tr><td>" + rs1.getString("id") + ".&nbsp;&nbsp;" + rs1.getString("title") + "</tr></td>" +
					"<tr><td>" + rs1.getString("a_option") + "</td></tr>" +
					"<tr><td>" + rs1.getString("b_option") + "</td></tr>" +
					"<tr><td>" + rs1.getString("c_option") + "</td></tr>" +
					"<tr><td>" + rs1.getString("d_option") + "</td></tr>" + "<tr><td>&nbsp;&nbsp;</td></tr>";
			}
			this.out += "</table>";
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public String getTableName() {
		return this.table_name;
	}
	public int getNCount() {
		return this.nCount;
	}
	public String getOut() {
		return this.out;
	}
}
