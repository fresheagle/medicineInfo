package com.med.info.rest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.med.info.domain.Miss_department;
import com.med.info.response.PageObject;
import com.med.info.response.Response;
import com.med.info.service.MissDepartmentService;

/**
 * Title: 部门科室参数配置管理 
 * Description: 对部门科室相关参数的增删改查
 * 
 * @author zhangmin
 *
 */
@RestController
@RequestMapping("/api/department")
public class DepartmentController {
	private static final Logger log = Logger.getLogger(DiseaseController.class);
	
	@Autowired
	MissDepartmentService missDepartmentService;
	/**
	 * 部门分页查询
	 */
	@RequestMapping(path="/page", method = RequestMethod.GET)
	public Response selectPage(@RequestParam("currentPage") Integer currentPage, 
			@RequestParam(value="pageSize", defaultValue = "10") Integer pageSize,
			@RequestParam(value="id", required = false) Long id, 
			@RequestParam(value="parentDepartmentId", required = false) Long parentDepartmentId,
			@RequestParam(value="departmentName", required = false) String departmentName) {
		Miss_department miss_department = new Miss_department();
		if(id != null) {
			miss_department.setId(id);
		}
		if(parentDepartmentId != null) {
			miss_department.setParentDepartmentId(parentDepartmentId);
		}
		if(departmentName != null) {
			miss_department.setDepartmentName(departmentName);
		}
		PageObject<Miss_department> selectPage = missDepartmentService.selectPageByOperateDto(currentPage, pageSize, miss_department);
		return new Response().success(selectPage);
	}
}
