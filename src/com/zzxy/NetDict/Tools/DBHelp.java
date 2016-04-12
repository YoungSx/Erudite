/**
 * 
 */
package com.zzxy.NetDict.Tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author 张须高
 */
public class DBHelp {

	/**
	 * 获取一个数据库连接
	 */
	public static Connection getConn(){
		Connection conn = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/KBMS";
			conn = DriverManager.getConnection(url,"root","zxg123456");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 关闭数据库连接
	 * 
	 */
	public static void closeConn(Connection conn,PreparedStatement ps,ResultSet rs){
		
		try{
			
			if(rs != null)
			{
				rs.close();
				rs = null;
			}
			
			if(ps != null)
			{
				ps.close();
				ps = null;
			}
			
			if(conn != null)
			{
				conn.close();
				conn = null;
			}
		}
		catch (Exception e )
		{
			e.printStackTrace();
		}
	}
	
}
