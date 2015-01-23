/**
 * UploadFile.java
 * @create by fengmengyue
 * @since 2015年1月22日
 */
package me.link98.core.domains.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import me.link98.core.domains.AbstractRecordBean;

/**  
 * <b>Description：</b> 上传文件记录<br/>
 * <b>@author： </b>fengmengyue<br/>
 * <b>@date：</b>2015年1月22日 <br/>     
 */
@Entity
@Table(name="t_upload_file")
public class UploadFile extends AbstractRecordBean {
	private static final long serialVersionUID = -2812663786622465620L;

	/**
	 * 原始文件名
	 */
	@Column(name="f_file_name",length=200)
	private String fileName;
	
	/**
	 * 文件存放路径
	 */
	@Column(name="f_file_path",length=500)
	private String filePath;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
}
