package cn.lfsenior.core.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.logging.LogFactory;

import cn.lfsenior.core.dao.BaseDao;

public abstract class BaseDaoImpl<T> implements BaseDao<T> {
	Class<T> clazz;

	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		ParameterizedType pType = (ParameterizedType) getClass().getGenericSuperclass();
		clazz = (Class<T>) pType.getActualTypeArguments()[0];
	}

	public List<T> query(String sql, Connection conn, Object... args) {
		QueryRunner queryRunner = new QueryRunner();
		List<T> resultValue = new ArrayList<T>();
		try {
			resultValue = queryRunner.query(conn, sql, new BeanListHandler<T>(clazz), args);
		} catch (SQLException e) {
			LogFactory.getLog(getClass()).error(e.getMessage());
			e.printStackTrace();
		}
		return resultValue;
	}

	public void update(String sql, Connection conn, Object... args) {
		QueryRunner queryRunner = new QueryRunner();
		try {
			queryRunner.update(conn, sql, args);
		} catch (SQLException e) {
			LogFactory.getLog(getClass()).error(e.getMessage());
			e.printStackTrace();
		}
	}

}
