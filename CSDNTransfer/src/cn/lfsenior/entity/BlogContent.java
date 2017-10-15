package cn.lfsenior.entity;


import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 博客内容对象
 * @author LFSenior
 *
 *下午4:08:08
 *
 */
public class BlogContent {
	private int contentId;
	private String contentTitle;
	private Date contentDate;
	private String contentBody;
	private BlogUser blogUser;
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
	public int getContentId() {
		return contentId;
	}
	public void setContentId(int contentId) {
		this.contentId = contentId;
	}
	public String getContentTitle() {
		return contentTitle;
	}
	public void setContentTitle(String contentTitle) {
		this.contentTitle = contentTitle;
	}
	public Date getContentDate() {
		return contentDate;
	}
	public void setContentDate(Date contentDate) {
		this.contentDate = contentDate;
	}
	public String getContentBody() {
		return contentBody;
	}
	public void setContentBody(String contentBody) {
		this.contentBody = contentBody;
	}
	public BlogUser getBlogUser() {
		return blogUser;
	}
	public void setBlogUser(BlogUser blogUser) {
		this.blogUser = blogUser;
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
