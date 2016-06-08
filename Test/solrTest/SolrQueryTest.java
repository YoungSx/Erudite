package solrTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.zzxy.NetDict.Config.ConfigParams;
import com.zzxy.NetDict.Solr.SolrQuerys;

public class SolrQueryTest {

	@Test
	public void customSolrQueryTest()
	{
		String field = ConfigParams.FIELD_CONTENT;
		List<String> list = new ArrayList<String>();
		
		list.add("大学");
		list.add("");
		list.add("我");
		list.add("    ");
		list.add("我");
		
		SolrQuerys.customSolrQuery(field, list);
		
		
	}
	
}
