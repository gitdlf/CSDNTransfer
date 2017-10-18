package cn.lfsenior.csdnt.service;

import cn.lfsenior.csdnt.entity.BlogContent;

/**
 * 封装文章的接口
 * @author LF.zero
 *
 */
public interface ArticlePostService {
	/**
	 * 封装文章的方法，通过文章的URI地址封装
	 * @param baseURI
	 * @return
	 */
	public BlogContent articlePost(String baseURI,String path);
}
