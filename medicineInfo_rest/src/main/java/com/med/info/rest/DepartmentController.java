package com.med.info.rest;

import com.med.info.mapper.domain.DepartmentMapDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.med.info.domain.Miss_department;
import com.med.info.response.PageObject;
import com.med.info.response.Response;
import com.med.info.service.MissDepartmentService;

import java.util.List;

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
	private static final Logger log = LoggerFactory.getLogger(DepartmentController.class);
	
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
		PageObject<Miss_department> selectPage = missDepartmentService.selectPage(currentPage, pageSize, miss_department);
		return new Response().success(selectPage);
	}

	@RequestMapping(path = "/select/institution", method = RequestMethod.GET)
	public Response selectByDeInstitution(@RequestParam(value="institutionId") Long institutionId){
		try {
			List<DepartmentMapDTO> missDepartmentList = missDepartmentService.getDepartmentMapByInstitutionId(institutionId);
			return new Response().success(missDepartmentList);
		} catch (Exception e) {
			log.error("查询对应部分失败， institutionId = {}", institutionId.toString(), e);
			return new Response().failure("查询失败");
		}
	}

}
