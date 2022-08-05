package com.finaldemo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.finaldemo.model.Users;
import com.finaldemo.service.jampService;



public class managerController  {
	
	@Autowired
	private jampService gService;
	
	@PostMapping("/fileupload")
	public String uploadNewPhoto(@RequestParam("photoName") String photoName, 
			                     @RequestParam("file") MultipartFile file ) {
		
		String nameAfterTrim = photoName.trim();
		
		try {
			Users newPhoto = new Users();
			newPhoto.setNickName(nameAfterTrim);
			newPhoto.setPhotoPath(file.getBytes());
			
			gService.insertPhoto(newPhoto);
			
			return "goodphoto/uploadSuccessPage";
		} catch (IOException e) {
			e.printStackTrace();
			return "index";
		}
	}

	

}
