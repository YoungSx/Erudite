package com.zzxy.NetDict.Config;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ConfigParams {

//	public static final String SOLR_HOME = getConfigParamsByKey("SOLR_HOME");
	
	public static final String SOLR_URL = getConfigParamsByKey("SOLR_URL");//solr服务器路径
	
	public static final String INDEX_PATH = getConfigParamsByKey("INDEX_PATH");//索引建立路径
	
	public static final String SOURCEFILE_PATH = getConfigParamsByKey("SOURCEFILE_PATH");//用户上传文件路径
	
	public static final String HTMLFILE_PATH = getConfigParamsByKey("HTMLFILE_PATH");//转换为html文件的路径
	
	public static final String TXTFILE_PATH = getConfigParamsByKey("TXTFILE_PATH");//转换为txt文件的路径
	
	public static final String NOTDOC2TXT_PATH = getConfigParamsByKey("NOTDOC2TXT_PATH");//非doc文档转换为txt后的路径
	
	/**
	 * 索引字段，对应solr_home 下的schema.xml中的fields
	 */
	public static final String FIELD_ID = "id";
//	public static final String FIELD__ID = "_id";
	public static final String FIELD_NAME = "name";
	public static final String FIELD_CONTENT = "content";
	public static final String FIELD_TRANSITIONPATH = "transitionPath";
	public static final String FIELD_DOWNLOADPATH = "downloadPath";
	
	
	/**
	 * 客户端搜索请求的搜索域
	 */
	public static final int Q_FIELD_NAME = 1;
	public static final int Q_FIELD_CONTENT = 2;
	

	/**
	 * 根据键名称获取对应值
	 * @param key
	 * @return
	 */
	private static String getConfigParamsByKey(String key)
	{
		String value = "";
		try{
			Properties props = new Properties();
		    
		    InputStream in = ConfigParams.class.getResourceAsStream("/config.properties");
	
		    // 或使用文件输入流(不推荐)，假设当前工作目录为bin
		    //InputStream in = new FileInputStream("./config.properties");
	    
	    	props.load(in);
	    	value = props.getProperty(key);
	    	in.close();
		    
	    }catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
		
	    // 读取特定属性
	    return value;
	}
	
	
	/**
	 * 设置配置文件键值对
	 * @param key
	 * @param value
	 */
	public static void setConfigParamByKey(String key,String value)
	{
		try{
			Properties props = new Properties();
			InputStream in = ConfigParams.class.getResourceAsStream("/config.properties");
			props.load(in);
			OutputStream output = new FileOutputStream("/config.properties");
			props.setProperty(key,value); // 修改或新增属性键值对
			props.store(output, "modify "+key+" value"); // store(OutputStream output, String comment)将修改结果写入输出流
			output.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 获取所有文件配置
	 * @return map<配置名,配置值>
	 */
	public static Map<String,Object> getAllConfigParams()
	{
		Map<String,Object> map = new HashMap<>();
		try{
			Properties props = new Properties();
			InputStream in = ConfigParams.class.getResourceAsStream("/config.properties");
			props.load(in);
			Enumeration en = props.propertyNames(); //得到配置文件的名字
		    while(en.hasMoreElements()) {
			         String strKey = (String) en.nextElement();
			         String strValue = props.getProperty(strKey);
			         map.put(strKey, strValue);
			       }
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return map;
	}
	
	
	public static String getConfigCNName(String configStr)
	{
		String cnName = "";
		if(configStr == null)
		{
			return cnName;
		}
		
		if(configStr.equals("SOLR_URL"))
		{
			cnName = "solr服务器链接地址";
		}else if(configStr.equals("INDEX_PATH"))
		{
			cnName = "索引文件在本地磁盘的路径";
		}else if(configStr.equals("SOURCEFILE_PATH"))
		{
			cnName = "用户上传文件的保存路径";
		}else if(configStr.equals("HTMLFILE_PATH"))
		{
			cnName = "可预览文档保存路径";
		}else if(configStr.equals("TXTFILE_PATH"))
		{
			cnName = "转换为txt格式文档的存放路径";
		}else if(configStr.equals("NOTDOC2TXT_PATH"))
		{
			cnName = "非文档文件转换为txt文件的存放路径";
		}
		
		return cnName;
	}
	
	
}
