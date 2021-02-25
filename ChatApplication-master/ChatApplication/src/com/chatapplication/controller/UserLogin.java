package com.chatapplication.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.chatapplication.dao.LoginDao;
import com.chatapplication.util.DbUtil;
import java.sql.*;
import java.io.*;
import javax.servlet.*;

@WebServlet(urlPatterns="/user_login")
public class UserLogin extends HttpServlet{
	
	
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		PrintWriter out=res.getWriter();
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		
		if(LoginDao.login(username, password)) {
			HttpSession ss=req.getSession();
			ss.setAttribute("user_id",LoginDao.user_id);
			ss.setAttribute("firstname",LoginDao.firstname);
			res.sendRedirect("/ChatApplication/Homepage.html");
			
		}
		else {
			res.sendRedirect("/ChatApplication/error.html");
		}
	}
}
