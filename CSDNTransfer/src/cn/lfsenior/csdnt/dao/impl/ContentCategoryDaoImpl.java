package cn.lfsenior.csdnt.dao.impl;

import java.sql.Connection;

import cn.lfsenior.core.dao.impl.BaseDaoImpl;
import cn.lfsenior.csdnt.dao.ContentCategoryDao;
import cn.lfsenior.csdnt.entity.BlogCategory;
import cn.lfsenior.csdnt.entity.BlogContent;

public class ContentCategoryDaoImpl extends BaseDaoImpl<BlogContent> implements ContentCategoryDao {

	public void save(BlogCategory category, BlogContent content, Connection conn) {
		// TODO Auto-generated method stub
		update("INSERT INTO blog_content_category(contentId ,categoryId ) values(?,?)", conn, content.getContentId(),category.getCategoryId());
	}

}
