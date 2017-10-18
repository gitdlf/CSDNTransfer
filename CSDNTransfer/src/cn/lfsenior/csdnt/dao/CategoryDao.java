package cn.lfsenior.csdnt.dao;

import java.sql.Connection;

import cn.lfsenior.csdnt.entity.BlogCategory;

public interface CategoryDao {
	public void save(BlogCategory category,Connection conn);
	
	public BlogCategory findBlogCategory(BlogCategory blogCategory,Connection conn);
}
