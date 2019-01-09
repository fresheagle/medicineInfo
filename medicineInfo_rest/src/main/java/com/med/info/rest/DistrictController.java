package com.med.info.rest;

import com.med.info.mapper.domain.DislocationMapDTO;
import com.med.info.mapper.domain.DistrictMapDTO;
import com.med.info.response.Response;
import com.med.info.service.MissDistrictService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Title: 地域地区参数管理 
 * Description: 地域地区参数的增删改查
 * 
 * @author DELETE
 * 
 */
@RestController
@RequestMapping("/api/district")
public class DistrictController {
	private static final Logger log = Logger.getLogger(DistrictController.class);

	@Autowired
	private MissDistrictService missDistrictService;

	@RequestMapping(path = "/query", method = RequestMethod.GET)
	public Response selectDistrict(@RequestParam(value = "parentDistrictCode", required = false) Long parentId,
								   @RequestParam(value = "level") String level){

		try {
			List<DistrictMapDTO> dislocationMapDTOS = missDistrictService.selectDistrict(parentId, level);
			return  new Response().success(dislocationMapDTOS);
		} catch (Exception e) {
			log.error("查询区域失败。",e);
			return new Response().failure(e.getMessage());
		}
	}
	
}
