package com.chatapplication.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.chatapplication.util.DbUtil;

public class EditPublicMessageDao {

	public static boolean editPublicMessage(String message[],String user_id,String actualMessage) {
		boolean result=false;
		
		
		Connection con=DbUtil.getConnection();
		try {
			PreparedStatement pst=con.prepareStatement("update public_messages set message=? where message_id=? and user_id=?");
			pst.setString(1,actualMessage);
			pst.setInt(2,Integer.parseInt(message[0].toString()));
			pst.setInt(3, Integer.parseInt(user_id));
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
