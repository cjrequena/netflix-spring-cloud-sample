package com.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MicroServiceOneController {
	
	@Value("${server.port}")
	String serverPort;
	
	@Autowired
	DiscoveryClient discoveryClient;
	
	@RequestMapping("/")
	@ResponseBody
	String home() {
		ServiceInstance localInstance = discoveryClient.getLocalServiceInstance();
		return "Hello World "+ localInstance.getServiceId()+":"+localInstance.getHost()+":"+localInstance.getPort();
	}
}