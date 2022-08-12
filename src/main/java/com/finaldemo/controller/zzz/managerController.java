package com.finaldemo.controller.zzz;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.finaldemo.model.Donate;
import com.finaldemo.model.Users;
import com.finaldemo.service.zzzService;


@Controller
public class managerController  {
	
	@Autowired
	private zzzService gService;
	
	@PostMapping("/cartupload")
	public String uploadCart(@RequestParam("name") String cartname,
			@RequestParam("email") String cartgmail,@RequestParam("payment") Integer cartpayment)
		      {
		String nameAfterTrim = cartname.trim();
		
		Donate newCart = new Donate();
		newCart.setDonorName(nameAfterTrim);
		newCart.setDonorEmail(cartgmail);
		newCart.setPayment(cartpayment);
		newCart.setDonateDate(new Date());

		
		
		gService.insertcart(newCart);
		
		return "zzzupload/cart";
	}

	
	
	@GetMapping("/zzzfindById")    //圖片
	public String zzzfindAnUserById(@RequestParam(name = "id") Integer id, Model zzzmodel) {
		 
		
		Users oneMember = gService.zzzfindById(1);
		
		zzzmodel.addAttribute("oneMember", oneMember);
		zzzmodel.addAttribute("userId", 1);
		


		return "zzzupload/fundraiser";

	}
	
	
	
	

	
	
}
