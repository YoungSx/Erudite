package dBTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.zzxy.NetDict.DB.DBTransaction;
import com.zzxy.NetDict.Entity.TransationInfo;

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
		
		
		List<Object> list = new ArrayList<>();
		
		list.add("111sdsssfsd");
		list.add(2);
		list.add(3);
		list.add(4);
		list.add("111sdfassssdf");
		list.add("111sdfassssdf");
		list.add(3);
		list.add(4);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(1);
		list.add(0);

		List<Object> list1 = new ArrayList<>();
		list1.add("1111sdfassssd");
		list1.add(2);
		list1.add(3);
		list1.add(4);
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		list1.add(0);
		
		TransationInfo info = new TransationInfo();
		TransationInfo info1 = new TransationInfo();
		
		info.setSql(sql1);
		info.setParams(list);
		
		
		info1.setSql(sql2);
		info1.setParams(list1);
		
		
		
		List<TransationInfo> list3 = new ArrayList<TransationInfo>();
		
		list3.add(info);
		list3.add(info1);
		
		boolean rt = DBTransaction.doTransaction(list3);
		
		System.out.println(rt);
		
		
	}
	
}
