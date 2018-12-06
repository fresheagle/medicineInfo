package com.med.info.rest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.med.info.domain.Miss_dislocation;
import com.med.info.response.PageObject;
import com.med.info.response.Response;
import com.med.info.service.MissDislocationService;

/**
 * Title: 发病部位参数管理 
 * Description: 发病部位相关参数的增删改查
 * 
 * @author DELETE
 * 
 */
@RestController
@RequestMapping("/api/dislocation")
public class DislocationController {
	private static final Logger log = Logger.getLogger(DislocationController.class);
	
	@Autowired
	MissDislocationService missDislocationService;
	
	@RequestMapping(path = "/param", method = RequestMethod.GET)
	public Response selectDiseaseParam(
		@RequestParam("currentPage") Integer currentPage,
        @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
        @RequestParam(value = "id", required = false) Long id,
        @RequestParam(value = "parentDislocationId", required = false) Long parentDislocationId,
        @RequestParam(value = "dislocationName", required = false) String dislocationName) {
		Miss_dislocation miss_dislocation = new Miss_dislocation();
		if(id != null) {
			miss_dislocation.setId(id);
		}
		if(parentDislocationId != null) {
			miss_dislocation.setParentDislocationId(parentDislocationId);
		}
		if(dislocationName != null) {
			miss_dislocation.setDislocationName(dislocationName);
		}
		//return new Response().success(missDislocationService.getDislocationMapDTOByName(currentPage, pageSize, id, parentDislocationId, dislocationName));
		PageObject<Miss_dislocation> selectPage = missDislocationService.selectPageByOperateDto(currentPage, pageSize, miss_dislocation);
		return new Response().success(selectPage);
	}
}
