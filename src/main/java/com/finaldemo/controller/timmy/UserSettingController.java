package com.finaldemo.controller.timmy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.finaldemo.dto.ImageDto;
import com.finaldemo.dto.UserDataDto;
import com.finaldemo.model.Users;
import com.finaldemo.service.TimmyService;

@Controller
public class UserSettingController {
	
	@Autowired
	private TimmyService service;

	@PostMapping("/timmy/uploadImgAjax")
	@ResponseBody
	public String uploadImagAjax(@RequestBody ImageDto dto) throws FileNotFoundException {
		String extension = dto.getImg64().replaceAll("data:" + dto.getType().trim() + ";base64,", "");
		String type = dto.getType().replaceAll("image/", "");
		Integer id = dto.getId();
		byte[] content = Base64.decodeBase64(extension);
		try {
			FileUtils.writeByteArrayToFile(
					new File(System.getProperty("user.dir") + "\\src\\main\\webapp\\img\\userimg\\",
							id.toString() + "." + type),
					content);
			System.out.println("upload file to folder success");
			Users user = service.getUserById(id);
			user.setPhotoPath("/img/userimg/" + id.toString() + "." + type);
			service.insertNewUser(user);
			System.out.println("upload filepath to db success");
			return "success";
		} catch (IOException e) {
			e.printStackTrace();
			return "failed";
		}
	}

	@PostMapping("/timmy/updateDataAjax")
	@ResponseBody
	public String updateDataAjax(@RequestBody UserDataDto data, HttpSession session) {
		Users user = (Users) session.getAttribute("user");
		System.out.println("nickname_before: " + user.getNickName());
		System.out.println("userid: " + user.getUserId());
		System.out.println("value: " + data.getValue());
		System.out.println("header: " + data.getHeader());
		Users u1 = service.getUserById(user.getUserId());
		if (data.getHeader().equals("nickName")) {
			u1.setNickName(data.getValue());
		}
		if (data.getHeader().equals("phone"))
			u1.setPhone(data.getValue());
		if (data.getHeader().equals("address"))
			u1.setAddress(data.getValue());
		if (data.getHeader().equals("selfIntroduction"))
			u1.setSelfIntroduction(data.getValue());
		if (data.getHeader().equals("birthday")) {
			try {
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Calendar calendar = Calendar.getInstance();
				Date date = dateFormat.parse(data.getValue());
				calendar.setTime(date);
				u1.setBirthday(calendar.getTime());
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		service.insertNewUser(u1);
		return data.getValue();
	}

	@PostMapping("/timmy/updateEmailAjax")
	@ResponseBody
	public String updateEmailAjax(@RequestBody UserDataDto dto, HttpSession session) {
		String email = dto.getValue() + "@" + dto.getHeader();
		System.out.println("email: " + email);
		if (service.checkEmail(email)) {
			Users user = (Users) session.getAttribute("user");
			Users u1 = service.getUserById(user.getUserId());
			u1.setEmail(email);
			service.insertNewUser(u1);
			return email;
		} else {
			return "email has been used";
		}
	}

	@PostMapping("/timmy/checkPasswordAjax")
	@ResponseBody
	public String checkPassword(@RequestBody UserDataDto dto, HttpSession session) {
		String password = dto.getValue();
		Users user = (Users) session.getAttribute("user");
		Users u1 = service.getUserById(user.getUserId());
		if (password.equals(u1.getPassword()))
			return "correctpassword";
		else
			return "wrongpassword";
	}

	@PostMapping("/timmy/updatePasswordAjax")
	@ResponseBody
	public String updatePassword(@RequestBody UserDataDto dto, HttpSession session) {
		if (dto.getValue() != null) {
			String password = dto.getValue();
			Users user = (Users) session.getAttribute("user");
			Users u1 = service.getUserById(user.getUserId());
			u1.setPassword(password);
			service.insertNewUser(u1);
			return "success";
		}
		return "failed";
	}

	@GetMapping("/timmy/updateAddressAjax/")
	@ResponseBody
	public String updateAddress(@RequestParam(name = "address") String address, HttpSession session) {
		if (address != null) {
			Users user = (Users) session.getAttribute("user");
			Users u1 = service.getUserById(user.getUserId());
			u1.setAddress(address);
			service.insertNewUser(u1);
			return address;
		}
		return "failed";
	}
}
