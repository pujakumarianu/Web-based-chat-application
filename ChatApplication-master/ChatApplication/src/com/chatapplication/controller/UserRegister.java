package com.chatapplication.controller;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.chatapplication.dao.RegisterDao;
import com.chatapplication.util.DbUtil;
import java.sql.*;
import java.io.*;
import javax.servlet.*;

@WebServlet(urlPatterns="/user_register")
public class UserRegister extends HttpServlet{

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
	

		PrintWriter out=res.getWriter();
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		String firstname=req.getParameter("firstname");
		String lastname=req.getParameter("lastname");
		
		
		if(RegisterDao.Register(username, password, firstname, lastname)) {
			res.sendRedirect("/ChatApplication/registersuccess.html");
		}
		else{
			res.sendRedirect("/ChatApplication/error.html");
			}
		}
	}
	