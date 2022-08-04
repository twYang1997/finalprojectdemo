package com.finaldemo.controller.Brian;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.finaldemo.model.Users;
import com.finaldemo.service.BrainService;

@Controller
public class UsersListController {
	@Autowired
	private BrainService Service; // 連接Service 調用insertMessage
	
	@GetMapping("/memberManagement")
	public String memberManagement(@RequestParam(name = "p", defaultValue = "1")Integer pageNumber, Model model ){
		Page<Users> page = Service.findByPage(pageNumber);

		model.addAttribute("page", page);
		return "Brian/memberManagement";
	}

}
