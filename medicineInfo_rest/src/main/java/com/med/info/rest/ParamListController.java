package com.med.info.rest;

import com.med.info.response.Response;
import com.med.info.service.ParamInfoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Title: 列表参数配置管理
 * Description: 列表参数配置管理、如需在一个任务中关联其他表的参数，可以通过这个借口来查询。
 *
 * @author DELETE
 *
 */
@RestController
@RequestMapping("/paramFind")
public class ParamListController {
    private static final Logger log = Logger.getLogger(ParamListController.class);

    @Autowired
    ParamInfoService paramInfoService;

    /**
     * 查询疾病id与名称
     * @param
     * @return 疾病基础信息的id和名称列表
     */
    @RequestMapping(value="/findDisease",method = RequestMethod.GET)
    public Response queryDiseaseInfoName() {
        try{
            return new Response().success(paramInfoService.queryDiseaseInfoName());
        }catch (Exception e){
            return new Response().failure();
        }
    }

    /**
     * 查询疾病相关科室部门信息
     * @param
     * @return 疾病相关科室部门信息
     */
    @RequestMapping(value="/findDepartment",method = RequestMethod.GET)
    public Response queryDepartmentInfo() {
        try{
            return new Response().success(paramInfoService.queryDepartmentInfo());
        }catch (Exception e){
            return new Response().failure();
        }
    }

    /**
     * 查询疾病相关症状信息
     * @param
     * @return 疾病相关症状信息
     */
    @RequestMapping(value="/findSymptom",method = RequestMethod.GET)
    public Response querySymptomInfo() {
        try{
            return new Response().success(paramInfoService.querySymptomInfo());
        }catch (Exception e){
            return new Response().failure();
        }
    }

    /**
     * 查询医疗机构id与名称
     * @param
     * @return 医疗机构信息的id和名称列表
     */
    @RequestMapping(value="/findInstitution",method = RequestMethod.GET)
    public Response queryInstitutionInfoName() {
        try{
            return new Response().success(paramInfoService.queryInstitutionInfoName());
        }catch (Exception e){
            return new Response().failure();
        }
    }
}
