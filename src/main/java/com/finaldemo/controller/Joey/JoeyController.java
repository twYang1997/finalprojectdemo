package com.finaldemo.controller.Joey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.finaldemo.model.Users;
import com.finaldemo.service.JoeyService;

@Controller
public class JoeyController {
	
	@Autowired
	private JoeyService service;
	
	@PostMapping("/findById")
	public String findAnUserById(@RequestParam Integer id , Model model) {
		Users oneMember = JoeyService.findById(id);
		
		model.addAttribute("oneMember", oneMember);
		
		return "Joey/editMember";
		
	}
	
	@PostMapping("/editMember")
	public String editAnUser(@ModelAttribute Users user) {
		
		JoeyService.editUser(user);
		
		return "redirect:/Joey/showMember";
	}
	
	@PostMapping
	public String deleteUser(@RequestParam Integer id) {
		JoeyService.deleteUser(id);
		
		return "redirect:/Joey/showMember";
	}

}
