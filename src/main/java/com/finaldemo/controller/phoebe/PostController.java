package com.finaldemo.controller.phoebe;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	private PhoebeService postService;

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
		Posts newPost = postService.addPost(p);

		// 存圖片
		PostImg newPostImg = new PostImg();
		for (MultipartFile img : postImg) {
			//存資料夾
			String fileName = img.getOriginalFilename();
			String postImgPath = "C:/Git/Project/finalprojectdemo/src/main/webapp/img/postImg/" + fileName;
			img.transferTo(new File(postImgPath));
			newPostImg.setPostImgPath(postImgPath);
			//存PostImg資料表
			
		}

		// 存影片
//		String fileName = postVideo.getOriginalFilename();
//		String postVideoPath = "/finalprojectdemo/src/main/webapp/video" + fileName;
//		postVideo.transferTo(new File(postVideoPath));
//		System.out.println("已上傳：" + fileName);

		return "redirect:/phoebe/";
	}
}
