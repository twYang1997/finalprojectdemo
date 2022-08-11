package com.finaldemo.controller.zzz;

import java.io.IOException;
import java.util.Date;

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
//	@PostMapping("/cartupload")
//	public String postMessage(@ModelAttribute Donate msg,Model model) {
//		System.out.println(msg);
//		gService.insertcart(msg);
//		
//		Donate newMsg = new Donate();
//		Donate latestMsg = gService.lastestMessage();
//		
//		model.addAttribute("workMessages", newMsg);
//		model.addAttribute("latestMsg", latestMsg);
//		
//		return "zzzupload/cart";
//	}

//	@GetMapping("/downloadImage/{id}")
//	public ResponseEntity<byte[]> downloadImage(@PathVariable Integer id){
//		Users photo1 = gService.getPhotoById(id);
//		圖片
//		String photoFile = photo1.getPhotoPath();
//		
//		HttpHeaders header = new HttpHeaders();
//		header.setContentType(MediaType.IMAGE_JPEG);
//		
//		                          // 要回傳的物件本體, header, HttpStatus 回應
//		return new ResponseEntity<byte[]>(photoFile,header,HttpStatus.OK);
//	}
	
	
	
	
}
