package com.chatapplication.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import org.json.JSONObject;

import com.chatapplication.dao.GetPrivateMessageDao;
import com.chatapplication.util.DbUtil;
import com.google.gson.Gson;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@WebServlet(urlPatterns="/getprivatemessage")
public class GetPrivateMessage extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application/json");
		HttpSession ss=req.getSession(false);
		
		JSONObject obj=new JSONObject();
		
		List list=GetPrivateMessageDao.getPrivateMessage(ss.getAttribute("user_id").toString());
		
		String json=new Gson().toJson(list);
		res.getWriter().write(json);
	}
	
}
