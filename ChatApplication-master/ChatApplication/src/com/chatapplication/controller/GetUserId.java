package com.chatapplication.controller;

import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.*;


@WebServlet(urlPatterns="/getuserid")
public class GetUserId extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		res.setContentType("text/html");
		
		HttpSession ss=req.getSession(false);
		
		String user_id=ss.getAttribute("user_id").toString();
		
		res.getWriter().write(user_id);
		
	}
	
}
