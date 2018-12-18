package com.med.info.rest;

import com.med.info.response.PageObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.med.info.domain.Miss_control_action;
import com.med.info.domain.Miss_control_role;
import com.med.info.mapper.domain.RoleAndActionDTO;
import com.med.info.response.Response;
import com.med.info.service.MissControlActionService;
import com.med.info.service.MissControlRoleAndActionService;

@RestController
@RequestMapping("/api/action")
public class ActionController {

	@Autowired
	private MissControlActionService controlActionService;
	@Autowired
	private MissControlRoleAndActionService missControlRoleAndActionService;
	
	private static Logger logger = LoggerFactory.getLogger(ActionController.class);
	
	@RequestMapping(path="/roleAndAction", method = RequestMethod.GET)
	public Response showActionByRoleCode(@RequestParam(value="roleCode", required = false) String roleCode){
		Miss_control_role miss_control_role = new Miss_control_role();
		miss_control_role.setRolecode(roleCode);
		RoleAndActionDTO roleAndActionDTO = missControlRoleAndActionService.showRoelAndAction(miss_control_role);
		PageObject pageObject = new PageObject<Miss_control_action>();
		pageObject.setParams(roleAndActionDTO.getMissControlAction());
		return new Response().success(pageObject);
	}

	@RequestMapping(path="/page", method = RequestMethod.GET)
	public Response showAction(@RequestParam("currentPage") Integer currentPage,
							   @RequestParam(value="pageSize", defaultValue = "10") Integer pageSize){
		Miss_control_action missControlAction = new Miss_control_action();
		PageObject<Miss_control_action> selectPage = controlActionService.selectPage(currentPage, pageSize, missControlAction);
		return new Response().success(selectPage);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Response addAction(@RequestBody Miss_control_action controlAction) {
		
		try {
			int insert = controlActionService.insert(controlAction);
			if(insert < 0) {
				return new Response().failure("插入错误，请重试");
			}else {
				return new Response().success();
			}
		} catch (Exception e) {
			logger.error("插入数据错误；",e);
			return new Response().failure("插入错误，请重试");
		}
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Response updateAction(@RequestBody Miss_control_action controlAction) {
		
		try {
			int insert = controlActionService.updateByPrimaryKey(controlAction);
			if(insert < 0) {
				return new Response().failure("插入错误，请重试");
			}else {
				return new Response().success();
			}
		} catch (Exception e) {
			logger.error("插入数据错误；",e);
			return new Response().failure("插入错误，请重试");
		}
	}
	
	@RequestMapping(value="/all" ,method = RequestMethod.GET)
	public Response getAllAction(String uuid) {
		
		return null;
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public Response deleteAction(String[] uuids) {
		try {
			controlActionService.deleteByActions(uuids);
			return new Response().success();
		} catch (Exception e) {
			logger.error("删除数据错误；",e);
			return new Response().failure("删除错误，请重试");
		}
		
	}
}
