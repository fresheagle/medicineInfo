package com.med.info.rest;

import com.med.info.dto.*;
import com.med.info.mapper.domain.OperateDTO;
import com.med.info.response.Response;
import com.med.info.service.MissionService;
import com.med.info.service.impl.DefaultTokenManager;
import com.med.info.utils.TrialStatusEnum;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * 操作业务流程数据
 *
 * @author jiangjialin
 */
@RestController
@RequestMapping("/api/mission")
public class MissionController {

    @Autowired
    private MissionService missionService;
    private static Logger logger = org.slf4j.LoggerFactory.getLogger(MissionController.class);

    @RequestMapping(value = "/saveMission", method = RequestMethod.POST)
    @ResponseBody
    public Response save(@RequestBody OperateDTO operateDTO) {
        try {
            Object saveMission = missionService.saveMission(operateDTO);
            if (null == saveMission) {
                throw new Exception("对应操作类型未定义！");
            }
            return new Response().success(saveMission);
        } catch (Exception e) {
            logger.error("保存任务状态失败；", e);
            return new Response().failure(e.getMessage());
        }
    }

    @RequestMapping(value = "deleteMission", method = RequestMethod.DELETE)
    @ResponseBody
    public Response delete(@RequestBody List<String> taskIds) {
        try {
            if (!DefaultTokenManager.getLocalUserCode().getRoleCodes().contains("000")) {
                throw new Exception("当前用户无删除操作权限");
            }
            missionService.deleteMission(taskIds);
            return new Response().success("删除数据成功");
        } catch (Exception e) {
            logger.error("删除任务状态失败；", e);
            return new Response().failure(e.getMessage());
        }
    }

    @RequestMapping(value = "batch/saveMission", method = RequestMethod.PUT)
    public Response batchSave(@RequestBody BatchOperateDTO batchOperateDTO) {
        try {
            missionService.BatchSaveMission(batchOperateDTO);
            return new Response().success("操作成功");
        } catch (Exception e) {
            logger.error("批量保存任务状态失败；", e);
            return new Response().failure(e.getMessage());
        }
    }

    @RequestMapping(value = "/claimTask", method = RequestMethod.POST)
    @ResponseBody
    public Response claimTask(@RequestBody ClaimTaskDTO claimTask) {
        try {
            missionService.claimTask(claimTask);
            return new Response().success("操作成功");
        } catch (Exception e) {
            logger.error("认定任务状态失败；", e);
            return new Response().failure(e.getMessage());
        }
    }

    @RequestMapping(value = "/data/page", method = RequestMethod.POST)
    public Response getByPage(@RequestBody SelectTaskDTO selectTaskDTO) {

        Object byPage = null;
        try {
            byPage = missionService.getByPage(selectTaskDTO, true);
            return new Response().success(byPage);
        } catch (Exception e) {
            logger.error("查询任务失败；", e);
            return new Response().failure(e.getMessage());
        }
    }


    @RequestMapping(value = "/data/page/export", method = RequestMethod.POST)
    @ResponseBody
    public Response exportDatas(@RequestBody SelectTaskDTO selectTaskDTO, HttpServletRequest request, HttpServletResponse response) {

        try {
            XSSFWorkbook xssfWorkbook = missionService.exportDatas(selectTaskDTO, true);
            setResponseHeader(response,"export_file.xlsx");
            OutputStream os = response.getOutputStream();
            xssfWorkbook.write(os);
            os.flush();
            os.close();
            return new Response().success("导出成功");
        } catch (Exception e) {
            logger.error("查询任务失败；", e);
            return new Response().failure(e.getMessage());
        }
    }

    //发送响应流方法
    public void setResponseHeader(HttpServletResponse response, String fileName) throws UnsupportedEncodingException {

        fileName = new String(fileName.getBytes(), "utf-8");
        response.setContentType("application/octet-stream;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        response.addHeader("Pargam", "no-cache");
        response.addHeader("Cache-Control", "no-cache");

//        response.setHeader("Expires", "0");
//        response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
//        response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
//        response.setHeader("Pragma", "public");
//        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    }


    @RequestMapping(value = "/data/pool/page", method = RequestMethod.POST)
    public Response getByPoolPage(@RequestBody SelectTaskDTO selectTaskDTO) {
        if (selectTaskDTO.getPoolId() == 1) {
            List<String> status = new ArrayList<>();
            status.add(TrialStatusEnum.TO_FIRST_AUDITED.getId());
            selectTaskDTO.setTaskStatus(status);
        }
        if (selectTaskDTO.getPoolId() == 2) {
            List<String> status = new ArrayList<>();
            status.add(TrialStatusEnum.TO_SECOND_AUDITED.getId());
            selectTaskDTO.setTaskStatus(status);
        }
        if (selectTaskDTO.getPoolId() == 3) {
            List<String> status = new ArrayList<>();
            status.add(TrialStatusEnum.TO_FINAL_AUDITED.getId());
            selectTaskDTO.setTaskStatus(status);
        }
        Object byPage = null;
        try {
            byPage = missionService.getByPage(selectTaskDTO, false);
        } catch (Exception e) {
            logger.error("查询任务失败；", e);
            return new Response().failure(e.getMessage());
        }
        return new Response().success(byPage);
    }


    @RequestMapping(value = "/missionDetails/page", method = RequestMethod.GET)
    public Response getMissionDetailList(@RequestParam("currentPage") Integer currentPage,
                                         @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                         @RequestParam("taskId") String taskId) {
        Object missionDetailPage = missionService.getMissionDetailPage(currentPage, pageSize, taskId);
        return new Response().success(missionDetailPage);
    }

    @RequestMapping(value = "batch/approve", method = RequestMethod.PUT)
    public Response batchApproveTask(@RequestBody BatchApproveTaskDTO approveTaskDTO) {
        return null;
    }

    @RequestMapping(value = "batch/acounts", method = RequestMethod.PUT)
    public Response batchAcountsTask(@RequestBody BatchAcountsDTO accounts) {
        try {
            missionService.BatchAcounts(accounts);
            return new Response().success("操作成功");
        } catch (Exception e) {
            logger.error("批量结算任务状态失败；", e);
            return new Response().failure(e.getMessage());
        }
    }

    @RequestMapping(value = "batch/reset", method = RequestMethod.PUT)
    public Response batchReset(@RequestBody BatchResetTaskDTO batchResetTaskDTO) {
        try {
            missionService.resetTask(batchResetTaskDTO);
            return new Response().success("操作成功");
        } catch (Exception e) {
            logger.error("重置状态失败；", e);
            return new Response().failure(e.getMessage());
        }
    }

    @RequestMapping(value = "batch/new/createuser", method = RequestMethod.PUT)
    public Response batchNewuser(@RequestBody BatchResetTaskDTO batchResetTaskDTO) {
        try {
            missionService.resetCreateUser(batchResetTaskDTO);
            return new Response().success("操作成功");
        } catch (Exception e) {
            logger.error("指派新作者失败；", e);
            return new Response().failure(e.getMessage());
        }
    }

}
