package luceneTest;

import org.junit.Test;

import com.zzxy.NetDict.lucene.CustomAnalyzer;

public class CustomAnalyzerTest {

	
	@Test
	public void sentenceCutTest()
	{
		String sentence = "2016枣庄峄城公安分局招聘事业";
		
		CustomAnalyzer.sentenceCut(sentence);
	}
}
