//package com.med.info.service.operate.impl;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
//import com.med.info.domain.Miss_dislocation;
//import com.med.info.mapper.domain.OperateDTO;
//import com.med.info.service.BaseService;
//import com.med.info.service.MissDislocationService;
//
//@Component
//@Order(6)
//public class MissDislocationOperateService extends AbstractOperateService<Miss_dislocation, Miss_dislocation>{
//
//	@Autowired
//	private MissDislocationService dislocationService;
//	
//	@Override
//	public String getCurrentMenuType() {
//		return "missDislocation";
//	}
//
//	@Override
//	public BaseService<Miss_dislocation> baseService(String menuType) {
//		return dislocationService;
//	}
//
//	@Override
//	public Class<?> getCurrentObjectClass() {
//		return Miss_dislocation.class;
//	}
//
//	@Override
//	public boolean needDealMapper() {
//		return false;
//	}
//
//	@Override
//	public String getJsonParamKey() {
//		return "missDislocation";
//	}
//
//}
