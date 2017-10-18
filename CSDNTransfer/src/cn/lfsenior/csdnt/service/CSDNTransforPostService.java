package cn.lfsenior.csdnt.service;

import java.sql.SQLException;

import cn.lfsenior.csdnt.dao.impl.CreateDatabase;
import cn.lfsenior.csdnt.dao.impl.CreateTables;

public class CSDNTransforPostService {
	public void csdnTransforPost(String database,String nodeXML,String baseURI){
		/**
		 * 创建数据库
		 */
		new CreateDatabase().createDatabase(database);
		/**
		 * 创建表
		 */
		CreateTables ct = new CreateTables();
		try {
			ct.createContentTable(database);
			ct.createCategoryTable(database);
			ct.createContentCategoryTable(database);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
