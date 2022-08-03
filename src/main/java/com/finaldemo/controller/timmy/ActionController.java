package com.finaldemo.controller.timmy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ActionController {
	
	@GetMapping("accountsetting.controller")
	public String testgivingSession() {
		return "timmy/normalmember";
	}
}
