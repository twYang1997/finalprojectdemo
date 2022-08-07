package com.finaldemo.controller.timmy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.finaldemo.dto.ImageDto;
import com.finaldemo.model.Posts;
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
	
	@PostMapping("NewPostPage")
	@ResponseBody
	public Posts newPostTest() {
		Users u1 = service.getUserById(2);
		Set<Posts> ps = u1.getPosts();
		Posts p1 = new Posts();
		p1.setPostText("第一次PO文");
		p1.setPostTime(new Date());
		p1.setIsReport(0);
		p1.setWhoCanSeeIt(1);
		p1.setPostUser(u1);
		ps.add(p1);
		service.insertNewUser(u1);
		service.insertNewPost(p1);
		return p1;
	}
	
	@GetMapping("DeleteTestPage")
	public void deletePostsTest() {
		service.deletePostById(5);
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
	
	@PostMapping("updateUserPage")
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

	@PostMapping("user/uploadImgAjax")
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
	
	@GetMapping("user/postManager.controller")
	public String action1(HttpSession session, Model m) {
		Users u1 = (Users)session.getAttribute("user");
		System.out.println("name: " + u1.getNickName());
		Iterator<Posts> it = u1.getPosts().iterator();
		while(it.hasNext()) {
			System.out.println("text: " + it.next().getPostText());
		}
		System.out.println();
		m.addAttribute("posts", u1.getPosts());
		return "timmy/PostSetting";
	}
	
	@GetMapping("user/normalmemberdetail.controller")
	public String action2(HttpSession session, Model m) {
		m.addAttribute("newUser", new Users());
		return "timmy/UserSetting";
	}
	
}
