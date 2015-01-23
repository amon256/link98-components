package me.link98.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import me.link98.core.domains.common.UploadFile;
import me.link98.core.dao.BaseDao;
import me.link98.core.dao.UploadFileDao;
import me.link98.core.service.UploadFileService;

@Component
public class UploadFileServiceImpl extends AbstractService<UploadFile> implements UploadFileService{
	@Autowired
	private UploadFileDao dao;

	@Override
	protected BaseDao<UploadFile> getDao() {
		return dao;
	}
}
