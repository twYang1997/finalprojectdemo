package com.finaldemo.controller.timmy;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.finaldemo.model.Pets;
import com.finaldemo.model.Users;
import com.finaldemo.service.TimmyService;

@Controller
public class PetSettingController {

	@Autowired
	private TimmyService service;

	@InitBinder
	public void InitBinder(WebDataBinder binder) {
		// 前端传入的时间格式必须是"yyyy-MM-dd"效果!
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		CustomDateEditor dateEditor = new CustomDateEditor(df, true);
		binder.registerCustomEditor(Date.class, dateEditor);
	}

	@PostMapping("/pet/insertNewPet.controller")
	public String insertNewPet(@RequestParam("petName") String petName, @RequestParam("petBirthday") Date petBirthday,
			@RequestParam("petDescription") String petDescription, @RequestParam("file") MultipartFile file,
			@RequestParam("petType") Integer petType, @RequestParam("petGender") Integer petGender, HttpSession session,
			Model model) {
		Users user = (Users) session.getAttribute("user");
		Set<Pets> petSet = user.getPets();
		Pets pet = new Pets(petName, petType, petBirthday, petGender, petDescription, user);
		petSet.add(pet);
		service.insertNewUser(user);
		return "redirect:/timmy/accountsetting.controller";
	}

}
