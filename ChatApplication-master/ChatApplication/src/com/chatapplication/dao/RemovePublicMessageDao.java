package com.chatapplication.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.chatapplication.util.DbUtil;

public class RemovePublicMessageDao {

	public static boolean removePublicMessage(int message_id,String user_id) {
		boolean result=false;
		Connection con=DbUtil.getConnection();
		
		try {
			PreparedStatement pst=con.prepareStatement("delete from public_messages where message_id=? and user_id=?");
			pst.setInt(1, message_id);
			System.out.println(message_id);
			pst.setInt(2, Integer.parseInt(user_id));
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
