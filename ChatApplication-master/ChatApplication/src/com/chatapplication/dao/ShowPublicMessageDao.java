package com.chatapplication.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.chatapplication.controller.Message;
import com.chatapplication.util.DbUtil;
import com.google.gson.Gson;

public class ShowPublicMessageDao {

	public static List showPublicMessages() {
		List list=new ArrayList();
		Connection con=DbUtil.getConnection();
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			PreparedStatement pst=con.prepareStatement("select firstname,user.user_id, message,send_date,message_id from public_messages inner join user where public_messages.user_id=user.user_id");
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				Message msg=new Message();
				msg.setMessage_firstname(rs.getString("firstname"));
				msg.setMessage(rs.getString("message"));
				msg.setDate(rs.getString("send_date"));
				msg.setMessage_id(rs.getInt("message_id"));
				msg.setUser_id(rs.getInt("user_id"));
				list.add(msg);
			}
			
			
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		return list;
	}
	
}
