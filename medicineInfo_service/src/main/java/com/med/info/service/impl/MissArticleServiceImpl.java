package com.med.info.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.med.info.domain.Miss_articleWithBLOBs;
import com.med.info.mapper.BaseMapper;
import com.med.info.mapper.Miss_articleMapper;
import com.med.info.service.MissArticleService;
import com.med.info.utils.CollectionUtil;

@Service
public class MissArticleServiceImpl extends BaseServiceImpl<Miss_articleWithBLOBs> implements MissArticleService{

	@Autowired
	private Miss_articleMapper miss_articleMapper;
	
	@Override
	public BaseMapper getMapper() {
		// TODO Auto-generated method stub
		return miss_articleMapper;
	}

	@Override
	public String getKeyName() {
		return "missArticle";
	}
	@Override
	public String checkArticleInfo(String title, String author) throws Exception {
		// TODO Auto-generated method stub
		List<Miss_articleWithBLOBs> miss_articleWithBLOBs = miss_articleMapper.check(title, author);
		if(!CollectionUtil.isNotEmpty(miss_articleWithBLOBs)) {
			return UUID.randomUUID().toString().replace("-", "");
		}
		throw new Exception("该文章信息已经存在！");
	}

}
