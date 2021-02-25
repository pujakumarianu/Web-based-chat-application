package com.chatapplication.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.chatapplication.util.DbUtil;

public class EditPrivateMessagesDao {

	public static boolean editPrivateMessages(String message,String message_id) {
		boolean result=false;
		Connection con=DbUtil.getConnection();
		try {
			PreparedStatement pst=con.prepareStatement("update private_messages set message=? where message_id=?");
			pst.setString(1,message);
			pst.setInt(2,Integer.parseInt(message_id));
			int i=pst.executeUpdate();
			
			if(i>0) {
				result=true;
				
			}
			else {
				result=false;
				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		return result;
	}
	
}
