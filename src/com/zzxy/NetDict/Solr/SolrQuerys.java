package com.zzxy.NetDict.Solr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;

import com.zzxy.NetDict.Config.ConfigParams;

public class SolrQuerys {

	/**
	 * 根据传入的查询字段和关键词进行查询，目前仅支持单字段多关键词，需改进（List<Map<String filedname,Set<String> keyWords>>）
	 * 
	 * 项目阶段实行：搜索文档时搜索“content”域，搜索其他文件时搜索“name”域
	 * @param queryField 匹配字段
	 * @param queryWords 关键词
	 */
	public static List<Map<String,Object>> customSolrQuery(String queryField,List<String> queryWords)
	{
		List<Map<String,Object>> matchFilesList = new ArrayList<>();//搜索到的文件的id
		
		HttpSolrServer solrServer = SolrManage.getSolrServerInsetence();
		String queryString = "";
		
		for(int index = 0;index < queryWords.size();index++)
		{
			String queryWord = queryWords.get(index);
			if(queryWord.trim().equals(""))
			{
				queryString = queryString.substring(0, queryString.lastIndexOf("AND"));
				continue;
			}
			if(index < queryWords.size() - 1)
			{
				queryString += (queryField +":"+ queryWord + " AND ");
			}
			else
			{
				queryString += (queryField +":"+ queryWord);
			}
			
		}
		
		System.out.println("queryString = "+queryString);
		
		SolrQuery params = new SolrQuery(queryString); 
		
		//设置默认搜索域
		params.set("df", ConfigParams.FIELD_CONTENT);
		
		//显示域
		String[] fields = {ConfigParams.FIELD_ID, ConfigParams.FIELD_CONTENT,ConfigParams.FIELD_NAME};
		params.setFields(fields);
		
		//高亮
		
		params.setHighlight(true);
		//显示的字数
		params.setHighlightFragsize(50);
		params.addHighlightField(ConfigParams.FIELD_CONTENT);
		params.setHighlightSimplePre("<em class=\"highlight\" >");
		params.setHighlightSimplePost("</em>");
		
		
		  //排序，可以添加多个。先加入的 优先级高  
//		params.addSort("age", ORDER.asc);  
//		params.addSort("id", ORDER.desc); 
		
		//过滤：包含的留下  达到精确搜索   可添加多个  
//      String[] fqs = {"testik:加油"};  
//      String[] fqs = {"testik:加油","name:加油马航"};  
//      params.addFilterQuery(fqs);  
		
		//分页   起始位置   每页条数   todo:lucene、solr内存溢出问题  
//        params.setStart(0);  
//        params.setRows(10);  
		
		//facet   
        //FacetField统计的域  
//        String[] ftf = {ConfigParams.FIELD_NAME,ConfigParams.FIELD_CONTENT};  
//        params.addFacetField(ftf);  
        //RangeFacet统计，从1开始，到28结束，每隔10个统计一次。最后一次大于28的也会统计进去。  
//        params.addNumericRangeFacet("age", 1, 28, 10);  
        
        
        
        try{
        	
        	QueryResponse response = solrServer.query(params);
        	
        	//"name","content" FacetField统计结果 
        	//TODO:疑似模糊查询
//        	List<FacetField> listField = response.getFacetFields();  
//        	for(FacetField facetField : listField)
//        	{  
//	            System.out.println("facet name = " +facetField.getName());  
//	            List<Count> counts = facetField.getValues();  
//	            for(Count c : counts)
//	            {  
//	                System.out.println("facetField 统计结果 = " + c.getName()+":"+c.getCount());  
//	            }  
//        	}
            
//            //age RangeFacet统计结果  
//            List<RangeFacet> listFacet = response.getFacetRanges();  
//            for(RangeFacet rf : listFacet)
//            {  
//                List<RangeFacet.Count> listCounts = rf.getCounts();  
//                for(RangeFacet.Count count : listCounts)
//                {  
//                    System.out.println("RangeFacet:"+count.getValue()+":"+count.getCount());  
//                }  
//            }  
            
            SolrDocumentList list = response.getResults();  
            //第一个map key:document.getFieldValue("id")文档id值    第二个map key:高亮的域名   
//             Map<String,Map<String,List<String>>> map = response.getHighlighting();  
//             System.out.println("map = "+map);
            System.out.println("total hits:"+list.getNumFound()+"\n"); 
            
            for(SolrDocument doc : list)
            {  
            	String fileId = (String) doc.getFieldValue(ConfigParams.FIELD_ID);
            	String content = (String)doc.getFieldValue(queryField);
            	content = content.substring(0, 300);
            	
            	Map<String,Object> docMap = new HashMap<>();
            	docMap.put(ConfigParams.FIELD_ID, fileId);
            	docMap.put(queryField, content);
            	matchFilesList.add(docMap);
            	
//            	System.out.println("doc = "+doc);
//                System.out.println("_id:"+doc.getFieldValue("_id"));  
//                System.out.println("id:"+doc.getFieldValue("id")); 
//                System.out.println("name:"+doc.get("name"));  
//                System.out.println("content:"+doc.get("content"));  
//                System.out.println("age:"+doc.getFieldValue("age"));  
//                System.out.println("testik:"+doc.get("testik"));  
//                System.out.println("hl:"+map.get(doc.getFieldValue("id")).get("testik").get(0));  
                //修改doc方法 document.setField(高亮域, 高亮的值);  
//                doc.setField("content", map.get(doc.getFieldValue("content")).get("大学").get(0));  
//                System.out.println("hl testik:"+doc.get("content"));  
                System.out.println();  

            } 
			
		} catch (SolrServerException e) {
			e.printStackTrace();
		}
        return matchFilesList;
	}
}

		
	
		

		
		
		