package cn.lfsenior.csdnt.dao.impl;

import java.sql.SQLException;

public class CreateTables {
	/**
	 * 创建类别表
	 * 
	 * @throws SQLException
	 */
	public void createCategoryTable(String dataBase) throws SQLException {
		String sql = "CREATE TABLE blog_category("
				+ "categoryId VARCHAR(100) PRIMARY KEY,"
				+ "categoryName VARCHAR(100))";
		new CreateDatabase().createTable(sql,dataBase);
	}

	/**
	 * 创建内容表
	 * 
	 * @throws SQLException
	 */
	public void createContentTable(String dataBase) throws SQLException {
		String sql = "CREATE TABLE blog_content("
				+ "contentId VARCHAR(100) PRIMARY KEY,"
				+ " contentTitle VARCHAR(100),"
				+ "contentDate DATE,"
				+ "contentBody LONGTEXT,"
				+ "contentLabel VARCHAR(100),"
				+ "contentVisit VARCHAR(100),"
				+ "contentDescribe VARCHAR(5000))";
		new CreateDatabase().createTable(sql,dataBase);
	}

	/**
	 * 创建内容类别关联表
	 * @throws SQLException
	 */
	public void createContentCategoryTable(String dataBase) throws SQLException {
		String sql = "CREATE TABLE blog_content_category("
				+ "contentId VARCHAR(100),"
				+ "categoryId VARCHAR(100));";
		new CreateDatabase().createTable(sql,dataBase);
	}

}
