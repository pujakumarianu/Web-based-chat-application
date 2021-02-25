package com.chatapplication.dao;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.chatapplication.controller.Message;
import com.chatapplication.util.DbUtil;
import com.google.gson.Gson;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class SearchDao {

	public static List getSearch(String messageText,String user_id) {
		List list=new ArrayList();
		Connection con=DbUtil.getConnection();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			PreparedStatement pst=con.prepareStatement("select message,send_date from (select message,send_date,user_id,message_id from private_messages union select message,send_date,user_id,message_id from public_messages) as t where user_id=? and message=? ");
			pst.setInt(1, Integer.parseInt(user_id));
			pst.setString(2, messageText);
			ResultSet rs=pst.executeQuery();
			
			
			while(rs.next()){
				Message msg=new Message();
				msg.setDate(rs.getString("send_date"));
				msg.setMessage(rs.getString("message"));
				list.add(msg);
			}
			
			}
			
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	

}
