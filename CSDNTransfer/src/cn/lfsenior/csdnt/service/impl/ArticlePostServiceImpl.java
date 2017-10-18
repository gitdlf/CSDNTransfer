package cn.lfsenior.csdnt.service.impl;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.LogFactory;
import org.jsoup.nodes.Document;

import cn.lfsenior.csdnt.entity.ArticleNode;
import cn.lfsenior.csdnt.entity.BlogCategory;
import cn.lfsenior.csdnt.entity.BlogContent;
import cn.lfsenior.csdnt.service.ArticleNodePostService;
import cn.lfsenior.csdnt.service.ArticlePostService;
import cn.lfsenior.csdnt.util.CSDNTransfer;

public class ArticlePostServiceImpl implements ArticlePostService {
	public static ArticleNodePostService articleNodeService=new ArticleNodePostService();
	public BlogContent articlePost(String baseURI,String path) {
		ArticleNode articleNode = articleNodeService.articleNodePost(path);
		BlogContent blogContent=new BlogContent();
		/**
		 * 开始封装
		 */
		try {
			Document doc = CSDNTransfer.createDocumet(baseURI);
			blogContent.setContentTitle(CSDNTransfer.getTitle(doc, articleNode.getTilte()));
			blogContent.setContentDate(CSDNTransfer.getpostDate(doc, articleNode.getDate()));
			blogContent.setContentBody(CSDNTransfer.getArticleContent(doc, articleNode.getArticle()));
			blogContent.setContentDescribe(CSDNTransfer.getArticleDescripe(doc, articleNode.getArticle()));
			blogContent.setContentVisit(CSDNTransfer.getVistNumber(doc, articleNode.getVist()));
			List<String> labels = CSDNTransfer.getLabels(doc, articleNode.getLabels());
			Set<BlogCategory> labeSet=new HashSet<BlogCategory>();
			for (String string : labels) {
				labeSet.add(new BlogCategory(string));
			}
			blogContent.setBlogCategorySet(labeSet);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			LogFactory.getLog(getClass()).error(e.getMessage());
			e.printStackTrace();
			blogContent=null;
		}
		return blogContent;
	}

}
