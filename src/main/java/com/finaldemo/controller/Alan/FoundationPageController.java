package com.finaldemo.controller.Alan;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.finaldemo.model.Users;
import com.finaldemo.service.AlanService;


@Controller
public class FoundationPageController  {
	
	@Autowired
	private AlanService alanService;
	
	/*** 
	 * 
	 * 
	 * 
	 */
	@GetMapping("/Alan/foundation")
	public String findFoundation(Model model) {
		List<Users> userList= alanService.findAll();
		model.addAttribute("userList", userList);
		return "Alan/foundation";
	}
	
	@GetMapping("/Alan/order")               //跳轉用  後面要改掉  購物車頁面施工中
	public String order() {
		return "Alan/foundationProduct";
	}
	
}
