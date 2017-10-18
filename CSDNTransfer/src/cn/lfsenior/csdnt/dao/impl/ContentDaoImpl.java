package cn.lfsenior.csdnt.dao.impl;

import java.sql.Connection;

import cn.lfsenior.core.dao.impl.BaseDaoImpl;
import cn.lfsenior.csdnt.dao.ContentDao;
import cn.lfsenior.csdnt.entity.BlogCategory;
import cn.lfsenior.csdnt.entity.BlogContent;
import cn.lfsenior.csdnt.util.JdbcUtil;
import cn.lfsenior.csdnt.util.UUidUtil;

public class ContentDaoImpl extends BaseDaoImpl<BlogContent> implements ContentDao {

	public void save(BlogContent blogContent,Connection conn) {
		String contentId=UUidUtil.getUUid();
		String categoryId="";
		update("INSERT INTO blog_content(contentId,contentTitle,contentDate,contentBody,contentVisit,contentDescribe) VALUES(?,?,?,?,?,?)"
				,conn
				,contentId
				,blogContent.getContentTitle()
				,blogContent.getContentDate()
				,blogContent.getContentBody()
				,blogContent.getContentVisit()
				,blogContent.getContentDescribe());
		
		blogContent.setContentId(contentId);
		/**
		 * 保存所有的类别数据，并进结果插入到标签-内容表中
		 */
		CategoryDaoimpl cateDao = new CategoryDaoimpl();
		ContentCategoryDaoImpl conCateDao=new ContentCategoryDaoImpl();
		for (BlogCategory category : blogContent.getBlogCategorySet()) {
			BlogCategory cate = cateDao.findBlogCategory(category, conn);
			if(cate==null){
				//如果等于null
				/*
				 *获取uuid 
				 */
				categoryId=UUidUtil.getUUid();
				category.setCategoryId(categoryId);
				cateDao.save(category, conn);
				conCateDao.save(category, blogContent, conn);
			}else{
				conCateDao.save(cate, blogContent, conn);
			}
		}
	}

	public BlogContent findBlogContent(BlogContent blogContent,Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}

}
