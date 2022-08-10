package com.finaldemo.controller.Brian;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.finaldemo.dto.ImageDto;
import com.finaldemo.model.Users;
import com.finaldemo.service.BrainService;

@Controller
public class UsersListController {
	@Autowired
	private BrainService Service; // 連接Service 調用insertMessage

	@InitBinder
	public void InitBinder(WebDataBinder binder) {
		// 前端传入的时间格式必须是"yyyy-MM-dd"效果!
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		CustomDateEditor dateEditor = new CustomDateEditor(df, true);
		binder.registerCustomEditor(Date.class, dateEditor);
	}

	@GetMapping("/memberManagement")
	public String memberManagement(@RequestParam(name = "p", defaultValue = "1") Integer pageNumber, Model model) {
		Page<Users> page = Service.findByPage(pageNumber);
		Users newMsg = new Users();
		
		model.addAttribute("users", newMsg);
		model.addAttribute("page", page);
		return "Brian/memberManagement";
	}

	@PostMapping("/postUser")
	public String postUser(@ModelAttribute Users msg, Model model) {

		Service.insertUsers(msg);

		return "redirect:/memberManagement";
	}
	
	@PostMapping("/imgUploadAjax")
	@ResponseBody
	public String imgUpdate(@RequestBody ImageDto dto) {
		String extension = dto.getImg64().replaceAll("data:" + dto.getType().trim() + ";base64,", "");
		String type = dto.getType().replaceAll("image/", "");
		Integer id = dto.getId();
		System.out.print("img64 before:");
		for (int i=0;i<50;i++) {
			System.out.print(dto.getImg64().charAt(i));
		}
		System.out.println();
		System.out.print("after:");
		for (int i=0;i<50;i++) {
			System.out.print(extension.charAt(i));
		}
		System.out.println();
		System.out.println(dto.getType());
		System.out.println(dto.getId());
		byte[] content = Base64.decodeBase64(extension);
		try {
			FileUtils.writeByteArrayToFile(
					new File(System.getProperty("user.dir") + "\\src\\main\\webapp\\img\\userimg\\",
							id.toString() + "." + type),
					content);
			System.out.println("upload file to folder success");
			Users user = Service.findById(id);
			user.setPhotoPath("/img/userimg/" + id.toString() + "." + type);
			Service.insertUsers(user);
			System.out.println("upload filepath to db success");
			return "success";
		} catch (IOException e) {
			e.printStackTrace();
			return "failed";
		}
	}
}
