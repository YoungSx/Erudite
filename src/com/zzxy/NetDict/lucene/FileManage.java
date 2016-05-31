package com.zzxy.NetDict.lucene;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zzxy.NetDict.DB.DBBase;

public class FileManage {
	
	/**
	 * 根据文件Id获取文件名称
	 * @param fileId 文件id
	 * @return 文件名
	 */
	public static String getFileName(String fileId)
	{
		DBBase db = new DBBase();
		String fileName = null;
		String searchSQL = "SELECT f_name FROM file_user WHERE f_id = ? AND delete_flag = 0 ";
		ResultSet rs = db.executeQueryRS(searchSQL, new String[]{fileId});
		try {
			while(rs.next())
			{
				fileName = rs.getString("f_name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return fileName;
	}

	/**
	 * 根据文件路径获取文件内容
	 * @param filePath 文件路径
	 * @return 文件内容
	 */
	public static String getFileContent(String filePath)
	{
		String fileContent = "";
		File file = new File(filePath);
        BufferedReader reader = null;
        try {
            
            reader = new BufferedReader(new FileReader(file));
            
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                
                fileContent += tempString;
                
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
		return fileContent;
	}

	
}
