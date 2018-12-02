package com.med.info.rest;

import com.med.info.mapper.domain.InstitutionInfoDTO;
import com.med.info.response.Response;
import com.med.info.service.InstitutionInfoService;
import com.med.info.service.ParamInfoService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Title: 医疗机构的参数管理 
 * Description: 医疗机构数据的增删改查
 * 
 * @author DELETE
 * 
 */
@RestController
@RequestMapping("/api/institution")
public class InstitutionController {
	private static final Logger log = Logger.getLogger(InstitutionController.class);
	@Autowired
	InstitutionInfoService institutionInfoService;

	/**
	 * 添加医疗机构信息
	 * @param institutionInfoDTO 医疗机构信息
	 * @return 医疗机构id
	 */
	@RequestMapping(method = RequestMethod.POST)
	public Response addInstitutionInfo(@RequestBody InstitutionInfoDTO institutionInfoDTO) {
		try{
			return new Response().success(institutionInfoService.addInstitutionInfo(institutionInfoDTO));
		}catch (Exception e){
			return new Response().failure();
		}
	}

	/**
	 * 修改医疗机构信息
	 * @param institutionInfoDTO 医疗机构信息
	 * @return 医疗机构id
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public Response updateInstitutionInfo(@RequestBody InstitutionInfoDTO institutionInfoDTO) {
		try{
			return new Response().success(institutionInfoService.updateInstitutionInfo(institutionInfoDTO));
		}catch (Exception e){
			return new Response().failure();
		}
	}

	/**
	 * 查询医疗机构信息
	 * @param institutionId 医疗机构id
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public Response queryInstitutionInfo(@RequestBody Integer institutionId) {
		try{
			return new Response().success(institutionInfoService.queryInstitutionInfo(institutionId));
		}catch (Exception e){
			return new Response().failure();
		}
	}

	/**
	 * 删除医疗机构信息
	 * @param institutionId 医疗机构id
	 * @return
	 */
	@RequestMapping(method = RequestMethod.DELETE)
	public Response deleteInstitutionInfo(@RequestBody Integer institutionId) {
		try{
			return new Response().success(institutionInfoService.deleteInstitutionInfo(institutionId));
		}catch (Exception e){
			return new Response().failure();
		}
	}
}
