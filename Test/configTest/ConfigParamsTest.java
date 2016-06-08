package configTest;

import org.junit.Test;

import com.zzxy.NetDict.Config.ConfigParams;

public class ConfigParamsTest {

	@Test
	public void configParamsTest()
	{
		System.out.println(ConfigParams.SOLR_URL);
	}
	
	@Test
	public void configParamsWriteTest()
	{
		ConfigParams.setConfigParamByKey("test", "test");
	}
	
	
	@Test
	public void getAllPropsTest()
	{
		ConfigParams.getAllConfigParams();
	}
	
	@Test
	public void testCnName()
	{
		System.out.println(ConfigParams.getConfigCNName("NOTDOC2TXT_PATH"));
	}
	
}
