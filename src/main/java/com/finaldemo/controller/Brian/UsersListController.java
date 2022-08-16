package com.finaldemo.controller.Brian;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.finaldemo.model.Posts;
import com.finaldemo.model.Users;
import com.finaldemo.service.BrainService;

@Controller
public class UsersListController {
	@Autowired
	private BrainService Service; // 連接Service
	
	// 前端传入的时间格式必须是"yyyy-MM-dd"效果!
	@InitBinder
	public void InitBinder(WebDataBinder binder) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		CustomDateEditor dateEditor = new CustomDateEditor(df, true);
		binder.registerCustomEditor(Date.class, dateEditor);
	}
	
	//撈出所以有一般會員
	@GetMapping("/memberManagement")
	public String memberManagement(@RequestParam(name = "p", defaultValue = "1") Integer pageNumber, Model model) {
		Page<Users> page = Service.findByPage(pageNumber);
		Users newMsg = new Users();

		model.addAttribute("users", newMsg);
		model.addAttribute("page", page);
		return "Brian/memberManagement";
	}
	
	//編輯一般會員
	@PostMapping("/editUser")
	public String editUser(@ModelAttribute Users user, Model model, @RequestParam("testfile") MultipartFile file) {
		try {
//			System.out.println(file.getContentType());
//			System.out.println("String: ");
//			for (int i = 0;i<file.getBytes().toString().length();i++) {
//				System.out.print(file.getBytes().toString().charAt(i));
//			}
			Users u1 = Service.BrainGetUserById(user.getUserId());
			u1.setEmail(user.getEmail());
			u1.setPassword(user.getPassword());
			u1.setNickName(user.getNickName());
			u1.setPhone(user.getPhone());
			u1.setAddress(user.getAddress());
			u1.setBirthday(user.getBirthday());
			u1.setGender(user.getGender());
			u1.setCategory(user.getCategory());
			u1.setSelfIntroduction(user.getSelfIntroduction());
			String type = file.getContentType().replaceAll("image/", "");
			if (!type.contains("application")) {
				byte[] bytes = file.getBytes();
				FileUtils.writeByteArrayToFile(new File(System.getProperty("user.dir")
						+ "\\src\\main\\webapp\\img\\userimg\\" + user.getUserId() + "." + type), bytes);

				u1.setPhotoPath("/img/userimg/" + user.getUserId() + "." + type);
			}
			Service.insertUsers(u1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:/memberManagement";
	}
	
	//停用一般會員 假刪除真更新
	@GetMapping("/deleteUser")
	public String deleteUser(HttpSession session, Model model, @RequestParam("id") String id) {
		Users u1 = Service.BrainGetUserById(Integer.parseInt(id));
		u1.setCategory(0);
		Service.insertUsers(u1);
		session.invalidate();
		return "redirect:/memberManagement";
	}
	
	//恢復會員判斷之前的是什麼會員
	@GetMapping("/rebirthUser")
	public String rebirthUser(Model model, @RequestParam("id") String id) {
		Users u1 = Service.BrainGetUserById(Integer.parseInt(id));
		System.out.println("this:"+ u1);
		if (u1.getMoney()!=null) {
			u1.setCategory(2);
			System.out.println("this:!=null");

			Service.insertUsers(u1);
			
		} else if (u1.getMoney()==null) {
			u1.setCategory(1);
			
			System.out.println("this:==null");
			Service.insertUsers(u1); 
		}
		
		return "redirect:/memberManagement";
	}
	
	// 顯示登入者主頁貼文
		@GetMapping("/userPosts")
		public String userPosts(Model model, @RequestParam("id") String id) {
			// 取得登入者發的posts
			Posts posts = Service.BrainGetPostsById(Integer.parseInt(id));
			//posts.getPostText();
			model.addAttribute("posts", posts);
			return "redirect:/memberManagement";
		}
		
		@GetMapping("/userLink")
		public String userLink(Model model, @RequestParam("id") String id) {
			System.out.println("********user:"+id);
			Users userLink = Service.BrainGetUserById(Integer.parseInt(id));
			System.out.println("********userLink:"+userLink);
			model.addAttribute("userLink", userLink);
			return "timmy/NormalMember";
		}
	
	
	
//	@PostMapping("/Brian/uploadImgAjax")
//	@ResponseBody
//	public String uploadImagAjax(@RequestBody ImageDto dto) throws FileNotFoundException {
//		String extension = dto.getImg64().replaceAll("data:" + dto.getType().trim() + ";base64,", "");
//		String type = dto.getType().replaceAll("image/", "");
//		Integer id = dto.getId();
//		for (int i = 0; i < 50; i++) {
//			System.out.print(extension.charAt(i));
//		}
//		byte[] content = Base64.decodeBase64(extension);
//		try {
//			FileUtils.writeByteArrayToFile(
//					new File(System.getProperty("user.dir") + "\\src\\main\\webapp\\img\\userimg\\",
//							id.toString() + "." + type),
//					content);
//			System.out.println("upload file to folder success");
//			Users user = Service.BraingetUserById(id);
//			user.setPhotoPath("/img/userimg/" + id.toString() + "." + type);
//			Service.insertUsers(user);
//			System.out.println("upload filepath to db success");
//			return "success";
//		} catch (IOException e) {
//			e.printStackTrace();
//			return "failed";
//		}
//	}
//	@PostMapping("/Brian/uploadImgAjax")
//	public String uploadNewPhoto(@RequestParam("testfile")MultipartFile file
//		, ) {
//			byte[] bytes = file.getBytes();
//			FileUtils.writeByteArrayToFile(
//					new File(System.getProperty("user.dir") + "\\src\\main\\webapp\\img\\joeyimg\\",
//							userId+ photoType),
//					bytes);
//
//			return "redirect:/memberManagement";
//		
//		}
//	}

//	@PostMapping("/imgUploadAjax")
//	@ResponseBody
//	public String imgUpdate(@RequestBody ImageDto dto) {
//		String extension = dto.getImg64().replaceAll("data:" + dto.getType().trim() + ";base64,", "");
//		String type = dto.getType().replaceAll("image/", "");
//		Integer id = dto.getId();
//		System.out.print("img64 before:");
//		for (int i=0;i<50;i++) {
//			System.out.print(dto.getImg64().charAt(i));
//		}
//		System.out.println();
//		System.out.print("after:");
//		for (int i=0;i<50;i++) {
//			System.out.print(extension.charAt(i));
//		}
//		System.out.println();
//		System.out.println(dto.getType());
//		System.out.println(dto.getId());
//		byte[] content = Base64.decodeBase64(extension);
//		try {
//			FileUtils.writeByteArrayToFile(
//					new File(System.getProperty("user.dir") + "\\src\\main\\webapp\\img\\userimg\\",
//							id.toString() + "." + type),
//					content);
//			System.out.println("upload file to folder success");
//			Users user = Service.findById(id);
//			user.setPhotoPath("/img/userimg/" + id.toString() + "." + type);
//			Service.insertUsers(user);
//			System.out.println("upload filepath to db success");
//			return "success";
//		} catch (IOException e) {
//			e.printStackTrace();
//			return "failed";
//		}
//	}
}
