package com.chatapplication.controller;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import org.json.JSONObject;

import com.chatapplication.dao.GetAllUsersDao;
import com.chatapplication.util.DbUtil;
import com.google.gson.Gson;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@WebServlet(urlPatterns="/getallusers")
public class GetAllUsers extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		res.setContentType("application/json");
		JSONObject obj=new JSONObject();
		
		List list=GetAllUsersDao.getAllUsers();
		
		String json=new Gson().toJson(list);
		res.getWriter().write(json);
	}
}
