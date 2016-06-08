package luceneTest;

import org.junit.Test;

import com.zzxy.NetDict.Service.FileManageService;

import junit.framework.TestCase;

public class FileManageTest{
   
	@Test
	public void testGetFileName()
	{
		System.out.println(FileManageService.getFileName("1"));
	}
	
	@Test
	public void getFileContentTest()
	{
		String filePath = "/Users/Magic_Zhang/desktop/test.txt";
		
		FileManageService.getFileContent(filePath);
		
	}
	
	@Test
	public void getFileSuffixNameTest()
	{
		String str = "sdfasdfasd.txt";
		System.out.println(FileManageService.getFileSuffixName(str));
	}
	
}
