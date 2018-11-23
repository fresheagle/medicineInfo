package com.med.info.rest;

import com.med.info.response.Response;
import com.med.info.service.InstitutionInfoService;
import com.med.info.service.ParamInfoService;
import com.med.info.service.dto.InstitutionInfoDTO;
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
@RequestMapping("/institution")
public class InstitutionController {
	private static final Logger log = Logger.getLogger(InstitutionController.class);
	@Autowired
	InstitutionInfoService institutionInfoService;
	@Autowired
	ParamInfoService paramInfoService;

	@RequestMapping(method = RequestMethod.POST)
	public Response addInstitutionInfo(@RequestBody InstitutionInfoDTO institutionInfoDTO) {
		institutionInfoService.addInstitutionInfo(institutionInfoDTO);
		return null;
	}

	@RequestMapping(method = RequestMethod.PUT)
	public Response updateInstitutionInfo(@RequestBody InstitutionInfoDTO institutionInfoDTO) {
		institutionInfoService.updateInstitutionInfo(institutionInfoDTO);
		return null;
	}

	@RequestMapping(method = RequestMethod.GET)
	public Response queryInstitutionInfo(@RequestBody Integer institutionId) {
		institutionInfoService.queryInstitutionInfo(institutionId);
		return null;
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public Response deleteInstitutionInfo(@RequestBody Integer institutionId) {
		institutionInfoService.deleteInstitutionInfo(institutionId);
		return null;
	}


}
