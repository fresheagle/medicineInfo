package com.med.info.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.med.info.domain.Miss_control_action;
import com.med.info.response.Response;
import com.med.info.service.MissControlActionService;

@RestController
@RequestMapping("/action")
public class ActionController {

	@Autowired
	private MissControlActionService controlActionService;
	
	private static Logger logger = LoggerFactory.getLogger(ActionController.class);
	
	@RequestMapping(method = RequestMethod.POST)
	public Response addAction(@RequestBody Miss_control_action controlAction) {
		
		try {
			int insert = controlActionService.insert(controlAction);
			if(insert < 0) {
				return new Response().failure("插入错误，请重试");
			}else {
				return new Response().success();
			}
		} catch (Exception e) {
			logger.error("插入数据错误；",e);
			return new Response().failure("插入错误，请重试");
		}
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Response updateAction(@RequestBody Miss_control_action controlAction) {
		
		try {
			int insert = controlActionService.updateByPrimaryKey(controlAction);
			if(insert < 0) {
				return new Response().failure("插入错误，请重试");
			}else {
				return new Response().success();
			}
		} catch (Exception e) {
			logger.error("插入数据错误；",e);
			return new Response().failure("插入错误，请重试");
		}
	}
	
	@RequestMapping(value="/all" ,method = RequestMethod.GET)
	public Response getAllAction(String uuid) {
		
		return null;
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public Response deleteAction(String[] uuids) {
		try {
			controlActionService.deleteByActions(uuids);
			return new Response().success();
		} catch (Exception e) {
			logger.error("删除数据错误；",e);
			return new Response().failure("删除错误，请重试");
		}
		
	}
}
