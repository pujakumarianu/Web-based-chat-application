package com.chatapplication.controller;


import javax.servlet.*;
import javax.servlet.http.*;

import com.chatapplication.dao.ShowPrivateMessagesDao;
import com.chatapplication.util.DbUtil;
import com.google.gson.Gson;

import javax.servlet.annotation.*;
import java.io.*;
import java.sql.*;
import java.util.*;

@WebServlet(urlPatterns="/showprivatemessage")
public class ShowPrivateMessage extends HttpServlet{
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession ss=req.getSession(false);
		res.setContentType("application/json");
		
		List list=ShowPrivateMessagesDao.showPrivateMessages(ss.getAttribute("user_id").toString());
		
		String json=new Gson().toJson(list);
		res.getWriter().write(json);
	}
	
}
