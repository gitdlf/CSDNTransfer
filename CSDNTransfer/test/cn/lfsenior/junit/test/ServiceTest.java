package cn.lfsenior.junit.test;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.junit.Test;

import cn.lfsenior.csdnt.entity.ArticleNode;
import cn.lfsenior.csdnt.service.ArticleNodePostService;
import cn.lfsenior.csdnt.util.XMLUtil;

public class ServiceTest {
	@SuppressWarnings("unused")
	@Test
	public void testArticleNodePost() throws DocumentException{
//		String path="src/config/csdn-node.xml";
//		Document doc = XMLUtil.getDocument(path);
//		Node selectSingleNode = doc.selectSingleNode("//title");
//		System.out.println(selectSingleNode.getText());
		ArticleNode articleNodePost = new ArticleNodePostService().articleNodePost("src/config/csdn-node.xml");
//		File file=new File("src/config/csdn-node.xml");
//		System.out.println(file.getAbsolutePath());
//		System.out.println(file.exists());
	}
}
