package com.chatapplication.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.chatapplication.util.DbUtil;

public class RegisterDao {

	public static boolean Register(String username,String password,String firstname,String lastname) {
		boolean result=false;
		Connection con=DbUtil.getConnection();
		try {
			PreparedStatement pst=con.prepareStatement("insert into user(username,password,firstname,lastname) values(?,?,?,?)");
			pst.setString(1, username);
			pst.setString(2, password);
			pst.setString(3, firstname);
			pst.setString(4, lastname);
			int rs=pst.executeUpdate();
			
			if(rs>0) {
				result=true;
			}
			else {
				result=false;
			}
			con.close();
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	
	
}
