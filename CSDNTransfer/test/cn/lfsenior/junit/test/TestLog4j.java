package cn.lfsenior.junit.test;

import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class TestLog4j {
	@Test
	public void testLog(){
		Log log = LogFactory.getLog(getClass());
		log.debug("debug 级别");
		log.info("info 级别");
		log.error("erro 级别");
	}
	
	@Test
	public void testUUid(){
		System.out.println(UUID.randomUUID().toString().replace("-", ""));
	}
}	
