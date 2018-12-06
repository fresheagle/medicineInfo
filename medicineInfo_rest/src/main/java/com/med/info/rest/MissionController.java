package com.med.info.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.med.info.domain.Miss_control_task_detailWithBLOBs;
import com.med.info.mapper.domain.OperateDTO;
import com.med.info.response.PageObject;
import com.med.info.response.Response;
import com.med.info.service.MissionDetailService;
import com.med.info.service.MissionService;

/**
 * 操作业务流程数据
 * @author jiangjialin
 *
 */
@RestController
@RequestMapping("/api/mission")
public class MissionController {
	
	@Autowired
	private MissionService missionService;
	@Autowired
	private MissionDetailService missionDetailService;
	
	@RequestMapping(value="/saveMission",method = RequestMethod.POST)
	@ResponseBody
	public Response save(@RequestBody OperateDTO operateDTO) {
		Object saveMission = missionService.saveMission(operateDTO);
		return new Response().success(saveMission);
	}
	
	@RequestMapping(value="/data/page",method = RequestMethod.GET)
	public Response getByPage(@RequestParam("currentPage") Integer currentPage, @RequestParam(value="pageSize",defaultValue = "10") Integer pageSize, @RequestParam("taskStatus") String taskStatus) {
		
		Object byPage = missionService.getByPage(currentPage, pageSize, taskStatus);
		return new Response().success(byPage);
	}
	
	@RequestMapping(value="/missionDetails/page",method = RequestMethod.GET)
	public Response getMissionDetailList(@RequestParam("currentPage") Integer currentPage, 
			@RequestParam(value="pageSize",defaultValue = "5") Integer pageSize, 
			@RequestParam("taskId") String taskId) {
		Miss_control_task_detailWithBLOBs miss_control_task_detailWithBLOBs = new Miss_control_task_detailWithBLOBs();
		if(taskId != null) {
			miss_control_task_detailWithBLOBs.setTaskId(taskId);
		}
		PageObject<Miss_control_task_detailWithBLOBs> byPage = missionDetailService.selectPageByOperateDto(currentPage, pageSize, miss_control_task_detailWithBLOBs);
		return new Response().success(byPage);
	}
}
