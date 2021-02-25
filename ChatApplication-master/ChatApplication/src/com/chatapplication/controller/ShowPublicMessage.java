package com.chatapplication.controller;

import javax.servlet.*;
import javax.servlet.http.*;

import org.json.JSONArray;
import org.json.JSONObject;

import com.chatapplication.dao.ShowPublicMessageDao;
import com.chatapplication.util.DbUtil;
import com.google.gson.Gson;

import javax.servlet.annotation.*;
import java.sql.*;
import java.io.*;
import java.util.*;

@WebServlet(urlPatterns="/showmessage")
public class ShowPublicMessage extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException {
		res.setContentType("application/json");
		HttpSession ss=req.getSession(false);
		
		
		JSONObject obj=new JSONObject();
		List list=ShowPublicMessageDao.showPublicMessages();
		
		String json=new Gson().toJson(list);
		res.getWriter().write(json);
	}
	
}
