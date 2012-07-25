package com.malc.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConnection {
	private Connection conn;
	private Statement st;
	
	public Connection getConnection(){	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@172.16.233.173:1521:XE","zy","24865994");
			//System.out.println(conn);
    	} catch (ClassNotFoundException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
		} catch (SQLException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
public void closeConnection(){
	if(conn!=null){
		try{
			conn.close();
		}catch (SQLException e){
		
			e.printStackTrace();
		}
	}
	}

}


