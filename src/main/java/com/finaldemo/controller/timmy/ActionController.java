package com.finaldemo.controller.timmy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.finaldemo.dto.ImageDto;
import com.finaldemo.dto.UserDataDto;
import com.finaldemo.model.Posts;
import com.finaldemo.model.Users;
import com.finaldemo.service.TimmyService;

@Controller
public class ActionController {

	@Autowired
	private TimmyService service;
	
	@PostMapping("/timmy/NewUserPage")
	@ResponseBody
	public Users newUserTest() {
		Calendar c = Calendar.getInstance();
		c.set(1997, 10, 14);
		Users u1 = new Users();
		u1.setNickName("jenny");
		u1.setPassword("1234");
		u1.setAddress("台南市永康區大橋兩百街100號");
		u1.setBirthday(c.getTime());
		u1.setCategory(1);
		u1.setEmail("timmy860930@gmail.com");
		u1.setGender(1);
		u1.setPhone("0970322377");
		u1.setSelfIntroduction("我好你好");
		return service.insertNewUser(u1);
	}
	
	@PostMapping("/timmy/NewUserPage2")
	@ResponseBody
	public Users newUserTest2() {
		Calendar c = Calendar.getInstance();
		c.set(1997, 10, 14);
		Users u1 = new Users();
		u1.setNickName("timmy");
		u1.setAddress("火星");
		u1.setBirthday(c.getTime());
		u1.setCategory(1);
		u1.setEmail("8787878@gmail.com");
		u1.setGender(1);
		u1.setPhone("0970322377");
		u1.setSelfIntroduction("87喔");
		return service.insertNewUser(u1);
	}
	
	@PostMapping("/timmy/NewPostPage")
	@ResponseBody
	public Posts newPostTest() {
		Users u1 = service.getUserById(11);
		Set<Posts> ps = u1.getPosts();
		Posts p1 = new Posts();
		p1.setPostText("第一次PO文");
		p1.setPostTime(new Date());
		p1.setIsReport(0);
		p1.setWhoCanSeeIt(1);
		p1.setPostUser(u1);
		ps.add(p1);
		u1.setPosts(ps);
		service.insertNewUser(u1);
//		service.insertNewPost(p1);
		return p1;
	}
	
	@GetMapping("/timmy/DeleteTestPage")
	public void deletePostsTest() {
		service.deleteAllPost();
	}
	
	@GetMapping("/timmy/DeleteTestPage2")
	public void deleteUsersTest() {
		service.deleteAllUser();
	}
	
	@PostMapping("/timmy/checkLogin.controller")
	public String checkLoginProcess(@RequestParam String email, @RequestParam String password, Model m, HttpSession session) {
		Map<String,String> errors = new HashMap<String,String>();
		m.addAttribute("errors", errors);
		if (email == null || email.length()==0) {
			errors.put("email", "Email is required");
		}
		if (password == null || password.length()==0) {
			errors.put("pwd", "Password is required");
		}
		if(errors!=null && !errors.isEmpty()) {
			return "redirect:timmy/login";
		}
		Users u = service.checkLogin(email, password);
		if (u != null) {
			session.setAttribute("user", u);
			return "timmy/NormalMember";
		}
		errors.put("failed", "login failed");
		return "redirect:/timmy/";
	}
//	@GetMapping("getPosts/{id}")
//	@ResponseBody
//	public List<Posts> getPostTest(@PathVariable Integer id){
//		return service.getPostsByUserId(id);
//	}
//	
//	@GetMapping("getUser/{id}")
//	@ResponseBody
//	public Users getUser(@PathVariable Integer id){
//		 Users u1 = service.getUserById(id);
//		return u1;
//	}
	@GetMapping("/timmy/")
	public String loginPage() {
		return "timmy/login";
	}
	
	
	@PostMapping("/timmy/updateUserPage")
	@ResponseBody
	public Users updateUserTest() {
		Calendar c = Calendar.getInstance();
		c.set(1997, 10, 14);
		Users u1 = service.getUserById(1);
		u1.setNickName("jenny");
		u1.setPassword("1234");
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

	@GetMapping("/timmy/accountsetting.controller")
	public String testgivingSession(HttpSession session, Model m) {
//		Users u1 = (Users)m.getAttribute("user");
//		session.setAttribute("user", u1);
//		if (u1.getCategory() == 1) {
//			Users u1 = (Users)session.getAttribute("user");
//			session.setAttribute("posts", u1.getPosts());
//			m.addAttribute("newUser", new Users());
		session.setAttribute("user", service.getUserById(1));
		return "timmy/NormalMember";
//		}
//		else if (u1.getCategory() == 2)
//			return "timmy/CharityMember";
//		else
//			return null;
	}

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
		Users user = (Users)session.getAttribute("user");
		System.out.println("userid: " + user.getUserId());
		System.out.println("value: " + data.getValue());
		System.out.println("header: " + data.getHeader());
		Users u1 = service.getUserById(user.getUserId());
		if (data.getHeader().equals("nickName"))
			u1.setNickName(data.getValue());
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
	public String updateEmailAjax(@RequestBody UserDataDto dto, HttpSession session){
		String email = dto.getValue() + "@" + dto.getHeader();
		System.out.println("email: " + email);
		if(service.checkEmail(email)) {
			Users user = (Users)session.getAttribute("user");
			Users u1 = service.getUserById(user.getUserId());
			u1.setEmail(email);
			service.insertNewUser(u1);
			return email;
		} else {
			return "email has been used";
		}
	}
//	@PostMapping("/timmy/checkEmail.controller")
//	public String updateEmail(@RequestParam("font") String font, @RequestParam("below") String below, Model m, HttpSession session) {
//		Map<String,String> errors = new HashMap<String,String>();
//		m.addAttribute("errors", errors);
//		String email = font + "@" + below;
//		if (font.contains("@") || below.contains("@")) {
//			errors.put("error", "wrong format");
//			return "timmy/NormalMember";
//		}
//		if (font == null || font.length()==0 || below == null || below.length()==0) {
//			errors.put("error", "column is empty");
//			return "timmy/NormalMember";
//		}
//		Users user = (Users)session.getAttribute("user");
//		if (user.getEmail().equals(email)) {
//			return "timmy/NormalMember";
//		}
//		if (service.checkEmail(email) && errors.isEmpty()) {
//			user.setEmail(email);
//			service.insertNewUser(user);
//		} else {
//			errors.put("error", "email has been used");
//		}
//		return "timmy/NormalMember";
//	}
//	@GetMapping("/timmy/postManager.controller")
//	public String action1(HttpSession session, Model m) {
//		Users u1 = (Users)session.getAttribute("user");
//		session.setAttribute("user", service.getUserById(u1.getUserId()));
//		System.out.println("name: " + u1.getNickName());
//		Iterator<Posts> it = u1.getPosts().iterator();
//		while(it.hasNext()) {
//			System.out.println("text: " + it.next().getPostText());
//		}
//		System.out.println();
//		m.addAttribute("posts", u1.getPosts());
//		return "timmy/PostSetting";
//	}
	
	@GetMapping("/timmy/normalmemberdetail.controller")
	public String action2(HttpSession session, Model m) {
		m.addAttribute("newUser", new Users());
		return "timmy/UserSetting";
	}
	
	@PostMapping("/timmy/updateUser.controller")
	public String action(HttpSession session, @ModelAttribute Users user) {
		Users oldUser = (Users)session.getAttribute("user");
		System.out.println(oldUser.getUserId());
		user.setUserId(oldUser.getUserId());
		service.insertNewUser(user);
		return "redirect:/timmy/accountsetting.controller";
	}
	
}
