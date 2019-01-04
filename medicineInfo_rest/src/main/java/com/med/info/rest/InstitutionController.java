package com.med.info.rest;

import com.med.info.mapper.domain.InstitutionInfoDTO;
import com.med.info.response.Response;
import com.med.info.service.InstitutionInfoService;
import com.med.info.service.MissInstitutionService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Title: 医疗机构的参数管理
 * Description: 医疗机构数据的增删改查
 *
 * @author DELETE
 */
@RestController
@RequestMapping("/api/institution")
public class InstitutionController {
    private static final Logger log = Logger.getLogger(InstitutionController.class);
    @Autowired
    InstitutionInfoService institutionInfoService;
    @Autowired
    MissInstitutionService missInstitutionService;

    @RequestMapping(path = "/page", method = RequestMethod.GET)
    public Response getByPage(@RequestParam("currentPage") Integer currentPage,
                              @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                              @RequestParam(value = "name", required = false) String name,
                              @RequestParam(value = "level", required = false) String level,
                              @RequestParam(value = "address", required = false) String address,
                              @RequestParam(value = "category", required = false) String category) {
        try {
            Object byPage = missInstitutionService.getByPage(currentPage, pageSize, name, level, address, category);
            return new Response().success(byPage);
        } catch (Exception e) {
            log.error("查询数据错误", e);
            return new Response().failure(e.getMessage());
        }
    }

    @RequestMapping(value = "check", method = RequestMethod.GET)
    public Response checkInstitutionInfo(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "website", required = false) String website) {
        if (null == name && null == website) {
            return new Response().failure("校验条件至少传递一个");
        }
        try {
            String taskId = missInstitutionService.checkInstitutionInfo(name , website);
            return new Response().success(taskId);
        } catch (Exception e) {
            return new Response().failure(e.getMessage());
        }
    }

    /**
     * 添加医疗机构信息
     *
     * @param institutionInfoDTO 医疗机构信息
     * @return 医疗机构id
     */
    @RequestMapping(method = RequestMethod.POST)
    public Response addInstitutionInfo(@RequestBody InstitutionInfoDTO institutionInfoDTO) {
        try {
            return new Response().success(institutionInfoService.addInstitutionInfo(institutionInfoDTO));
        } catch (Exception e) {
            return new Response().failure();
        }
    }

    /**
     * 修改医疗机构信息
     *
     * @param institutionInfoDTO 医疗机构信息
     * @return 医疗机构id
     */
    @RequestMapping(method = RequestMethod.PUT)
    public Response updateInstitutionInfo(@RequestBody InstitutionInfoDTO institutionInfoDTO) {
        try {
            return new Response().success(institutionInfoService.updateInstitutionInfo(institutionInfoDTO));
        } catch (Exception e) {
            return new Response().failure();
        }
    }

    /**
     * 查询医疗机构信息
     *
     * @param institutionId 医疗机构id
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public Response queryInstitutionInfo(@RequestBody Integer institutionId) {
        try {
            return new Response().success(institutionInfoService.queryInstitutionInfo(institutionId));
        } catch (Exception e) {
            return new Response().failure();
        }
    }

    /**
     * 删除医疗机构信息
     *
     * @param institutionId 医疗机构id
     * @return
     */
    @RequestMapping(method = RequestMethod.DELETE)
    public Response deleteInstitutionInfo(@RequestBody Integer institutionId) {
        try {
            return new Response().success(institutionInfoService.deleteInstitutionInfo(institutionId));
        } catch (Exception e) {
            return new Response().failure();
        }
    }
}
