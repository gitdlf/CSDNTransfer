package cn.lfsenior.csdnt.dao.impl;

import java.sql.Connection;
import java.util.List;

import cn.lfsenior.core.dao.impl.BaseDaoImpl;
import cn.lfsenior.csdnt.dao.CategoryDao;
import cn.lfsenior.csdnt.entity.BlogCategory;

public class CategoryDaoimpl extends BaseDaoImpl<BlogCategory> implements CategoryDao {

	public void save(BlogCategory category,  Connection conn) {
		// TODO Auto-generated method stub
		update("INSERT INTO blog_category(categoryId,categoryName) values(?,?)"
				, conn
				,category.getCategoryId()
				,category.getCategoryName());
	}

	public BlogCategory findBlogCategory(BlogCategory blogCategory,  Connection conn) {
		// TODO Auto-generated method stub
		List<BlogCategory> resutlList = query("SELECT categoryId,categoryName FROM BLOG_CATEGORY  where categoryName=?", conn, blogCategory.getCategoryName());
		return resutlList.size()>0?resutlList.get(0):null;
	}

}
