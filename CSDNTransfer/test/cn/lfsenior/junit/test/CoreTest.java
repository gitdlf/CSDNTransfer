package cn.lfsenior.junit.test;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

public class CoreTest {
	private String[] userAgents={"Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36"};
	
	
	@Test
	public void testCore() throws IOException{
		Connection connect = Jsoup.connect("http://blog.csdn.net/qq_33012203");
		connect.userAgent(userAgents[0]);
		Document doc = connect.post();
		/*System.out.println(doc);*/
		/*标题*/
		//System.out.println(getTitle(doc, ".link_title a"));
		/*标签*/
		/*List<String> labels = getLabels(doc, ".link_categories a");
		for (String string : labels) {
			System.out.println(string);
		}*/
		
		/*时间*/
		//System.out.println(getpostDate(doc, ".link_postdate"));
		
		/*访问量*/
		/*System.out.println(getVistNumber(doc, ".link_view"));*/
		
		
		/*文章内容*/
		/*System.out.println(getArticleContent(doc, ".article_content"));*/
		
		/*文章描述*/
		/*System.out.println(getArticleDescripe(doc, ".article_content"));*/
		
		
		/*最大页面数*/
		System.out.println(getMaxPageNumber(doc, "#papelist span"));
		
		/*获取文章列表*/
		/*System.out.println(getArticleUri(5, "#article_list .article_item .article_title a", "http://blog.csdn.net/qq_35448976/article/list/"));*/
		
	}
	
	/**
	 * 获取标题
	 * @param doc 文章的Document对象
	 * @param titleFormat 标题的格式
	 * @return
	 */
	public String getTitle(Document doc,String titleFormat){
		String title="";
		Elements titleNode = doc.select(titleFormat);
		title=titleNode.html().trim();
		return title;
	}
	
	
		
	/**
	 * 获取标签
	 * @param doc
	 * @param labelsFormat
	 * @return
	 */
	public List<String> getLabels(Document doc,String labelsFormat){
		List<String> labels=new ArrayList<String>();
		Elements labelNodes = doc.select(labelsFormat);
		for (Element element : labelNodes) {
			labels.add(element.html().trim());
		}
		return labels;
	} 
	
	/**
	 * 依赖格式
	 */
	private SimpleDateFormat[] simpleDateFormat={new SimpleDateFormat("yyyy-MM-dd hh:mm")};

	
	
	/**
	 * 获取发布时间
	 * @param doc
	 * @param dateFormat
	 * @return
	 */
	public Timestamp getpostDate(Document doc,String dateFormat){
		Elements dateNode = doc.select(dateFormat);
		String dateStr=dateNode.html().trim();
		Timestamp date=new Timestamp(System.currentTimeMillis());
		for(int i=0;i<simpleDateFormat.length;i++){
			try {
				date=new Timestamp(simpleDateFormat[i].parse(dateStr).getTime());
			} catch (ParseException e) {
				continue;
			}
		}
		return date;
	}
	
	/**
	 * 获取访问量
	 * @param doc
	 * @param vistFormat
	 * @return
	 */
	public String getVistNumber(Document doc,String vistFormat){
		String vistNumber="0";
		Elements vistNode = doc.select(vistFormat);
		String vistStr=vistNode.html().trim();
		vistNumber=vistStr.substring(0, vistStr.length()-3);
		return vistNumber;
	}
	
	
	/**
	 * 获取文章内容
	 * @param doc
	 * @param articleFormat
	 * @return
	 */
	public String getArticleContent(Document doc,String articleFormat){
		String articleContent="";
		Elements articleNode = doc.select(articleFormat);
		articleContent=articleNode.html();
		return articleContent;
	}
	
	
	/**
	 * 获取文章描述（1-200个字符）注意：&lt;代替<   &gt;代替>
	 * @param doc
	 * @param articleFormat
	 * @return
	 */
	public String getArticleDescripe(Document doc,String articleFormat){
		String articleDescripe="";
		Elements articleNode = doc.select(articleFormat);
		articleDescripe=articleNode.text();
		articleDescripe=articleDescripe.length()>200?articleDescripe.substring(0, 200):articleDescripe;
		/*
		 * 替换符号
		 */
		
		articleDescripe=articleDescripe.replace("<", "&lt;").replace(">", "&gt;");
		return articleDescripe;
		
	}
	
	/**
	 * 获取最大页数
	 * @param doc
	 * @param maxNumFormat
	 * @return
	 */
	public String getMaxPageNumber(Document doc,String maxNumFormat){
		String maxNumber="1";
		Elements maxNumNode = doc.select(maxNumFormat);
		String maxNumStr=maxNumNode.text().trim();
		maxNumber=maxNumStr.substring(maxNumStr.indexOf("共")+1, maxNumStr.length()-1);
		return maxNumber;
		
	}
	
	/**
	 * 获取文章地址
	 * @param maxPageNumber
	 * @param articleUriFormat
	 * @param baseUri
	 * @return
	 * @throws IOException
	 */
	public List<String> getArticleUri(Integer maxPageNumber,String articleUriFormat,String baseUri) throws IOException{
		List<String> articleUris=new ArrayList<String>();
		for(int i=1;i<=maxPageNumber;i++){
			Elements articleUriNodes = createDocumet(baseUri+i).select(articleUriFormat);
			for (Element element : articleUriNodes) {
				articleUris.add(element.absUrl("href"));
			}
		}
		return articleUris;
	}
	
	
	/**
	 * 获取连接对象
	 * @param uri
	 * @return
	 * @throws IOException
	 */
	public Document createDocumet(String uri) throws IOException{
		Connection connect = Jsoup.connect(uri);
		connect.userAgent(userAgents[new Random().nextInt(simpleDateFormat.length)]);
		return connect.post();
	}
	
	
}
