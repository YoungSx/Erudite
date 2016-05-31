package ConvertTest;

import org.junit.Test;

import com.zzxy.NetDict.Convert.Word2Html;

public class Word2HtmlTest {
	
	
	@Test
	public void convert2Html(){
		try {
			Word2Html.convert2Html("D://Convert/src.doc", "D://Convert/res.html","D://Convert/Images");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
