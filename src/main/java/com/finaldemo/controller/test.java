package com.finaldemo.controller;

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
public class test {
	@Autowired
	private UsersRepository uDao;
	
	@Autowired
	private PetsRepository pDao;
	
	@GetMapping("/test")
	public String action() {
//		Users u1 = new Users();  //新增
//		u1.setNickName("tony");//新增
//		
//		Pets p1 = new Pets();//新增
//		p1.setPetName("wifi");//新增
//		
		return "test";
	}
	
	
}
