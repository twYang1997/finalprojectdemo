package com.finaldemo.controller.zzz;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.finaldemo.model.Users;
import com.finaldemo.service.zzzService;


@Controller
public class managerController  {
	
	@Autowired
	private zzzService gService;
	
	@PostMapping("/fileupload")
	public String uploadNewPhoto(@RequestParam("nickName") String photoName, 
		    @RequestParam("file") MultipartFile file ) {
		
		String nameAfterTrim = photoName.trim();
		
		try {
			Users newPhoto = new Users();
			newPhoto.setNickName(nameAfterTrim);
			newPhoto.setPhotoFile(file.getBytes());
			
			gService.insertPhoto(newPhoto);
			
			return "zzzupload/zzzuploadSuccessPage";
	} catch (IOException e) {
			e.printStackTrace();
			return "index";
	}
	}

	

}
