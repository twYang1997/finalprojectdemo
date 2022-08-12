package com.finaldemo.controller.phoebe;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.finaldemo.model.Users;
import com.finaldemo.service.PhoebeService;

@Controller
public class PageController_P {

	@Autowired
	private PhoebeService service;
	
	@GetMapping("/phoebe/")
	public String welcomeIndex(HttpSession session) {
		return "phoebe/index";
	}

	@GetMapping("/phoebe/login")
	public String login() {
		return "phoebe/login";
	}

	@GetMapping("/phoebe/signUp")
	public String editMessage(Model model) {
		model.addAttribute("users", new Users()); // signUp.jsp的ModelAttribute需要
		return "phoebe/signUp";
	}
	
	@GetMapping("/phoebe/search")
	public String search(@RequestParam String search, Model model) {
		List<Users> peopleList = service.searchPeople(search);
		model.addAttribute("peopleList", peopleList);
		return "phoebe/searchResult";
	}
}
