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
//		Users u1 = uDao.findById(1).get();
		Users u1 = new Users();
		u1.setNickName("tony");
		
		Pets p1 = new Pets();
		p1.setPetName("wifi");
		
		u1.getPets().add(p1);
		p1.setUserId(u1);
		uDao.save(u1);
		System.out.println(u1.getNickName());
		return "test";
	}
}
