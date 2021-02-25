package com.chatapplication.util;

import java.util.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import javax.annotation.Resource;
import java.sql.*;
import java.io.*;

@Resource(name="jdbc/chatapp")
public class DbUtil{

	private static DataSource dataSource;
	private static Connection con;
	public static Connection getConnection() {  	
			try {
				Context initContext  = new InitialContext();
				Context envContext  = (Context)initContext.lookup("java:/comp/env/");
				dataSource = (DataSource)envContext.lookup("jdbc/chatapp");
				con=dataSource.getConnection();
			}
		catch(Exception e) {
			e.printStackTrace();
		}
				return con;
	}

}
