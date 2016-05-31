package com.zzxy.NetDict.Config;

public class ConfigParams {

	public static final String SOLR_HOME = "";
	
	public static final String SOLR_URL = "http://localhost:8089/solr";
	
	public static final String INDEX_PATH = "";
	
	/**
	 * 索引字段，对应solr_home 下的schema.xml中的fields
	 */
	public static final String FIELD_ID = "id";
	public static final String FIELD__ID = "_id";
	public static final String FIELD_NAME = "name";
	public static final String FIELD_CONTENT = "content";
	public static final String FIELD_TRANSITIONPATH = "transitionPath";
	public static final String FIELD_DOWNLOADPATH = "downloadPath";
}
