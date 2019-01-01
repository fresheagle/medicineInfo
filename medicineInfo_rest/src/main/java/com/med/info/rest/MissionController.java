package com.med.info.rest;

import com.med.info.dto.BatchApproveTaskDTO;
import com.med.info.dto.ClaimTaskDTO;
import com.med.info.dto.SelectTaskDTO;
import com.med.info.mapper.domain.OperateDTO;
import com.med.info.response.Response;
import com.med.info.service.MissionService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
            return new Response().success(saveMission);
        } catch (Exception e) {
            logger.error("保存任务状态失败；", e);
            return new Response().failure(e.getMessage());
        }
    }

    @RequestMapping(value = "/claimTask", method = RequestMethod.POST)
    @ResponseBody
    public Response claimTask(ClaimTaskDTO claimTask) {
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

        Object byPage = missionService.getByPage(selectTaskDTO);
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
}
