package com.chatapplication.controller;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import org.json.JSONObject;

import com.chatapplication.dao.RemovePrivateMessageDao;
import com.chatapplication.util.DbUtil;
import com.google.gson.Gson;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns="/removeprivatemessage")
public class RemovePrivateMessage extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		doPost(req,res);
	}
	
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		res.setContentType("text/html");
		HttpSession ss=req.getSession(false);
		
		int message_id=Integer.parseInt(req.getParameter("text"));
		
		if(RemovePrivateMessageDao.removePrivateMessage(message_id)) {
			res.getWriter().write("yes");
		}
		else {
			res.sendRedirect("/ChatApplication/error.html");
		}
		
	}
	
}
