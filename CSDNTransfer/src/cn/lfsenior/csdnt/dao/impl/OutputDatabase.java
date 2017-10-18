package cn.lfsenior.csdnt.dao.impl;

import java.io.IOException;
import java.util.Properties;

/**
 * 导出数据库
 * 
 * @author LF.zero
 *
 */
public class OutputDatabase {

	public static void export(String database,Properties properties,String path) throws IOException {
		Runtime runtime = Runtime.getRuntime();
		String command = getExprotCommand(database,properties,path);
		runtime.exec(command);
	}

	private static String getExprotCommand(String database,Properties properties,String path) {
		StringBuffer command = new StringBuffer();
		String username = properties.getProperty("user");// 用户名
		String password = properties.getProperty("pwd");// 用户密码
		String host = properties.getProperty("host");// 从哪个主机导出数据库，如果没有指定这个值，则默认取localhost
		String port = properties.getProperty("port");// 使用的端口号
		command.append("mysqldump -u").append(username).append(" -p").append(password)//密码是用的小p，而端口是用的大P。  
        .append(" -h").append(host).append(" -P").append(port).append(" ").append(database).append(" -r ").append(path);  
		return command.toString();
	}
}
