package cn.lfsenior.core.dao;

import java.sql.Connection;
import java.util.List;

/**
 * 所有dao层的基础模块
 * @author LF.zero
 *
 * @param <T>
 */
public interface BaseDao<T> {
	/**
	 * 查询服务
	 * @param sql 查询操作的sql语句
	 * @param conn 连接对象
	 * @param args 参数列表
	 * @return 返回一个List集合
	 */
	public List<T> query(String sql,Connection conn,Object ...args);
	
	
	/**
	 * 更新服务
	 * @param sql 更新的sql语句
	 * @param conn 连接对象
	 * @param args 参数列表
	 */
	public void update(String sql,Connection conn,Object ...args);
}
