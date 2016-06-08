package com.zzxy.NetDict.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zzxy.NetDict.Config.ConfigParams;
import com.zzxy.NetDict.DB.DBBase;
import com.zzxy.NetDict.lucene.LuceneIndex;

public class IndexService {

	/**
	 * 为文本文档创建索引
	 */
	public static void createIndexForDoc()
	{
		String indexPath = ConfigParams.INDEX_PATH;
		String srcPath = ConfigParams.TXTFILE_PATH;
		
		//获取所有txt文件
		List<String> fileList = FileManageService.getFileList(srcPath);
		
		//获取txt文件内容，并创建map
		for(String path : fileList)
		{
			Map<String,Object> map = new HashMap<>();
			String content = FileManageService.getFileContent(path);
			String id = FileManageService.getFileName(path);
			map.put(ConfigParams.FIELD_ID, id);
			map.put(ConfigParams.FIELD_CONTENT, content);

			LuceneIndex.updateIndex(indexPath, id, map);
			updateDB(id);
		}
		
	}
	
	/**
	 * 为图片等其他无法索引内容的文件创建索引
	 */
	public static void createIndexForOtherFile()
	{
		String indexPath = ConfigParams.INDEX_PATH;
		String srcPath = ConfigParams.NOTDOC2TXT_PATH;
		
		//获取所有txt文件
		List<String> fileList = FileManageService.getFileList(srcPath);
		
		//获取txt文件内容，并创建map
		for(String path : fileList)
		{
			Map<String,Object> map = new HashMap<>();
			String content = FileManageService.getFileContent(path);
			String id = FileManageService.getFileName(path);
			map.put(ConfigParams.FIELD_ID, id);
			map.put(ConfigParams.FIELD_NAME, content);

			LuceneIndex.updateIndex(indexPath, id, map);
			updateDB(id);
		}
		
	}
	
	/**
	 * 根据传进来的文件路径进行创建
	 * @param txtPath
	 */
	public static void createIndex(String txtPath)
	{
		String indexPath = ConfigParams.INDEX_PATH;
		
		if(txtPath.contains(ConfigParams.TXTFILE_PATH))
		{
			Map<String,Object> map = new HashMap<>();
			String content = FileManageService.getFileContent(txtPath);
			String id = FileManageService.getFileName(txtPath);
			map.put(ConfigParams.FIELD_ID, id);
			map.put(ConfigParams.FIELD_CONTENT, content);

			LuceneIndex.updateIndex(indexPath, id, map);
			updateDB(id);
		}else
		{
			Map<String,Object> map = new HashMap<>();
			String content = FileManageService.getFileContent(txtPath);
			String id = FileManageService.getFileName(txtPath);
			map.put(ConfigParams.FIELD_ID, id);
			map.put(ConfigParams.FIELD_NAME, content);
			LuceneIndex.updateIndex(indexPath, id, map);
			updateDB(id);
		}
	}
	
    
	/**
	 * 更新数据库
	 */
     private static void updateDB(String id)
     {
    	 DBBase db = new DBBase();
    	 String sql = "UPDATE files SET indexed = 1 WHERE f_id = ?";
    	 db.saveOrUpdate(sql, id);
     }
	
}
