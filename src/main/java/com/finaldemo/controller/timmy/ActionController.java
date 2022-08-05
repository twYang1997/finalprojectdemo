package com.finaldemo.controller.timmy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Calendar;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import com.finaldemo.dto.ImageDto;
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
		Users u1 = service.getUserById(2);
		u1.setNickName("jenny");
		u1.setAddress("台南市永康區大橋兩百街100號");
		u1.setBirthday(c.getTime());
		u1.setCategory(1);
		u1.setEmail("timmy860930@gmail.com");
		u1.setGender(1);
		u1.setPhone("0970322377");
		u1.setSelfIntroduction("安安你好");
		u1.setPhotoPath("/img/userimg/none.png");
		return service.insertNewUser(u1);
	}

	@GetMapping("accountsetting.controller")
	public String testgivingSession(HttpSession session) {
		Users u1 = service.getUserById(2);
		session.setAttribute("user", u1);
		if (u1.getCategory() == 1)
			return "timmy/NormalMember";
		else if (u1.getCategory() == 2)
			return "timmy/CharityMember";
		else
			return null;
	}

	@PostMapping("uploadImg.controller")
	public String uploadImg(@RequestParam Integer photoId, @RequestParam MultipartFile newPhoto) {
		try {
			newPhoto.transferTo(new File("C:\\_SpringBoot\\workspace\\finaldemo\\src\\main\\webapp\\img\\userimg\\"
					+ photoId.toString() + ".jpg"));
			Users user1 = service.getUserById(photoId);
			user1.setPhotoPath("/img/userimg/" + photoId.toString() + ".jpg");
			service.insertNewUser(user1);
		} catch (Exception e) {
		}
		return "redirect:accountsetting.controller";
	}

	@PostMapping("user/uploadImgAjax")
	@ResponseBody
	public String uploadImagAjax(@RequestBody ImageDto dto, @RequestParam(name = "id") Integer id) {
		String extension = dto.getImg64().replaceAll("data:" + dto.getType().trim() + ";base64,", "");
		String type = dto.getType().replaceAll("image/", "");
		byte[] content = Base64.decodeBase64(extension);
		try {
			FileUtils.writeByteArrayToFile(
					new File("C:\\_SpringBoot\\workspace\\finaldemo\\src\\main\\webapp\\img\\userimg\\",
							id.toString() + "." + type),
					content);
			Users user = service.getUserById(id);
			user.setPhotoPath("/img/userimg/" + id.toString() + "." + type);
			service.insertNewUser(user);
			return "success";
		} catch (IOException e) {
			e.printStackTrace();
			return "failed";
		}
	}
}
