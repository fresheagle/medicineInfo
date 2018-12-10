package com.med.info.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.med.info.domain.Miss_control_role;
import com.med.info.response.Response;
import com.med.info.service.MissControlRoleService;

@RestController
@RequestMapping("/api/role")
public class RoleController {
	
	@Autowired
	private MissControlRoleService controlRoleService;
	
	private static Logger logger = LoggerFactory.getLogger(RoleController.class);
	
	@RequestMapping(method = RequestMethod.POST)
	public Response addRole(@RequestBody Miss_control_role controlRole) {
		try {
			int insert = controlRoleService.insert(controlRole);
			if(insert < 0) {
				return new Response().failure("插入角色数据错误");
			}else {
				return new Response().success();
			}
		} catch (Exception e) {
			logger.error("删除数据错误；",e);
			return new Response().failure("删除错误，请重试");
		}
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Response updateRole(@RequestBody Miss_control_role controlRole) {
		try {
			int insert = controlRoleService.updateByPrimaryKey(controlRole);
			if(insert < 0) {
				return new Response().failure("更新数据错误");
			}else {
				return new Response().success();
			}
		} catch (Exception e) {
			logger.error("更新数据错误；",e);
			return new Response().failure("更新错误，请重试");
		}
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public Response deleteRole(String uuid) {
		try {
			int insert = controlRoleService.deleteByPrimaryId(uuid);
			if(insert < 0) {
				return new Response().failure("删除数据错误");
			}else {
				return new Response().success();
			}
		} catch (Exception e) {
			logger.error("删除数据错误；",e);
			return new Response().failure("删除错误，请重试");
		}
	}
	
	@RequestMapping(value="/all",method = RequestMethod.GET)
	public Response getAllRole() {
		return null;
	}

}
