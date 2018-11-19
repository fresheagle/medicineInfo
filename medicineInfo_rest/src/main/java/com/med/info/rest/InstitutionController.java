package com.med.info.rest;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
