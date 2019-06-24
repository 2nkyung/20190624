package com.spring.exam.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class URIController {

	@GetMapping("/views/**")
	public String goPage(HttpServletRequest req) {
		String uri = req.getRequestURI();
		uri = uri.replace("/views/", "");
		log.info("uri : {}", req.getRequestURI());
		return uri;
	}
}
