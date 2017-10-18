package cn.lfsenior.junit.test;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.Test;

import cn.lfsenior.csdnt.dao.impl.CreateDatabase;
import cn.lfsenior.csdnt.dao.impl.CreateTables;
import cn.lfsenior.csdnt.dao.impl.OutputDatabase;
import cn.lfsenior.csdnt.util.JdbcUtil;

public class TestDatabase {
	@Test
	public void createDatabase() throws SQLException{
		new CreateDatabase().dropDatabase("jdub_db");
	}
	
	@Test
	public  void slowTest() throws Exception{
		String dataBase="lfsenior_test_csdn";
		new CreateDatabase().createDatabase(dataBase);
		CreateTables createTables = new CreateTables();
		createTables.createContentTable(dataBase);
		createTables.createCategoryTable(dataBase);
		createTables.createContentCategoryTable(dataBase);
	}
	
	@Test
	public void export() throws IOException{
		String dataBase="lfsenior_csdn_first";
		String path="d:\\test.sql";
		OutputDatabase.export(dataBase, JdbcUtil.prop, path);
	}
	
	
	
}
