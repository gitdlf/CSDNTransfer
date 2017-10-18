package cn.lfsenior.csdnt.entity;

import java.io.Serializable;

/**
 * @author LFSenior
 *
 *下午3:56:36
 *
 */
public class BlogCategory implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5011719314663189619L;
	private String categoryId;
	private String categoryName;
	
	
	
	
	public BlogCategory() {
	}
	public BlogCategory(String categoryName){
		this.categoryName=categoryName;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}
