package luceneTest;

import org.junit.Test;

import com.zzxy.NetDict.lucene.FileManage;

import junit.framework.TestCase;

public class FileManageTest{
   
	@Test
	public void testGetFileName()
	{
		System.out.println(FileManage.getFileName("1"));
	}
	
	@Test
	public void getFileContentTest()
	{
		String filePath = "/Users/Magic_Zhang/desktop/test.txt";
		
		FileManage.getFileContent(filePath);
		
	}
	
	
}
