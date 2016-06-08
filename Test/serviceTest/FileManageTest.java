package serviceTest;

import org.junit.Test;

import com.zzxy.NetDict.Config.ConfigParams;
import com.zzxy.NetDict.Service.FileManageService;


public class FileManageTest {

	@Test
	public void getFileNameTest()
	{
		String filePath = "user/volumes/magic_zhang/aslkdjfalsdjfalsdjfalsd.jpg ";
		int num = FileManageService.getFileType(filePath);	
	
		System.out.println(num);
	}
	
	@Test 
	public void getFileIdTest()
	{
		String filePath = "user/volumes/magic_zhang/aslkdjfalsdjfalsdjfalsd ";
		System.out.println(FileManageService.getFileName(filePath));
	}
	
	@Test
	public void copyFileTest()
	{
		String srcPath = "/Users/Magic_Zhang/Desktop/src/个人简历.docx";
		String targetPath = "/Users/Magic_Zhang/Desktop/tar/";
		
		FileManageService.nioTransferCopy(srcPath, targetPath+FileManageService.getFileName(srcPath)+".txt");
		
		
		
	}
	
}
