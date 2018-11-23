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


    @RequestMapping(value="/findDisease",method = RequestMethod.GET)
    public Response queryDiseaseInfoName() {
        paramInfoService.queryDiseaseInfoName();
        return null;
    }

    @RequestMapping(value="/findDepartment",method = RequestMethod.GET)
    public Response queryDepartmentInfo() {
        paramInfoService.queryDepartmentInfo();
        return null;
    }

    @RequestMapping(value="/findSymptom",method = RequestMethod.GET)
    public Response querySymptomInfo() {
        paramInfoService.querySymptomInfo();
        return null;
    }
    @RequestMapping(value="/findInstitution",method = RequestMethod.GET)
    public Response queryInstitutionInfoName() {
        paramInfoService.queryInstitutionInfoName();
        return null;
    }
}
