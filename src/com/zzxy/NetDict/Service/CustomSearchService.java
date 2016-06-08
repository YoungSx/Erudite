package com.zzxy.NetDict.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.zzxy.NetDict.Config.ConfigParams;
import com.zzxy.NetDict.Dao.FileManageDao;
import com.zzxy.NetDict.DaoImpl.FileManageDaoImpl;
import com.zzxy.NetDict.Entity.NDFile;
import com.zzxy.NetDict.Solr.SolrQuerys;
import com.zzxy.NetDict.lucene.CustomAnalyzer;

public class CustomSearchService {


	/**
	 * 获取查询结果
	 * @param queryStr 用户输入的查询语句
	 * @param queryField 查询域 1：name ，2：content
	 * @return 文件列表
	 */
	public static List<NDFile> getQuery(String queryStr,int queryField)
	{
		List<NDFile> fileList = new ArrayList<>();
		String queryFieldStr = ConfigParams.FIELD_CONTENT;//默认搜索内容
		if(queryField == ConfigParams.Q_FIELD_NAME)
		{
			queryFieldStr = ConfigParams.FIELD_NAME;
		}
		
		List<String> queryWords = CustomAnalyzer.sentenceCut(queryStr);
		
		List<Map<String,Object>> queryRS = SolrQuerys.customSolrQuery(queryFieldStr, queryWords);
		
		FileManageDao fm = new FileManageDaoImpl();
		for(Map<String,Object> map : queryRS)
		{
			String fileId = (String) map.get(ConfigParams.FIELD_ID);
			String fileContent = (String)map.get(queryFieldStr);
			NDFile file = fm.getFileById(fileId);
			if(file.getF_id()==null)
			{
				continue;
			}
			file.setQueryContent(fileContent);
			fileList.add(file);
			
		}
		
		return fileList;
	}
	
}
