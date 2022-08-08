package com.finaldemo.controller.zzz;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//@Controller
public class PageController {
	
	@GetMapping("/")
	public String welcomeIndex() {
		return "index";
	}
	
	@GetMapping("/about")
	public String aboutPage() {
		return "about";
	}
	
	@GetMapping("/message/ajax")
	public String ajaxVersionPage() {
		return "ajaxMessage";
	}
	
	@GetMapping("/upfoundation")               //基金會上傳  跳轉頁面用
	public String upfoundation() {      
		return "upload/upfoundation";
	}
	@GetMapping("/listphoto")
	public String listphoto() {
		
		return "upload/listphoto";
	}
	

}
