package com.finaldemo.controller.zzz;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.finaldemo.model.Pets;
import com.finaldemo.model.PetsRepository;
import com.finaldemo.model.Users;
import com.finaldemo.model.UsersRepository;

@Controller
public class zzzPageController {
	
	@Autowired
	private UsersRepository uDao;
	
	@Autowired
	private PetsRepository pDao;
	
	@GetMapping("/zzzupload/fundraiser")
	public String action() {
		return "/zzzupload/fundraiser";
	}
	
	@GetMapping("/zzzupload/zzzabout")
	public String aboutPage() {
		return "zzzupload/zzzabout";
	}
	
	@GetMapping("/zzzupload/foundation")
	public String foundationPage() {
		return "zzzupload/foundation";
	}
	
	@GetMapping("/zzzupload/order")
	public String welcomeIndex() {
		return "zzzupload/order";
	}
//	
	
//	
	
//	
//	@GetMapping("/upfoundation")               //基金會上傳  跳轉頁面用
//	public String upfoundation() {      
//		return "upload/upfoundation";
//	}
//	@GetMapping("/listphoto")
//	public String listphoto() {
//		
//		return "upload/listphoto";
//	}
	

}
