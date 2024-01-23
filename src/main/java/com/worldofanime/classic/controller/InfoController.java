package com.worldofanime.classic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.worldofanime.classic.model.api.InfoRequest;
import org.springframework.web.client.RestTemplate;

@Controller
public class InfoController {

	@Value("${local.api.path}")
  	private String localApiPath;

	@GetMapping("/terms")
	public String terms(Model model) {

		RestTemplate restTemplate = new RestTemplate();
        InfoRequest infoRequest = restTemplate.getForObject(localApiPath + "/api/terms", InfoRequest.class);

        model.addAttribute("terms", infoRequest.getBody());

		return "terms";
	}
}