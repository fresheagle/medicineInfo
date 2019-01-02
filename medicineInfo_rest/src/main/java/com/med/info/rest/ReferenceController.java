package com.med.info.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.med.info.response.Response;

@RestController
@RequestMapping("/api/reference")
public class ReferenceController {

	@RequestMapping(method = RequestMethod.POST)
	public Response addReference() {
		
		return new Response().success();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public Response showReference(String taskId){
		return new Response().success();
	}
}
