package com.finaldemo.controller.timmy;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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
	public String insertNewPet(@RequestParam("petName") String petName,
			@RequestParam(name = "petBirthday", defaultValue = "2010-01-01") Date petBirthday,
			@RequestParam("petDescription") String petDescription, @RequestParam(name = "file") MultipartFile file,
			@RequestParam("petType") Integer petType, @RequestParam("petGender") Integer petGender, HttpSession session,
			Model model) {
		Users user = (Users) session.getAttribute("user");
		String type = file.getContentType().replaceAll("image/", "");
		Set<Pets> petSet = user.getPets();
		Pets pet = new Pets(petName, petType, petBirthday, petGender, petDescription, user);
		if (!type.contains("application")) {
			pet.setPetPhotoPath("/img/petimg/" + user.getUserId() + "-" + (petSet.size() + 1) + "." + type);
		}
		petSet.add(pet);
		service.insertNewUser(user);
		try {
			if (!type.contains("application")) {
				FileUtils.writeByteArrayToFile(
						new File(System.getProperty("user.dir") + "\\src\\main\\webapp\\img\\petimg\\" + user.getUserId() + "-" + petSet.size() + "." + type),
						file.getBytes());
				System.out.println("insert file ok");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:/timmy/accountsetting.controller";
	}

}
