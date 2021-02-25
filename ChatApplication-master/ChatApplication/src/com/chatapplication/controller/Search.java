package com.chatapplication.controller;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.chatapplication.dao.SearchDao;
import com.chatapplication.util.DbUtil;
import com.google.gson.Gson;
import com.sun.org.apache.xml.internal.security.algorithms.MessageDigestAlgorithm;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

@WebServlet(urlPatterns="/searchtext")
public class Search extends HttpServlet{
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {
		
		doPost(req,res);
	}
	
	
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {
		
		HttpSession ss=req.getSession(false);
		res.setContentType("application/json");
		
		String messageText=req.getParameter("text");
		String user_id=ss.getAttribute("user_id").toString();
		//System.out.println(messageText);
		
		
		List list=SearchDao.getSearch(messageText,user_id);
		
		String json=new Gson().toJson(list);
		res.getWriter().write(json);
		
		
	}

}
