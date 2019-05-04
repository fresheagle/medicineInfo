package com.med.info.service;

import com.med.info.domain.Miss_articleWithBLOBs;

public interface MissArticleService extends BaseService<Miss_articleWithBLOBs>{

	String checkArticleInfo(String title, String author) throws Exception;
}
