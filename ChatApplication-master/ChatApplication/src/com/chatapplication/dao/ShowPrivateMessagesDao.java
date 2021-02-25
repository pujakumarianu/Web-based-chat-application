package com.chatapplication.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.chatapplication.controller.Message;
import com.chatapplication.util.DbUtil;
import com.google.gson.Gson;

public class ShowPrivateMessagesDao {

	public static List showPrivateMessages(String user_id) {
		
		List list=new ArrayList();
		Connection con=DbUtil.getConnection();
		try {
			PreparedStatement pst=con.prepareStatement("select message,send_date,fro,message_id from private_messages where to_id=?");
			pst.setInt(1, Integer.parseInt(user_id));
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				Message msg=new Message();
				msg.setDate(rs.getString("send_date"));
				msg.setMessage(rs.getString("message"));
				msg.setfromMessage(rs.getString("fro"));
				msg.setMessage_id(rs.getInt("message_id"));
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
