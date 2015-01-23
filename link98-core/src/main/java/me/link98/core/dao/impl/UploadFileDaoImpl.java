package me.link98.core.dao.impl;

import org.springframework.stereotype.Component;
import me.link98.core.domains.common.UploadFile;
import me.link98.core.dao.UploadFileDao;

@Component
public class UploadFileDaoImpl extends AbstractDao<UploadFile> implements UploadFileDao{

	@Override
	protected String getNameSapce() {
		return "me.link98.core.domains.common.UploadFile";
	}
}
