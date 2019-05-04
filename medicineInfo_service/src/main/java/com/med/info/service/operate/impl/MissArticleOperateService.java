package com.med.info.service.operate.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.med.info.domain.Miss_articleWithBLOBs;
import com.med.info.dto.MissArticleDTO;
import com.med.info.service.BaseService;
import com.med.info.service.MissArticleService;

@Component
@Order(10)
public class MissArticleOperateService extends AbstractOperateService<Miss_articleWithBLOBs,MissArticleDTO>{

	@Autowired
	MissArticleService missArticleService;
	
	@Override
	public String getJsonParamKey() {
		// TODO Auto-generated method stub
		return "missArticle";
	}

	@Override
	public boolean needDealMapper() {
		// TODO Auto-generated method stub
		return false;
	}

	public Miss_articleWithBLOBs converseObject(MissArticleDTO missArticleDTO) {
		Miss_articleWithBLOBs miss_articleWithBLOBs = new Miss_articleWithBLOBs();
		BeanUtils.copyProperties(missArticleDTO, miss_articleWithBLOBs);
		return miss_articleWithBLOBs;
	}
	
	@Override
	public String getCurrentMenuType() {
		// TODO Auto-generated method stub
		return "missArticle";
	}

	@Override
	public BaseService<Miss_articleWithBLOBs> baseService(String menuType) {
		// TODO Auto-generated method stub
		return missArticleService;
	}

	@Override
	public Class<?> getCurrentObjectClass() {
		// TODO Auto-generated method stub
		return MissArticleDTO.class;
	}

}
