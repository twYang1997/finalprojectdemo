package com.finaldemo.controller.Alan;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.finaldemo.model.Users;
import com.finaldemo.service.AlanService;


@Controller
public class FoundationProductController  {
	
	@Autowired
	private AlanService alanService;
	
	/*** 
	 * 
	 * 
	 * 
	 */
	@RequestMapping(path="/Alan/foundationProduct")
	public String findFoundationProduct(@RequestParam String userId,Model model) {
		List<Users> users =  alanService.findProductById(userId);
		model.addAttribute("users", users);
		return "Alan/foundationProduct";
	}
	
	
}
