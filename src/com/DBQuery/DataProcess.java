package com.DBQuery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataProcess {
	
	DataProcess(){}
	
	public static Connection getConnection()	{
		String CLASSFORNAME="com.mysql.jdbc.Driver";	  
		String SERVANDDB = "jdbc:mysql://localhost:3306/ctest2?user=root&password=root&useUnicode=true&characterEncoding=gb2312";
		Connection con;
		try	{
			Class.forName(CLASSFORNAME);			
			con = DriverManager.getConnection(SERVANDDB);			
			return con;
		}catch(Exception e){
			e.printStackTrace();			
			return null;
		}
	}
	
	public static int nCount(String SQL){
		Connection myConnection = getConnection();
		int count = 0;		
		try	{
			Statement stm = myConnection.createStatement();			
			ResultSet result = stm.executeQuery(SQL);			
			if(result.next()){
				count = result.getInt(1);				
				result.close();
			}			
			stm.close();			
			myConnection.close();		
		}catch(Exception e){
			e.printStackTrace();
		}		
		return count;
	}
	

	
	/**插入或删除语句*/
	public static void ExeQuery(String SQL){
		Connection con = getConnection();
		try{
			Statement stmt = con.createStatement();			
			stmt.executeUpdate(SQL);			
			stmt.close();			
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static ResultSet getResult(String SQL,Connection con){		
		ResultSet rs = null;		
		try{
			Statement stmt = con.createStatement();			
			rs = stmt.executeQuery(SQL);			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return rs;		
	}
	
	public static String getSingleResult(String sql, String fieldName) {//返回单一结果
		String result = null;
		Connection con = DataProcess.getConnection();
		try {
			Statement state = con.createStatement();
			ResultSet rs = state.executeQuery(sql);
			rs.next();
			result = rs.getString(fieldName);
			rs.close();
			state.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static void CloseConnection(Connection con){
		try	{
			con.close();
		}catch(Exception e)	{
			e.printStackTrace();
		}
	}
	
	public static void CloseResultSet(ResultSet rs){
		try	{
			rs.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void updateDatabase(String sql) {
		Connection con = DataProcess.getConnection();
		try {
			Statement state = con.createStatement();
			state.executeUpdate(sql);
			state.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean titleExist(String title, String tableName) {//判断以title为标题的模拟卷是否存在，在tableName表中查找
		String sql = "select * from " + tableName + " where title='" + title + "'";
		Connection con = DataProcess.getConnection();
		try {
			Statement state = con.createStatement();
			ResultSet rs = state.executeQuery(sql);
			if (rs.next()) {//rs有下一个，说明该标题的模拟卷存在，返回真
				rs.close();
				state.close();
				con.close();
				return true;
			}
			rs.close();
			state.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public static boolean paperTitleExist(String paper_title, String tableName) {//判断以title为标题的模拟卷是否存在，在tableName表中查找
		String sql = "select * from " + tableName + " where paper_title='" + paper_title + "'";
		Connection con = DataProcess.getConnection();
		try {
			Statement state = con.createStatement();
			ResultSet rs = state.executeQuery(sql);
			if (rs.next()) {//rs有下一个，说明该标题的模拟卷存在，返回真
				rs.close();
				state.close();
				con.close();
				return true;
			}
			rs.close();
			state.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}	
	
	public static void addSimulation(String title, String type) { //添加模拟试题到表simulation
		String sql = "insert into simulation(title,exam_type)values('" + title + "','" + type + "')";
		Connection con = DataProcess.getConnection();
		Statement state;
		try {
			state = (Statement) con.createStatement();
			state.executeUpdate(sql);
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void createSimulationTable(String tableName) {//创建模拟试题表
		String sql = "CREATE TABLE `" + tableName + "` (\r\n" + 
				"`id`  mediumint(8) NOT NULL AUTO_INCREMENT ,\r\n" + 
				"`title`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,\r\n" + 
				"`a_option`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,\r\n" + 
				"`b_option`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,\r\n" + 
				"`c_option`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,\r\n" + 
				"`d_option`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,\r\n" + 
				"`answer`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,\r\n" + 
				"PRIMARY KEY (`id`)\r\n" + 
				")";
		Connection con = DataProcess.getConnection();
		Statement state;
		try {
			state = (Statement) con.createStatement();
			state.executeUpdate(sql);
			state.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean userExist(String username) {
		String sql = "select * from users where username='" + username + "'";
		Connection con = DataProcess.getConnection();
		try {
			Statement state = con.createStatement();
			ResultSet rs = state.executeQuery(sql);
			if (rs.next()) {
				rs.close();
				state.close();
				con.close();
				
				return true;
			}
			
			rs.close();
			state.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public static ResultSet GetQuestionListByID(String id) {
		String strSql = new String("select * from questions where id=\"" + id + "\"");
		Connection con = DataProcess.getConnection();
		ResultSet rs = DataProcess.getResult(strSql, con);
		String table_name = null;
		try {
			rs.next();
			table_name = rs.getString("table_name");
			rs.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String sql = new String("select * from " + table_name);
		Connection con1 = DataProcess.getConnection();
		ResultSet rs1 = DataProcess.getResult(sql, con1);	
		return rs1;
	}
	
	public static int getCount(String id) {
		int count = 0;
		String strSql = new String("select * from questions where id=\"" + id + "\"");
		Connection con = DataProcess.getConnection();
		ResultSet rs = DataProcess.getResult(strSql, con);
		String table_name = null;
		try {
			rs.next();
			table_name = rs.getString("table_name");
			rs.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String sql = new String("select count(*) from " + table_name);
		Connection con1 = DataProcess.getConnection();
		ResultSet rs1 = DataProcess.getResult(sql, con1);
		try {
			rs1.next();
			count = Integer.parseInt(rs1.getString("count(*)"));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
}
