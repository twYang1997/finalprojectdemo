package com.finaldemo.controller.phoebe;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.finaldemo.model.Users;

@Controller
public class PhoebeController {

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
}
