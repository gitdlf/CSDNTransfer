package cn.lfsenior.csdnt.dao;

import java.sql.Connection;

import cn.lfsenior.csdnt.entity.BlogContent;

/**
 * 文章内容相关的dao接口
 * 
 * @author LF.zero
 *
 */
public interface ContentDao {
	/**
	 * 保存文章
	 * @param blogContent
	 */
	public void save(BlogContent blogContent,Connection conn);
	
	/**
	 * 根据相应的条件查询
	 * @param blogContent
	 * @return
	 */
	public BlogContent findBlogContent(BlogContent blogContent,Connection conn);
}
