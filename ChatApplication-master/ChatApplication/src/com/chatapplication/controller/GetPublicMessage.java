package com.chatapplication.controller;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import org.json.JSONObject;
import com.chatapplication.util.DbUtil;
import com.google.gson.Gson;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns="/getpublicmessage")
public class GetPublicMessage extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application/json");
		HttpSession ss=req.getSession(false);
		
		Connection con=DbUtil.getConnection();
		JSONObject obj=new JSONObject();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			PreparedStatement pst=con.prepareStatement("select message,message_id,send_date from public_messages where user_id=?");
			pst.setInt(1, Integer.parseInt(ss.getAttribute("user_id").toString()));
			ResultSet rs=pst.executeQuery();
			List list=new ArrayList();
			while(rs.next()){
				Message msg=new Message();
				msg.setMessage_id(rs.getInt("message_id"));
				msg.setMessage(rs.getString("message"));
				msg.setDate(rs.getString("send_date"));
				list.add(msg);
			}
			
			String json=new Gson().toJson(list);
			res.getWriter().write(json);
			con.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	
}
