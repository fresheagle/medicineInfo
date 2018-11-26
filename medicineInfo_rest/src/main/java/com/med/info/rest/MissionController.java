package com.med.info.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.med.info.response.Response;
import com.med.info.service.MissionService;
import com.med.info.service.dto.OperateDTO;

/**
 * 操作业务流程数据
 * @author jiangjialin
 *
 */
@RestController
@RequestMapping("/mission")
public class MissionController {
	
	@Autowired
	private MissionService missionService;
	
	@RequestMapping(value="/saveMission",method = RequestMethod.POST)
	@ResponseBody
	public Response save(@RequestBody OperateDTO operateDTO) {
		Object saveMission = missionService.saveMission(operateDTO);
		return new Response().success(saveMission);
	}

}