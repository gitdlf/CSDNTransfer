package cn.lfsenior.junit.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.jsoup.nodes.Document;
import org.junit.Test;

import cn.lfsenior.csdnt.dao.impl.ContentDaoImpl;
import cn.lfsenior.csdnt.dao.impl.CreateDatabase;
import cn.lfsenior.csdnt.dao.impl.CreateTables;
import cn.lfsenior.csdnt.dao.impl.OutputDatabase;
import cn.lfsenior.csdnt.entity.ArticleNode;
import cn.lfsenior.csdnt.entity.BlogCategory;
import cn.lfsenior.csdnt.entity.BlogContent;
import cn.lfsenior.csdnt.service.ArticleNodePostService;
import cn.lfsenior.csdnt.service.impl.ArticlePostServiceImpl;
import cn.lfsenior.csdnt.util.CSDNTransfer;
import cn.lfsenior.csdnt.util.JdbcUtil;

public class FirstAllTest {

	@Test
	public void test() throws Exception {
		String database="lfsenior_csdn_first";
		String nodeXml="config/csdn-node.xml";
		String url="http://blog.csdn.net/qq_35448976/article/details/78246384";
		/**
		 * 创建数据库
		 */
		new CreateDatabase().createDatabase(database);
		/**
		 * 创建表
		 */
		CreateTables ct = new CreateTables();
		ct.createContentTable(database);
		ct.createCategoryTable(database);
		ct.createContentCategoryTable(database);
		
		/**
		 * 开始查询数据
		 */
		BlogContent articlePost = new ArticlePostServiceImpl().articlePost(url, nodeXml);
		/**
		 * 保存数据
		 */
		new ContentDaoImpl().save(articlePost, JdbcUtil.getCreateTableConnection(database));
	}
	
	@Test
	public void testFormat(){
		String nodeXml="config/csdn-node.xml";
		String url="http://blog.csdn.net/qq_35448976/article/details/78246384";
		BlogContent articlePost = new ArticlePostServiceImpl().articlePost(url, nodeXml);
		System.out.println(articlePost);
	}
	
	@Test
	public void testAll() throws SQLException, Exception{
		String uri="http://blog.csdn.net/qq_33012203";
		String nodeXml="config/csdn-node.xml";
		String database="csdn_qq_33012203";
		
		/**
		 * 创建数据库
		 */
		new CreateDatabase().createDatabase(database);
		/**
		 * 创建表
		 */
		CreateTables ct = new CreateTables();
		ct.createContentTable(database);
		ct.createCategoryTable(database);
		ct.createContentCategoryTable(database);
		
		/**
		 * 获得所有数据
		 */
		
		ArticleNode articleNode = new ArticleNodePostService().articleNodePost(nodeXml);
		
		/**
		 * 获得文本对象
		 */
		Document doc = CSDNTransfer.createDocumet(uri);
		/**
		 * 获取所有字列表
		 */
		String maxPageNumber = CSDNTransfer.getMaxPageNumber(doc, articleNode.getMaxpagenum());
		List<String> articleUri = CSDNTransfer.getArticleUri(Integer.parseInt(maxPageNumber), articleNode.getArticleuri(), "http://blog.csdn.net/qq_35448976/article/list/");
		for (String string : articleUri) {
			/**
			 * 开始查询数据
			 */
			
			BlogContent articlePost = new ArticlePostServiceImpl().articlePost(string, nodeXml);
			/**
			 * 保存数据
			 */
			new ContentDaoImpl().save(articlePost, JdbcUtil.getCreateTableConnection(database));
			System.out.println(string+"----成功");
		}
		OutputDatabase.export(database, JdbcUtil.prop, "d:\\"+database+".sql");
	}
	
	@Test
	public void testCate() throws Exception{
		BlogCategory blogCategory=new BlogCategory("spring");
//		BlogCategory findBlogCategory = new CategoryDaoimpl().findBlogCategory(blogCategory,JdbcUtil.getCreateTableConnection("csdn_qq_33012203"));
		Connection conn=JdbcUtil.getCreateTableConnection("csdn_qq_33012203");
		QueryRunner queryRunner=new QueryRunner();
		queryRunner.query(conn, "SELECT * FROM BLOG_CATEGORY  where categoryName=?",new ResultSetHandler<BlogCategory>(){

			public BlogCategory handle(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				while(rs.next()){
					System.out.println(rs.getString(2));
				}
				return null;
			}
			
		}, blogCategory.getCategoryName());
		
	}

}
