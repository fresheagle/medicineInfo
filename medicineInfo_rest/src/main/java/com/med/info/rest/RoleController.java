package com.med.info.rest;

import com.alibaba.fastjson.JSONObject;
import com.med.info.domain.Miss_control_user;
import com.med.info.mapper.domain.OperateDTO;
import com.med.info.mapper.domain.RoleAndActionDTO;
import com.med.info.mapper.domain.UserAndRoleDTO;
import com.med.info.response.PageObject;
import com.med.info.service.MissControlUserAndRoleService;
import com.med.info.utils.UuidUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.med.info.domain.Miss_control_role;
import com.med.info.response.Response;
import com.med.info.service.MissControlRoleAndActionService;
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
	@Autowired
	private MissControlRoleAndActionService missControlRoleAndActionService;

	private static Logger logger = LoggerFactory.getLogger(RoleController.class);

	/**
	 * 查询所有角色参数
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(path="/page", method = RequestMethod.GET)
	public Response showRole(@RequestParam("currentPage") Integer currentPage,
							 @RequestParam(value="pageSize", defaultValue = "10") Integer pageSize,
							 @RequestParam(value="roleName", required = false) String roleName){
		Miss_control_role miss_control_role = new Miss_control_role();
		if(roleName != null){
			miss_control_role.setRolename(roleName);
		}
		PageObject<Miss_control_role> selectPage = controlRoleService.selectPage(currentPage,pageSize,miss_control_role);
		return new Response().success(selectPage);
	}
	/**
	 * 为角色添加菜单权限
	 * @param roleAndActionDTO
	 * @return
	 */
	@RequestMapping(path="/addAction", method = RequestMethod.POST)
	public Response addAction(@RequestBody RoleAndActionDTO roleAndActionDTO) {
		try {
			if(missControlRoleAndActionService.insertRoleAndAction(roleAndActionDTO)) {
				return new Response().success();
			}
			return new Response().failure();
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("角色新增菜单权限报错");
			return new Response().success();
		}
	}
	
	/**
	 * 查询一个用户绑定的角色
	 * @param userCode
	 * @return
	 */
	@RequestMapping(path="/userAndRole", method = RequestMethod.GET)
	public Response showRoleByUser(@RequestParam(value="userCode", required = false) String userCode){
		Miss_control_user missControlUser = new Miss_control_user();
//		List<OperateDTO> listOp = new ArrayList<>();
		missControlUser.setUserCode(userCode);
		UserAndRoleDTO userAndRoleDTO = missControlUserAndRoleService.showUserAndRole(missControlUser);
//		for(int i=0;i<userAndRoleDTO.getMissControlRole().size();i++){
//			OperateDTO operateDTO = new OperateDTO();
//			JSONObject json = new JSONObject();
//			json.put("missControlRole",JSONObject.parseObject(JSONObject.toJSONString(userAndRoleDTO.getMissControlRole().get(i))));
//			operateDTO.setJsonStr(json);
//			listOp.add(operateDTO);
//		}
//		PageObject pageObject = new PageObject();
//		pageObject.setParams(listOp);
//		return new Response().success(pageObject);
		
//		PageObject pageObject = new PageObject<Miss_control_role>();
//		pageObject.setParams(userAndRoleDTO.getMissControlRole());
//		return new Response().success(pageObject);
		return new Response().success(userAndRoleDTO);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Response addRole(@RequestBody Miss_control_role controlRole) {
		try {
			controlRole.setRoleuuid(UuidUtils.generateUUID());
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
	public Response deleteRole(@RequestBody Miss_control_role controlRole) {
		try {
			int insert = controlRoleService.deleteByPrimaryId(controlRole.getRoleuuid());
			missControlRoleAndActionService.deleteByRoleCode(controlRole.getRolecode());
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
