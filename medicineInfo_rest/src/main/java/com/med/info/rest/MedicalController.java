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

	@RequestMapping(value = "check", method = RequestMethod.GET)
    public Response checkInfo(@RequestParam(value = "comName", required = false) String comName, @RequestParam(value = "englishName", required = false) String englishName, 
    		@RequestParam(value = "chinesePinyin", required = false) String chinesePinyin, @RequestParam(value = "shopName", required = false) String shopName) {
        if (null == comName && null == englishName && null == chinesePinyin && null == shopName) {
            return new Response().failure("校验条件至少传递一个");
        }
        try {
            String taskId = missMedicalService.checkMedicalInfo(comName, englishName, chinesePinyin, shopName);
            return new Response().success(taskId);
        } catch (Exception e) {
            return new Response().failure(e.getMessage());
        }
    }
}
