package com.finaldemo.controller.timmy;

import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.finaldemo.model.Event;
import com.finaldemo.model.Users;
import com.finaldemo.service.TimmyService;

@Controller
public class EventController {
	
	@Autowired
	private TimmyService service;
	
	@GetMapping("/eventPage")
	public String returnEventPate(Model m, HttpSession session) {
		Users userBefore = (Users) session.getAttribute("user");
		Users userAfter = service.getUserById(userBefore.getUserId());
		session.setAttribute("user", userAfter);
		m.addAttribute("newEvent", new Event());
		return "timmy/eventPage";
	}
	
	@PostMapping("/event/insertNewEvent.controller")
	public String addEvent(@ModelAttribute("newEvent") Event event, HttpSession session) {
		Users u1 = (Users) session.getAttribute("user");
		Set<Event> eventList = u1.getMyHostEvents();
		event.setEventHost(u1);
		eventList.add(event);
		service.insertNewUser(u1);
		return "redirect:/eventPage";
	}
	
}
