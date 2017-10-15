package cn.lfsenior.entity;


import java.io.Serializable;

/**
 * 博客用户实体类
 * @author LFSenior
 *
 *下午3:16:21
 *
 */
public class BlogUser implements Serializable{
	/**
	 * 增加类序列唯一标识
	 */
	private static final long serialVersionUID = 6882825785076878575L;
	private int userId;
	private String userName;
	private String userEmail;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
}
