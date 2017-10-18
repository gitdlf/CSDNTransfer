package cn.lfsenior.csdnt.dao;

import java.sql.Connection;

import cn.lfsenior.csdnt.entity.BlogCategory;
import cn.lfsenior.csdnt.entity.BlogContent;

public interface ContentCategoryDao {
	public void save(BlogCategory category,BlogContent content,Connection conn);
}
