package com.chatapplication.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.chatapplication.controller.Message;
import com.chatapplication.util.DbUtil;
import com.google.gson.Gson;

public class GetPrivateMessageDao {

	public static List getPrivateMessage(String user_id) {
		List list=new ArrayList();
		Connection con=DbUtil.getConnection();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			PreparedStatement pst=con.prepareStatement("select message,message_id,send_date from private_messages where user_id=?");
			pst.setInt(1, Integer.parseInt(user_id));
			ResultSet rs=pst.executeQuery();
			
			while(rs.next()){
				Message msg=new Message();
				msg.setMessage_id(rs.getInt("message_id"));
				msg.setMessage(rs.getString("message"));
				msg.setDate(rs.getString("send_date"));
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
