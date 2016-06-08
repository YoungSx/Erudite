package com.zzxy.NetDict.Solr;

import org.apache.solr.client.solrj.impl.HttpSolrServer;

import com.zzxy.NetDict.Config.ConfigParams;

public class SolrManage {
	
	/**
	 * 获取solrServer
	 * @return SolrServer
	 */
	public static HttpSolrServer getSolrServerInsetence()
	{
		HttpSolrServer solrServer = null;
	// 创建solrserver对象：
	try {
		solrServer = new HttpSolrServer(ConfigParams.SOLR_URL);
		solrServer.setConnectionTimeout(100);
		solrServer.setDefaultMaxConnectionsPerHost(100);
		solrServer.setMaxTotalConnections(100);
		
		} catch (Exception e) 
			{
				System.out.println("请检查tomcat服务器或端口是否开启!");
				e.printStackTrace();
			}
		return solrServer;
	}
	
	
}
