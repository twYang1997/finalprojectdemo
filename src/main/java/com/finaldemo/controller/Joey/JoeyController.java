package com.finaldemo.controller.Joey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.finaldemo.model.Users;
import com.finaldemo.service.JoeyService;

@Controller
public class JoeyController {

	@Autowired
	private JoeyService service;

	@GetMapping("/findById")
	public String findAnUserById(@RequestParam(name = "id") Integer id, Model model) {

		Users oneMember = JoeyService.findById(id);
		model.addAttribute("oneMember", oneMember);
		System.out.println("Controller ID:" + id);
		System.out.println("Controller oneMember:" + oneMember);

		return "/joey/editMember";

	}

	@PostMapping("/editMember")
	public String editAnUser(@ModelAttribute Users user) {

		service.editUser(user);

		return "redirect:/joey/editMember";
	}

	@PostMapping("/deleteMember")
	public String deleteUser(@RequestParam Integer id) {
		service.deleteUser(id);

		return "redirect:/joey/showMember";
	}

}
