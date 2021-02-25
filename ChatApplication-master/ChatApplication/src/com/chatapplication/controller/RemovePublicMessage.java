package com.chatapplication.controller;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import org.json.JSONObject;

import com.chatapplication.dao.RemovePublicMessageDao;
import com.chatapplication.util.DbUtil;
import com.google.gson.Gson;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns="/removepublicmessage")
public class RemovePublicMessage extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		doPost(req,res);
		
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		HttpSession ss=req.getSession(false);
		int message_id=Integer.parseInt(req.getParameter("text"));
		
		String user_id=ss.getAttribute("user_id").toString();
		
		if(RemovePublicMessageDao.removePublicMessage(message_id,user_id)) {
			res.getWriter().write("Done");
			res.sendRedirect("/ChatApplication/Homepage.html");
		}
		else {
			res.getWriter().write("Not Done");
			res.sendRedirect("/ChatApplication/error.html");
		}
		
		
	}
	
}
