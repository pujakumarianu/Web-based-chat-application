package com.chatapplication.controller;

import javax.servlet.*;

import javax.servlet.http.*;
import com.chatapplication.util.DbUtil;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.servlet.annotation.*;
import java.io.*;

@WebServlet(urlPatterns="/shareMessage")
public class ShareMessage extends HttpServlet{

	
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		PrintWriter out=res.getWriter();
		res.setContentType("text/html");
		String messageText=req.getParameter("text_form");
		String messagePrivate=req.getParameter("checkbox_form");
		
		
		//System.out.print(date_format);
		
		
		HttpSession ss=req.getSession(false);
		Connection con=DbUtil.getConnection();
		
		try {
			String firstname="";
			String lastname="";
			PreparedStatement pst1=con.prepareStatement("select firstname,lastname from user where user_id=?");
			pst1.setInt(1, Integer.parseInt(ss.getAttribute("user_id").toString()));
			ResultSet rst=pst1.executeQuery();
			if(rst.next()) {
				firstname=rst.getString("firstname");
				lastname=rst.getString("lastname");
			}
			
			//Code for sending message to user when private or not
			
		if(messagePrivate==null){
			DateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			java.util.Date date=new java.util.Date();
			String date_format=dateFormat.format(date);
			PreparedStatement pst=con.prepareStatement("insert into public_messages(message,user_id,send_date) values(?,?,?)");
			pst.setString(1, messageText);
			pst.setInt(2, Integer.parseInt(ss.getAttribute("user_id").toString()));
			pst.setString(3, date_format);
			int i=pst.executeUpdate();
			
			if(i>0) {
				res.sendRedirect("/ChatApplication/Homepage.html");
			}
		}
		else {
			int to_id=Integer.parseInt(req.getParameter("select_dynamic1"));
			DateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			java.util.Date date=new java.util.Date();
			String date_format=dateFormat.format(date);
			PreparedStatement pst=con.prepareStatement("insert into private_messages(message,user_id,send_date,fro,to_id) values(?,?,?,?,?)");
			pst.setString(1, messageText);
			pst.setInt(2, Integer.parseInt(ss.getAttribute("user_id").toString()));
			pst.setString(3, date_format);
			pst.setString(4, firstname+" "+lastname);
			pst.setInt(5, to_id);
			//pst.setInt(6, Integer.parseInt(ss.getAttribute("user_id").toString()));
			int i=pst.executeUpdate();
			
			if(i>0) {
				res.sendRedirect("/ChatApplication/Homepage.html");
			}
		}
		con.close();
			}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		
	}
	
}
