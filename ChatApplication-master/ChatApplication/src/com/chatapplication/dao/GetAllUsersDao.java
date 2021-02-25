package com.chatapplication.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import com.chatapplication.controller.Message;
import com.chatapplication.util.DbUtil;
import com.google.gson.Gson;

public class GetAllUsersDao {

	public static List getAllUsers() {
		Connection con=DbUtil.getConnection();
		List list=new ArrayList();
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			PreparedStatement pst=con.prepareStatement("select firstname,user_id,lastname from user");
			ResultSet rs=pst.executeQuery();
			
			while(rs.next()) {
				Message msg=new Message();
				msg.setUser_id(rs.getInt("user_id"));
				msg.setMessage_firstname(rs.getString("firstname"));
				msg.setLastname(rs.getString("lastname"));
				list.add(msg);
			}
			
			con.close();
		}
		catch(Exception e ) {
			e.printStackTrace();
			
		}
	return list;
	
	}
	
}
