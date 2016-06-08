package com.zzxy.NetDict.lucene;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;
import org.wltea.analyzer.lucene.IKAnalyzer;

public class CustomAnalyzer {

	public static List<String> sentenceCut(String sentence)
	{
		List<String> wordsList = new ArrayList<>();
		
		Analyzer analyzer = new IKAnalyzer(true);
		
		TokenStream ts = null;
		
		try {
			
			ts = analyzer.tokenStream("myfield", sentence);
			
			//获取词元位置属性
		    OffsetAttribute  offset = ts.addAttribute(OffsetAttribute.class); 
		    //获取词元文本属性
		    CharTermAttribute term = ts.addAttribute(CharTermAttribute.class);
		    //获取词元文本属性
		    TypeAttribute type = ts.addAttribute(TypeAttribute.class);
		    
		    //重置TokenStream（重置StringReader）
			ts.reset(); 
			//迭代获取分词结果
			while (ts.incrementToken()) {
				wordsList.add(term.toString());
				
//			  System.out.println(offset.startOffset() + " - " + offset.endOffset() + " : " + term.toString() + " | " + type.type());
			}
			//关闭TokenStream（关闭StringReader）
			ts.end();   // Perform end-of-stream operations, e.g. set the final offset.

			
		} catch (Exception e) {
			e.printStackTrace();
		}finally
		{
			//释放TokenStream的所有资源
			if(ts != null){
		      try {
				ts.close();
		      } catch (IOException e) {
				e.printStackTrace();
		      }
			}
		}
		System.out.println(wordsList);
	
		return wordsList;
	}
	
}
