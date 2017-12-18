package com.business;

import com.DBQuery.DataProcess;

public class Admin_Manager {
	public static boolean CheckAdmin(String username,String password){
		String query = "select count(*) from admin where admin.name='"+username+
						"' and admin.password='"+password+"'";
		int count = DataProcess.nCount(query);
		if(count>0)	{
			return true;
		}else
			return false;
	}
	public static boolean CheckUser(String username,String password){
		String query = "select count(*) from users where users.username='"+username+
						"' and users.password='"+password+"'";
		int count = DataProcess.nCount(query);
		if(count>0)	{
			return true;
		}else
			return false;
	}	
}
