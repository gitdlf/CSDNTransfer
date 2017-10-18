package cn.lfsenior.csdnt.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * xml工具类
 * @author LF.zero
 *
 */
public class XMLUtil {
	/**
	 * 根据路径读文件
	 * @throws DocumentException 
	 */
	public static Document getDocument(String path) throws DocumentException{
		SAXReader xmlReader = new SAXReader();
		Document doc = xmlReader.read(new File(path));
		return doc;
	}
	
	/**
	 * 向指定路径写入指定文档
	 * @param path
	 * @param doc
	 * @throws IOException 
	 */
	public static void write(String path,Document doc) throws IOException{
		/**
		 * 根据路径创建输出流，并设置xml格式为简洁格式
		 */
		XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(new File(path)), OutputFormat.createCompactFormat());
		xmlWriter.write(doc);
		xmlWriter.close();
	}
}
