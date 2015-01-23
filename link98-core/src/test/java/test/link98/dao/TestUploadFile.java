/**
 * TestUploadFile.java
 * @create by fengmengyue
 * @since 2015年1月22日
 */
package test.link98.dao;

import java.util.UUID;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import me.link98.core.domains.common.UploadFile;
import me.link98.core.service.UploadFileService;
import test.link98.AbstractTest;

/**  
 * <b>Description：</b> 对功能点的描述<br/>
 * <b>@author： </b>fengmengyue<br/>
 * <b>@date：</b>2015年1月22日 <br/>     
 */
public class TestUploadFile extends AbstractTest {
	
	@Autowired
	private UploadFileService service;
	
	@Test
	public void insert(){
		UploadFile file = new UploadFile();
		file.setId(UUID.randomUUID().toString());
		file.setFileName("test.txt");
		file.setFilePath("D:/filexxxx.tt");
		service.insert(file);
	}
}
