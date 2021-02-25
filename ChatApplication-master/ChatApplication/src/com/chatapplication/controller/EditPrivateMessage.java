package com.chatapplication.controller;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import org.json.JSONObject;
import com.chatapplication.dao.EditPrivateMessagesDao;
import com.chatapplication.util.DbUtil;
import com.google.gson.Gson;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns="/editprivatemessages")
public class EditPrivateMessage extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		HttpSession ss=req.getSession(false);
		
		String message=req.getParameter("message_text");
		String message_id=req.getParameter("message_id");
		
		
		if(EditPrivateMessagesDao.editPrivateMessages(message, message_id)) {
			res.sendRedirect("/ChatApplication/Homepage.html");
		}
		else {
			res.sendRedirect("/ChatApplication/error.html");
		}
	}
	
}
