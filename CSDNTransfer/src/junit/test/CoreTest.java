package junit.test;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

public class CoreTest {
	private String[] userAgents={"Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36"};
	@Test
	public void testCore() throws IOException{
		Connection connect = Jsoup.connect("http://blog.csdn.net/qq_35448976");
		connect.userAgent(userAgents[0]);
		Document doc = connect.post();
		System.out.println(doc);
		
	}
	
	public String getTitle(Document doc){
		String title="";
		
		return title;
		
	}
}
