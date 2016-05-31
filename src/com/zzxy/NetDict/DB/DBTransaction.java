package com.zzxy.NetDict.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.zzxy.NetDict.Entity.TransationInfo;






public class DBTransaction {

	/**
	 * 通用事务处理
	 * @param sqlANDParamList 需要事务处理的一组sql，List<Map<sql语句，sql语句中的参数>>
	 * @return 事务是否成功，true为成功，false为失败
	 */
	public static boolean doTransaction(List<TransationInfo> sqlANDParamList)
	{
		
		
		boolean transationSuccess = false;
		Connection conn = DBHelp.getConn();
		
		PreparedStatement pstmt = null;
		try {
			conn.setAutoCommit(false);
			
			for(TransationInfo transationInfo : sqlANDParamList)
			{
				String sql = transationInfo.getSql();
				List<Object> paramList = transationInfo.getParams();
				
				pstmt = conn.prepareStatement(sql);
				for(int paramIndex = 0; paramIndex < paramList.size(); paramIndex++)
				{
				    pstmt.setObject(paramIndex + 1, paramList.get(paramIndex));
				}
				pstmt.executeUpdate();
			}
			conn.commit();
			pstmt.close();
			conn.close();
			
			transationSuccess = true;
			
		} catch (Exception e) {
			e.printStackTrace();
			try {
				System.out.println("==");
				conn.rollback();//回滚
				conn.close();
				return false;
				
			} catch (Exception e2) {
				e2.printStackTrace();
				return false;
			}
		}
		
		return transationSuccess;
	}
	
	
	
}
