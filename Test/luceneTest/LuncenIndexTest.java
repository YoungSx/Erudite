package luceneTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.zzxy.NetDict.lucene.LuceneIndex;


public class LuncenIndexTest {
	@Test
	public void testCreateIndexForFile(){
		String indexPath = "/Users/Magic_Zhang/desktop/index";
		
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String,Object> map1 = new HashMap<String,Object>();
		Map<String,Object> map11 = new HashMap<String,Object>();
		Object obj = "啥活动哦爱好激动是山东分行骄傲是大家hi山东法哈搜的合法is的";
		Object obj1 = "啥活动哦爱好激动是分行骄傲是大家法哈搜的合法is的";
		Object obj11 = "啥活动";   
		
		map.put("id",obj);
		map1.put("id",obj1);
		map11.put("id",obj11);
		
		map.put("content",obj);
		map1.put("content",obj1);
		map11.put("content",obj11);
		
		list.add(map);
		list.add(map1);
		list.add(map11);
				
		LuceneIndex.createIndex(indexPath, list);
	}
	
	@Test
	public void testupdateIndex(){
		String indexPath = "/Users/Magic_Zhang/desktop/index";
		
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String,Object> map1 = new HashMap<String,Object>();
		Map<String,Object> map11 = new HashMap<String,Object>();
		
		
		Object id = "1";
		Object name = "111";
		Object content = "111";   
		
		Object id1 = "2";
		Object name1 = "456a";
		Object content1 = "789b";   
		
		Object id2 = "3";
		Object name2 = "456c";
		Object content2 = "789d";  
		
		map.put("id", id);
		map.put("name", name);
		map.put("content", content);
		
//		map1.put("id", id1);
//		map1.put("name", name1);
//		map1.put("content", content1);
//		
//		map11.put("id", id2);
//		map11.put("name", name2);
//		map11.put("content", content2);

		
		list.add(map);
//		list.add(map1);
//		list.add(map11);
				
		LuceneIndex.updateIndex(indexPath, "1", list);
	}
	
	@Test
	public void deleteIndexTest()
	{
		String indexPath = "/Users/Magic_Zhang/desktop/index";
		LuceneIndex.deleteIndex("1", indexPath);
	}
	
	
}
