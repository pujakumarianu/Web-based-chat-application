package com.chatapplication.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpSession;

import com.chatapplication.util.DbUtil;

public class LoginDao {

	public static int user_id;
	public static String firstname;
	
	public static boolean login(String username, String password) {
		Connection con=DbUtil.getConnection();
		boolean result=false;
		try {
			
			PreparedStatement pst=con.prepareStatement("select username,password,firstname,user_id from user where username=? and password=?");
			pst.setString(1, username);
			pst.setString(2, password);
			ResultSet rs=pst.executeQuery();
			
			if(rs.next()) {
				
				LoginDao.user_id=rs.getInt("user_id");
				LoginDao.firstname=rs.getString("firstname");				
				result= true;
			}
			else {
				result= false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
