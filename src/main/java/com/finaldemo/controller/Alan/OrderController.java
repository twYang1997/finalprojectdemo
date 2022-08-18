package com.finaldemo.controller.Alan;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.finaldemo.model.Foundation;
import com.finaldemo.model.Products;
import com.finaldemo.model.ShoppingCar;
import com.finaldemo.model.Users;
import com.finaldemo.service.AlanService;

@Controller
public class OrderController {

	@Autowired
	private AlanService alanService;
	
	@Autowired
	private HttpSession session;

}
