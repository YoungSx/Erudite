package dBTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.zzxy.NetDict.DB.DBTransaction;

public class DBTransationTest {

	@Test
	public void doTrasationTest()
	{
//		List<Map<String,List<Object>>>
		
		String sql1 = "INSERT INTO `KBMS`.`files` (`f_id`, "
				+ "`mime_type`, `size`, `real_path`, `transition_path`,"
				+ " `thumb_path`, `descrp`, `retain`, `indexed`, `modified`, "
				+ "`modifier`, `deleted`, `deleter`, `delete_flag`) "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		String sql2 = "INSERT INTO `KBMS`.`folder` (`fd_id`, `fd_name`, "
				+ "`fd_owner`, `fd_super`, `modified`, `modifier`,"
				+ " `deleted`, `deleter`, `delete_flag`) "
				+ "VALUES (?,?,?,?,?,?,?,?,?)";
		
		List<Object> list1 = new ArrayList<Object>();
		list1.add("sdfsd");
		list1.add(2);
		list1.add(3);
		list1.add(4);
		list1.add("sdfasdf");
		list1.add("sdfasdf");
		list1.add(3);
		list1.add(4);
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		list1.add(1);
		list1.add(0);

		List<Object> list2 = new ArrayList<Object>();
		list2.add("sdfasd");
		list2.add(2);
		list2.add(3);
		list2.add(4);
		list2.add(1);
		list2.add(2);
		list2.add(3);
		list2.add(4);
		list2.add(0);
		
		Map<String,List<Object>> map = new HashMap<String,List<Object>>();
		Map<String,List<Object>> map1 = new HashMap<String,List<Object>>();
		map.put(sql1, list1);
		map1.put(sql2, list2);
		
		List<Map<String,List<Object>>> list = new ArrayList<Map<String,List<Object>>>();
		list.add(map);
		list.add(map1);
		
		boolean rt = DBTransaction.doTransaction(list);
		
		System.out.println(rt);
		
		
	}
	
}
