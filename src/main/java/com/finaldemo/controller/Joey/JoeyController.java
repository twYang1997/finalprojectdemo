package com.finaldemo.controller.Joey;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
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
import org.springframework.web.multipart.MultipartFile;

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
		model.addAttribute("userId", id);
		


		return "joey/editMember";

	}

	@PostMapping("/editMember")
	public String editAnUser(@ModelAttribute Users user, Model model) {
		service.editUser(user);
		
		return "joey/joeytest";
	}
	
	@PostMapping("/fileuploadjoey")
	public String uploadNewPhoto(@RequestParam("userId") String userId,
			@RequestParam("file") MultipartFile file) {
		
		String contentType = file.getContentType();
		String photoType = "."+contentType.substring(6);
		System.out.println(photoType);
		Users oneMember = service.findById(Integer.parseInt(userId));
		oneMember.setUserId(Integer.parseInt(userId));
		oneMember.setPhotoPath("/img/joeyimg/"+userId+photoType);
		service.editUser(oneMember);
		System.out.println(photoType);
		
		try {
			byte[] bytes = file.getBytes();
			FileUtils.writeByteArrayToFile(
					new File(System.getProperty("user.dir") + "\\src\\main\\webapp\\img\\joeyimg\\",
							userId+ photoType),
					bytes);

			return "joey/joeytest";
		} catch (IOException e) {
			e.printStackTrace();
			return "joey/joeytest";
		}
	}


	@PostMapping("/deleteMember")
	public String deleteUser(@RequestParam Integer id) {
		service.deleteUser(id);

		return "/joey/editMember";
	}

}
