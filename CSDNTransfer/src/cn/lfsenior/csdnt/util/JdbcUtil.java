package cn.lfsenior.csdnt.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class JdbcUtil {
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	public static Properties prop=new Properties();
	static{
		try {
			prop.load(JdbcUtil.class.getResourceAsStream("datasource.properties"));
			driver=prop.getProperty("driver");
			url=prop.getProperty("url");
			user=prop.getProperty("user");
			password=prop.getProperty("pwd");
			Class.forName(driver);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 获得数据库连接对象
	 * @return
	 */
	public static Connection getConnection(){
		try {
			return DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			throw new RuntimeException(); 
		}
	}
	
	/**
	 * 关闭数据库连接对象
	 * @param conn
	 * @param stmt
	 * @param rs
	 */
	public static void close(Connection conn,Statement stmt,ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 创表语句连接对象
	 * @param dataBase
	 * @return
	 * @throws SQLException
	 */
	public static Connection getCreateTableConnection(String dataBase) throws SQLException{
		return DriverManager.getConnection(url+dataBase+"?useUnicode=true&characterEncoding=utf8",user,password);
	}
	
	
}
