package com.chatapplication.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.chatapplication.util.DbUtil;

public class RemovePrivateMessageDao {

	
	public static boolean removePrivateMessage(int message_id) {
		boolean result=false;
		
		Connection con=DbUtil.getConnection();
		
		try {
			PreparedStatement pst=con.prepareStatement("delete from private_messages where message_id=?");
			pst.setInt(1, message_id);
			int i=pst.executeUpdate();
			if(i>0) {
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
