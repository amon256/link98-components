package me.link98.core.service;

import org.springframework.transaction.annotation.Transactional;

import me.link98.core.domains.common.UploadFile;

@Transactional
public interface UploadFileService extends BaseService<UploadFile>{
}
