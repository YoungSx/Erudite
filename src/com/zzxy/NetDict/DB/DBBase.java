/**
 * 
 */
package com.zzxy.NetDict.DB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 张须高
 */
public class DBBase {

	public Connection conn = null;
	
	private PreparedStatement ps = null;
	
	private ResultSet rs = null;
	
	private CallableStatement cs = null;
	
	
	/**
	 * 查询符合条件的记录数
	 * 
	 * @param sql 
	 * 
	 * @param args 给sql语句中？赋值的参数列表
	 * 
	 * @return 符合条件的记录数
	 */
	public long getCount(String sql,Object...args)
	{
		conn = DBHelp.getConn();
		
		int count = 0;
		
		try{
			ps = conn.prepareStatement(sql);
			
			for(int i = 0;i < args.length; i++)
			{
				ps.setObject(i + 1, args[i]);
			}
			
			rs = ps.executeQuery();
			
			while (rs.next())
			{
				++count;
			}
			
			return count;
		}catch (SQLException e)
		{
			e.printStackTrace();
		}finally {
			DBHelp.closeConn(conn, ps, rs);
		}
		
		return 0L;
	}
	
	
	
	
	/**
	 * 执行可变参数的sql语句，进行保存、删除或更新操作
	 * 
	 * @param sql ，要执行的sql语句，？赋值的顺序必须与args数组的顺序相同
	 * 
	 * @param args ，要赋值的参数列表
	 * 
	 * @return 操作结果，正数成功，0 失败,-1:UNIQUE键的值重复
	 * 
	 */
	public int saveOrUpdate(String sql,Object...args)
	{
		conn = DBHelp.getConn();
		
		try{
			ps = conn.prepareStatement(sql);
			
			if(args != null)
			{
				for (int j = 0;j < args.length; j++)
				{
					ps.setObject(j+1, args[j]);
				}
			}
			return ps.executeUpdate();
		}catch(SQLException e)
		{
		    e.printStackTrace();
		    
			int errorCode = e.getErrorCode();
			
			switch(errorCode){
			    case 1062:
			        //UNIQUE约束的键重复
			        return -1;
			}
			
		}finally{
			DBHelp.closeConn(conn, ps, null);
		}
		
		return 0;
	}
	
	
	/**
	 * sql 查询将查询结果直接放入resultset中
	 * 
	 * @param sql
	 * 
	 * @param params 参数数组，没有为null
	 * 
	 * @return 结果集
	 */
	public ResultSet executeQueryRS(String sql, Object[] params) {
		try {

			conn = DBHelp.getConn();

			ps = conn.prepareStatement(sql);

			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					ps.setObject(i + 1, params[i]);

				}

			}
			rs = ps.executeQuery();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			// DBHelp.closeConn(conn, ps, rs);
		}
	
		return rs;
	}
	
	
	
	/**
	 * @return 获取结果集，并将结果放在list中
	 */
	public List<Object> excuteQueryList(String sql,Object[] params)
	{
		ResultSet rs = executeQueryRS(sql,params);
		
		ResultSetMetaData rsmd = null;
		
		int columnCount = 0;
		
		try{
			rsmd = rs.getMetaData();
			
			columnCount = rsmd.getColumnCount();
		}catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
		
		List<Object> list = new ArrayList<Object>();
		
		try{
			//将resultset的结果保存到List中
			while(rs.next())
			{
				Map<String,Object> map = new HashMap<String ,Object>();
				
				for(int i = 1;i <= columnCount;i++)
				{
					map.put(rsmd.getColumnLabel(i), rs.getObject(i));
				}
				list.add(map);
			}
		}catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}finally{
			DBHelp.closeConn(conn, ps, rs);
			if(cs != null)
			{
				try {
					cs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				cs = null;
			}
		}
		
		return list;
	}
	

	
}
