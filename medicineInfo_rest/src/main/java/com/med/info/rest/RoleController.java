package com.med.info.rest;

import com.alibaba.fastjson.JSONObject;
import com.med.info.domain.Miss_control_user;
import com.med.info.mapper.domain.OperateDTO;
import com.med.info.mapper.domain.UserAndRoleDTO;
import com.med.info.response.PageObject;
import com.med.info.service.MissControlUserAndRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.med.info.domain.Miss_control_role;
import com.med.info.response.Response;
import com.med.info.service.MissControlRoleService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/role")
public class RoleController {
	
	@Autowired
	private MissControlRoleService controlRoleService;
	@Autowired
	private MissControlUserAndRoleService missControlUserAndRoleService;

	private static Logger logger = LoggerFactory.getLogger(RoleController.class);

	/**
	 * 查询所有角色参数
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(path="/page", method = RequestMethod.GET)
	public Response showRole(@RequestParam("currentPage") Integer currentPage,
							 @RequestParam(value="pageSize", defaultValue = "10") Integer pageSize){
		Miss_control_role miss_control_role = new Miss_control_role();
		PageObject<Miss_control_role> selectPage = controlRoleService.selectPageByOperateDto(currentPage,pageSize,miss_control_role);
		return new Response().success(selectPage);
	}

	/**
	 * 查询一个用户绑定的角色
	 * @param userCode
	 * @return
	 */
	@RequestMapping(path="/UserAndRole", method = RequestMethod.GET)
	public Response showRoleByUser(@RequestParam(value="userCode", required = false) String userCode){
		Miss_control_user miss_control_user = new Miss_control_user();
		List<OperateDTO> listOp = new ArrayList<>();
		UserAndRoleDTO userAndRoleDTO = missControlUserAndRoleService.showUserAndRole(miss_control_user);
		miss_control_user.setUserCode(userCode);
		for(int i=0;i<userAndRoleDTO.getMissControlRole().size();i++){
			OperateDTO operateDTO = new OperateDTO();
			JSONObject json = new JSONObject();
			json.put("missControlRole",JSONObject.parseObject(JSONObject.toJSONString(userAndRoleDTO.getMissControlRole().get(i))));
			operateDTO.setJsonStr(json);
			listOp.add(operateDTO);
		}
		PageObject pageObject = new PageObject();
		pageObject.setParams(listOp);
		return new Response().success(pageObject);
	}

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
