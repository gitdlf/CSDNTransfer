package cn.lfsenior.csdnt.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.logging.LogFactory;

import cn.lfsenior.csdnt.util.JdbcUtil;

public class CreateDatabase {
	private Connection conn;
	private Statement stmt;

	/**
	 * 创建数据库
	 * 
	 * @param database
	 * @throws SQLException
	 *             v1.2 lfsneior修改增加日志功能
	 */
	public void createDatabase(String database) {
		/*
		 * 创建之前先删除数据库
		 */
		dropDatabase(database);
		conn = JdbcUtil.getConnection();
		String sql = "CREATE DATABASE " + database;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			LogFactory.getLog(getClass()).error(e.getMessage());
			e.printStackTrace();
		}
		JdbcUtil.close(conn, stmt, null);
	}

	/**
	 * 删除数据库
	 * 
	 * @param database
	 * @throws SQLException
	 */
	public void dropDatabase(String database) {
		conn = JdbcUtil.getConnection();
		String sql = "DROP DATABASE IF EXISTS" + database;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			LogFactory.getLog(getClass()).error(e.getMessage());
			e.printStackTrace();
		}
		JdbcUtil.close(conn, stmt, null);
	}

	/**
	 * 根据用户创建的数据库获得对应的连接对象
	 * 
	 * @param createSql
	 * @throws SQLException
	 */
	public void createTable(String createSql, String dataBase){
		try {
			conn = JdbcUtil.getCreateTableConnection(dataBase);
			stmt = conn.createStatement();
			stmt.executeUpdate(createSql);
		} catch (SQLException e){
			LogFactory.getLog(getClass()).error(e.getMessage());
			e.printStackTrace();
		}
		JdbcUtil.close(conn, stmt, null);
	}
}
