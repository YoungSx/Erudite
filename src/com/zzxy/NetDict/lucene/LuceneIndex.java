package com.zzxy.NetDict.lucene;

	import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.index.IndexableField;
import org.apache.lucene.index.Term;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.wltea.analyzer.lucene.IKAnalyzer;

import com.zzxy.NetDict.Config.ConfigParams;

	public class LuceneIndex {
		
		/**
		 * 为txt文本文件创建索引
		 * @param indexPath 索引的路径
		 * @param fieldAndContentList 内容格式：List<Map<fieldName,fieldContent>>
		 */
		public static void createIndex(String indexPath,List<Map<String,Object>> fieldAndContentList){
			//实例化IKAnalyzer分词器
			Analyzer analyzer = new IKAnalyzer(true);
			
			try{
				Directory dir = FSDirectory.open(new File(indexPath));//打开索引路径
				IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_46,analyzer);//配置索引
				config.setOpenMode(OpenMode.CREATE_OR_APPEND);//设置索引维护方式
				config.setRAMBufferSizeMB(256.0);//设置用来缓冲文档的RAM大小
				
				IndexWriter iw = new IndexWriter(dir,config);
				
				
				for(Map<String,Object> fieldAndContentMap : fieldAndContentList)
				{
					Document doc = new Document();//创建document
					Set<String> fieldSet = fieldAndContentMap.keySet();//获取所有map里的key
					Iterator<String> iter = fieldSet.iterator();//创建一个迭代器
					
					while(iter.hasNext())
					{
						String fieldName = iter.next();//获取map里的key
						String fieldContent = (String) fieldAndContentMap.get(fieldName);//根据key获取value
						IndexableField field = new TextField(fieldName,fieldContent,Field.Store.YES);
						//TODO:查询范文，全字匹配还是单词匹配

						doc.add(field);
					}
					iw.addDocument(doc);	
					iw.commit();
				}
				iw.close();
			}			
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			
			
			
			
			
			
		}
		
		/**
		 * 索引的更新
		 * @param indexPath
		 * @param fieldAndContentList
		 */
		public static void updateIndex(String indexPath,String indexId,Map<String,Object> fieldAndContentMap){
			//实例化IKAnalyzer分词器
			Analyzer analyzer = new IKAnalyzer(true);
			
			try{
				Directory dir = FSDirectory.open(new File(indexPath));//打开索引路径
				IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_46,analyzer);//配置索引
				config.setOpenMode(OpenMode.CREATE_OR_APPEND);//设置索引维护方式
				config.setRAMBufferSizeMB(256.0);//设置用来缓冲文档的RAM大小
				
				IndexWriter iw = new IndexWriter(dir,config);
				
				Document doc = new Document();//创建document
				Set<String> fieldSet = fieldAndContentMap.keySet();//获取所有map里的key
				Iterator<String> iter = fieldSet.iterator();//创建一个迭代器
				
				while(iter.hasNext())
				{
					String fieldName = iter.next();//获取map里的key
					String fieldContent = (String) fieldAndContentMap.get(fieldName);//根据key获取value
					IndexableField field = new TextField(fieldName,fieldContent,Field.Store.YES);
					//TODO:查询范文，全字匹配还是单词匹配

					System.out.println("LuceneIndex : field = "+fieldName+"     content = "+fieldContent);
					doc.add(field);
				}
				iw.updateDocument(new Term(ConfigParams.FIELD_ID,indexId), doc);
				IndexWriter.unlock(dir);
				iw.commit();
					
				iw.close();
			}			
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		
		
		/**
		 * 删除索引
		 * @param indexId 索引id
		 * @param indexPath 索引路径
		 */
		public static void deleteIndex(String indexId,String indexPath)
		{
			try {
		    Directory directory = FSDirectory.open(new File(indexPath));  
		    Analyzer analyzer = new IKAnalyzer(true);
            IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_46, analyzer);  
            //最大缓存文档数,控制写入一个新的segment前内存中保存的document的数目  
            config.setMaxBufferedDocs(100);  
            //控制一个segment中可以保存的最大document数目，值较大有利于追加索引的速度，默认Integer.MAX_VALUE，无需修改。  
            config.setMaxBufferedDocs(Integer.MAX_VALUE);  
            IndexWriter indexWriter = new IndexWriter(directory, config);  
            
			indexWriter.deleteDocuments(new Term("id",indexId));
	
            indexWriter.commit();  
            indexWriter.close();  
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
            
		}
		
		
	}
