package com.med.info.rest;

import com.med.info.response.Response;
import com.med.info.service.MissMedicalService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Title: 药品信息的参数管理 
 * Description: 药品信息数据的增删改查
 * 
 * @author DELETE
 * 
 */
@RestController
@RequestMapping("/api/medical")
public class MedicalController {
	private static final Logger log = Logger.getLogger(MedicalController.class);
	@Autowired private MissMedicalService missMedicalService;

	@RequestMapping(path = "/page", method = RequestMethod.GET)
	public Response getByPage(@RequestParam("currentPage") Integer currentPage,
							  @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
							  @RequestParam(value = "name", required = false) String name,
							  @RequestParam(value = "chinesePinyin", required = false) String chinesePinyin,
							  @RequestParam(value = "alisaName", required = false) String alisaName,
							  @RequestParam(value = "shopName", required = false) String shopName,
							  @RequestParam(value = "englishName", required = false) String englishName){
		Object byPage = missMedicalService.getByPage(currentPage, pageSize, name, chinesePinyin, alisaName, shopName, englishName);
		return new Response().success(byPage);
	}

}
