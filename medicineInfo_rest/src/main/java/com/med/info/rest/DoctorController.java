package com.med.info.rest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.med.info.response.Response;
import com.med.info.service.MissDoctorService;

/**
 * Title: 医生相关参数管理 
 * Description: 医生相关参数的增删改查
 * 
 * @author DELETE
 * 
 */
@RestController
@RequestMapping("/api/doctor")
public class DoctorController {
	private static final Logger log = Logger.getLogger(DoctorController.class);
	@Autowired MissDoctorService doctorService;
	
	@RequestMapping(path = "/page", method = RequestMethod.GET)
	public Response getByPage(@RequestParam("currentPage") Integer currentPage,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "sex", required = false) String sex,
			@RequestParam(value = "graduate", required = false) String graduate,
			@RequestParam(value = "profession", required = false) String profession,
			@RequestParam(value = "origin", required = false) String origin) {
		try {
			Object byPage = doctorService.getByPage(currentPage, pageSize, name, sex, graduate, profession, origin);
			return new Response().success(byPage);
		} catch (Exception e) {
			return new Response().failure(e.getMessage());
		}
	}
}
