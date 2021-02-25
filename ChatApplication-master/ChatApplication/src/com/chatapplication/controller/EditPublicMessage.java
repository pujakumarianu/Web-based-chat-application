package com.chatapplication.controller;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import org.json.JSONObject;

import com.chatapplication.dao.EditPublicMessageDao;
import com.chatapplication.util.DbUtil;
import com.google.gson.Gson;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns="/editpublicmessages")
public class EditPublicMessage extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		doPost(req,res);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		HttpSession ss=req.getSession(false);
		
		String message=req.getParameter("text");
		String user_id=ss.getAttribute("user_id").toString();
		
		String str[]=message.split(" ");
		String bst=" ";
		for(int i=1;i<str.length;i++) {
			bst=bst+str[i]+" ";
		}
		
		if(EditPublicMessageDao.editPublicMessage(str,user_id,bst)) {
			res.getWriter().write("Message Updated");
			res.sendRedirect("/ChatApplication/Homepage.html");
		}
		else {
			res.getWriter().write("Cannot Update this Messsage");
			res.sendRedirect("/ChatApplication/error.html");
		}
		
	}
	
	
}
