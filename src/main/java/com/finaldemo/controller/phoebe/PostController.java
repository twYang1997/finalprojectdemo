package com.finaldemo.controller.phoebe;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.finaldemo.model.PostImg;
import com.finaldemo.model.Posts;
import com.finaldemo.model.Users;
import com.finaldemo.service.PhoebeService;

@Controller
public class PostController {

	@Autowired
	private PhoebeService service;

	// 顯示登入者主頁貼文
	@GetMapping("/getMainPagePosts.controller")
	public PostImg getMainPagePosts(HttpSession session, Model model){
		ArrayList<Posts> postdDisplayOnMainPage = new ArrayList<Posts>();
		//取得登入者發的posts
		Integer userId = ((Users)session.getAttribute("Users")).getUserId();
//		service.getPostsByUserId(userId);
//		
//		Optional<PostImg> optional = service.getPostImgsByPostId();
//		if (optional.isPresent()) {
//			model.addAttribute("postImg", optional.get());
//		} else {
//			return optional.get();
//		}
//		return optional.get();
		return null;
	}

	// 新增post
	@PostMapping("/addPost.controller")
	public String addPost(@RequestParam String postText, @RequestParam MultipartFile[] postImg,
			@RequestParam MultipartFile postVideo, @RequestParam Integer whoCanSeeIt, HttpSession session)
			throws IllegalStateException, IOException {
		Posts p = new Posts();
		p.setIsReport(0);
		p.setPostLike(0);
		p.setPostText(postText);
		p.setPostTime(new Date());
		p.setPostVideoSrc(postVideo.getOriginalFilename());
		p.setWhoCanSeeIt(whoCanSeeIt);
		p.setPostUser((Users) session.getAttribute("Users"));
		Posts newPost = service.addPost(p);

		// 存圖片
		PostImg newPostImg = new PostImg();
		for (MultipartFile img : postImg) {
			// 存資料夾
			String fileName = img.getOriginalFilename();
			String postImgPath = "C:/Git/Project/finalprojectdemo/src/main/webapp/img/postImg/" + fileName;
			img.transferTo(new File(postImgPath));
			newPostImg.setPostImgPath(postImgPath);
			// 存PostImg資料表
			newPostImg.setPost(newPost);
			newPostImg.setPostImgPath(postImgPath);
			service.addPostImg(newPostImg);
		}

		// 存影片
//		String fileName = postVideo.getOriginalFilename();
//		String postVideoPath = "/finalprojectdemo/src/main/webapp/video" + fileName;
//		postVideo.transferTo(new File(postVideoPath));
//		System.out.println("已上傳：" + fileName);

		return "redirect:/phoebe/";
	}
}
