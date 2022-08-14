package com.finaldemo.controller.Joey;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.finaldemo.model.Donate;
import com.finaldemo.model.PostImg;
import com.finaldemo.model.Posts;
import com.finaldemo.model.Users;
import com.finaldemo.service.JoeyService;
import com.finaldemo.service.PhoebeService;

@Controller
public class JoeyController {

	@Autowired
	private JoeyService service;
	
	@Autowired
	private PhoebeService PhoebeService;


	@InitBinder
	public void InitBinder(WebDataBinder binder) {
		// 前端传入的时间格式必须是"yyyy-MM-dd"效果!
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		CustomDateEditor dateEditor = new CustomDateEditor(df, true);
		binder.registerCustomEditor(Date.class, dateEditor);
	}

	

	@GetMapping("/findById")
	public String findAnUserById(@RequestParam(name = "id") Integer id, Model model) {

		Users oneMember = service.findById(id);
		Set<Donate> donation = oneMember.getDonate();

		System.out.println("dotation:" + donation);
		model.addAttribute("oneMember", oneMember);
		model.addAttribute("dotation", donation);
		model.addAttribute("userId", id);

		return "joey/editMember";

	}
	
	@GetMapping("/findById2")
	public String findAnUserById2(HttpSession session, Model model) {
		Integer userId = ((Users) session.getAttribute("user")).getUserId();
		List<Posts> postsToShow = PhoebeService.getPostsByUserId(userId);
		
//		Integer postId = ((Posts) session.getAttribute("post")).getPostId();
//		List<PostImg> postImgsByPostId = PhoebeService.getPostImgsByPostId(postId);
//		
//		PostImg postImg = new PostImg();
//		Integer postImgId = postImg.getPostImgId();
//		String postImgPath = postImg.getPostImgPath();
//		System.out.println("postImgPath:"+postImgPath);
//		System.out.println("postImgsByPostId:"+postImgsByPostId);
//		model.addAttribute("postImgPath", postImgPath);
		
		model.addAttribute("postsToShow", postsToShow);
		Users u = new Users();
		model.addAttribute("u", u);
		
		Users userBefore = (Users) session.getAttribute("user");
		Users userAfter = service.findById(userBefore.getUserId());
		session.setAttribute("user", userAfter);
		
		
		
		Set<Donate> donation = userAfter.getDonate();
		model.addAttribute("oneMember", userAfter);
		model.addAttribute("dotation", donation);
	
		
		return "joey/editMember";
	}

	@PostMapping("/editMember")
	public String editAnUser(@ModelAttribute Users user, Model model) {
		service.editUser(user);

		return "joey/joeytest";
	}

	@PostMapping("/fileuploadjoey")
	public String uploadNewPhoto(@RequestParam("userId") String userId, @RequestParam("file") MultipartFile file) {
		String photoPath = "/img/joeyimg/";
		String contentType = file.getContentType();
		String photoType = "." + contentType.substring(6);
		Users oneMember = service.findById(Integer.parseInt(userId));
		oneMember.setUserId(Integer.parseInt(userId));
		oneMember.setPhotoPath(photoPath + userId + photoType);
		service.editUser(oneMember);

		try {
			byte[] bytes = file.getBytes();
			FileUtils.writeByteArrayToFile(new File(
					System.getProperty("user.dir") + "\\src\\main\\webapp\\img\\joeyimg\\", userId + photoType), bytes);

			return "joey/joeytest";
		} catch (IOException e) {
			e.printStackTrace();
			return "joey/joeytest";
		}
	}
	
	@PostMapping("/postuploadjoey")
	public String uploadPost(@RequestParam Integer postId,@RequestParam String postText, @RequestParam("file") MultipartFile file) {
		String photoPath = "/img/joeyimg/joeypostimg/";
		String contentType = file.getContentType();
		String photoType = "." + contentType.substring(6);
		
		Posts onePost = PhoebeService.getPostByPostId(postId);
		onePost.setPostId(postId);
		onePost.setPostText(postText);
		Set<PostImg> getPostImg = onePost.getPostImg();
		PostImg postImg = new PostImg();
		postImg.setPostImgId(postId);
		postImg.setPostImgPath(photoPath+postId+photoType);
		getPostImg.add(postImg);
		onePost.setPostImg(getPostImg);
		PhoebeService.editPost(onePost);
		
		try {
			byte[] bytes = file.getBytes();
			FileUtils.writeByteArrayToFile(new File(
					System.getProperty("user.dir") + "\\src\\main\\webapp\\img\\joeyimg\\joeypostimg\\", postId + photoType), bytes);

			return "joey/joeytest";
		} catch (IOException e) {
			e.printStackTrace();
			return "joey/joeytest";
		}
		
//		new PostImg().setPostImgPath(photoPath+postId+photoType);

		
	}
	

	@PostMapping("/deleteMember")
	public String deleteUser(@RequestParam Integer id) {
		service.deleteUser(id);

		return "/joey/editMember";
	}

}
