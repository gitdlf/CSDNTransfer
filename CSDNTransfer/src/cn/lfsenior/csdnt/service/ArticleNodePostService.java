package cn.lfsenior.csdnt.service;

import org.dom4j.Document;
import org.dom4j.DocumentException;

import cn.lfsenior.csdnt.entity.ArticleNode;
import cn.lfsenior.csdnt.util.XMLUtil;

/**
 * 更具xml文件封装ArticleNode对象
 * @author LF.zero
 *
 */
public class ArticleNodePostService {
	public ArticleNode articleNodePost(String path){
		ArticleNode articleNode=new ArticleNode();
		try {
			Document doc = XMLUtil.getDocument(path);
			articleNode.setMaxpagenum(doc.selectSingleNode("//maxpagenum").getText());
			articleNode.setArticleuri(doc.selectSingleNode("//articleuri").getText());
			articleNode.setTilte(doc.selectSingleNode("//title").getText());
			articleNode.setLabels(doc.selectSingleNode("//labels").getText());
			articleNode.setDate(doc.selectSingleNode("//date").getText());
			articleNode.setVist(doc.selectSingleNode("//vist").getText());
			articleNode.setArticle(doc.selectSingleNode("//article").getText());
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return articleNode;
	}
}
