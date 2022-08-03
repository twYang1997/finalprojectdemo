package com.finaldemo.controller.timmy;

import java.util.Calendar;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.finaldemo.model.Users;
import com.finaldemo.service.TimmyService;

@Controller
public class ActionController {

	@Autowired
	private TimmyService service;

	@PostMapping("NewUserPage")
	@ResponseBody
	public Users newUserTest() {
		Calendar c = Calendar.getInstance();
		c.set(1997, 10, 14);
		Users u1 = new Users();
		u1.setNickName("jenny");
		u1.setAddress("台南市永康區大橋兩百街100號");
		u1.setBirthday(c.getTime());
		u1.setCategory(1);
		u1.setEmail("timmy860930@gmail.com");
		u1.setGender(1);
		u1.setPhone("0970322377");
		return service.insertNewUser(u1);
	}

	@PostMapping("updateUserPage")
	@ResponseBody
	public Users updateUserTest() {
		Calendar c = Calendar.getInstance();
		c.set(1997, 10, 14);
		Users u1 = service.getUserById(1);
		u1.setNickName("jenny");
		u1.setAddress("台南市永康區大橋兩百街100號");
		u1.setBirthday(c.getTime());
		u1.setCategory(1);
		u1.setEmail("timmy860930@gmail.com");
		u1.setGender(1);
		u1.setPhone("0970322377");
		u1.setSelfIntroduction("安安你好");
		return service.insertNewUser(u1);
	}

	@GetMapping("accountsetting.controller")
	public String testgivingSession(HttpSession session) {
		Users u1 = service.getUserById(1);
		session.setAttribute("user", u1);
		if (u1.getCategory() == 1)
			return "timmy/NormalMember";
		else if (u1.getCategory() == 2)
			return "timmy/CharityMember";
		else 
			return null;
	}
}
