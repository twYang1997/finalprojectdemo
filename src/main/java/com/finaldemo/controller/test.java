package com.finaldemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.finaldemo.model.PetsRepository;
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
//		Users u1 = new Users();
//		u1.setNickName("tony");
		
//		Pets p1 = new Pets();
//		p1.setPetName("bluetooth");
//		
//		Pets p2 = new Pets();
//		p2.setPetName("wifi");
//		
//		Set<Pets> pets = u1.getPets();
//		pets.add(p1);
//		pets.add(p2);
//		p1.setUserId(u1);
//		p2.setUserId(u1);
//		pDao.delete(pDao.findById(2).get());
//		uDao.deleteById(1);
//		uDao.save(u1);
//		System.out.println(u1.getNickName());
		return "test";
	}
}
