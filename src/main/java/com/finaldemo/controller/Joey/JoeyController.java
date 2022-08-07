package com.finaldemo.controller.Joey;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.finaldemo.model.Users;
import com.finaldemo.service.JoeyService;

@Controller
public class JoeyController {

	@Autowired
	private JoeyService service;

	@InitBinder
	public void InitBinder(WebDataBinder binder) {
	    //前端传入的时间格式必须是"yyyy-MM-dd"效果!
	    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	    CustomDateEditor dateEditor = new CustomDateEditor(df, true);
	    binder.registerCustomEditor(Date.class, dateEditor);
	}
	
	@GetMapping("/findById")
	public String findAnUserById(@RequestParam(name = "id") Integer id, Model model) {
		Users oneMember = service.findById(id);
		model.addAttribute("oneMember", oneMember);

		return "/joey/editMember";

	}

	@PostMapping("/editMember")
	public String editAnUser(@ModelAttribute Users user, Model model) {
		service.editUser(user);
		
		return "/test";
	}

	@PostMapping("/deleteMember")
	public String deleteUser(@RequestParam Integer id) {
		service.deleteUser(id);

		return "/joey/editMember";
	}

}
