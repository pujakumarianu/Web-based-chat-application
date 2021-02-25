package com.chatapplication.controller;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.*;

@WebServlet(urlPatterns="/logout")
public class Logout extends HttpServlet{

	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		HttpSession ss=req.getSession(false);
		if(ss!=null) {
			ss.invalidate();
			res.sendRedirect("/ChatApplication/admin_login.html");
		}
		else if(ss==null){
			res.sendRedirect("/ChatApplication/error.html");
		}
	}
	
}
