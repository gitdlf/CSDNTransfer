package cn.lfsenior.csdnt.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * 博客内容对象
 * @author LFSenior
 *
 *下午4:08:08
 *
 */
public class BlogContent implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2947363339826016143L;
	private String contentId;
	private String contentTitle;
	private Timestamp contentDate;
	private String contentBody;
	private String contentLabel;
	private String contentVisit;
	private Set<BlogCategory> blogCategorySet=new HashSet<BlogCategory>();
	private String contentDescribe;
	
	
	public String getContentDescribe() {
		return contentDescribe;
	}
	public void setContentDescribe(String contentDescribe) {
		this.contentDescribe = contentDescribe;
	}
	public String getContentId() {
		return contentId;
	}
	public void setContentId(String contentId) {
		this.contentId = contentId;
	}
	public String getContentTitle() {
		return contentTitle;
	}
	public void setContentTitle(String contentTitle) {
		this.contentTitle = contentTitle;
	}
	public Timestamp getContentDate() {
		return contentDate;
	}
	public void setContentDate(Timestamp contentDate) {
		this.contentDate = contentDate;
	}
	public String getContentBody() {
		return contentBody;
	}
	public void setContentBody(String contentBody) {
		this.contentBody = contentBody;
	}
	public String getContentLabel() {
		return contentLabel;
	}
	public void setContentLabel(String contentLabel) {
		this.contentLabel = contentLabel;
	}
	public String getContentVisit() {
		return contentVisit;
	}
	public void setContentVisit(String contentVisit) {
		this.contentVisit = contentVisit;
	}
	public Set<BlogCategory> getBlogCategorySet() {
		return blogCategorySet;
	}
	public void setBlogCategorySet(Set<BlogCategory> blogCategorySet) {
		this.blogCategorySet = blogCategorySet;
	}
}
