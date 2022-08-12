package com.finaldemo.controller.phoebe;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
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
import com.finaldemo.service.TimmyService;

@Controller
public class PostController_P {

	@Autowired
	private PhoebeService service;
	@Autowired
	private TimmyService TimmyService;

	// 顯示登入者主頁貼文
	@GetMapping("/getMainPagePosts.controller")
	public String getMainPagePosts(HttpSession session, Model model) {
		// 取得登入者發的posts
		Integer userId = ((Users) session.getAttribute("user")).getUserId();
		List<Posts> postsToShow = service.getPostsByUserId(userId);
		model.addAttribute("postsToShow", postsToShow);
		Users u = new Users();
		model.addAttribute("u", u);
		return "phoebe/index";
	}

	// 新增post
	@PostMapping("/addPost.controller")
	public String addPost(@RequestParam String postText, @RequestParam MultipartFile[] postImg,
			@RequestParam MultipartFile postVideo, @RequestParam Integer whoCanSeeIt, HttpSession session,
			HttpServletRequest request) throws IllegalStateException, IOException {
		Posts p = new Posts();
		Users u = (Users) session.getAttribute("user");
		Users author = TimmyService.getUserById(u.getUserId());
//		Set<Posts> posts = author.getPosts();
		p.setIsReport(0);
		p.setPostLike(0);
		p.setPostText(postText);
		p.setPostTime(new Date());
		p.setPostVideoSrc(postVideo.getOriginalFilename());
		p.setWhoCanSeeIt(whoCanSeeIt);
		p.setPostUser(author);
//		posts.add(p);
//		author.setPosts(posts);
//		TimmyService.insertNewUser(author);
//		p.setPostUser((Users) session.getAttribute("user"));
		Posts newPost = service.addPost(p);

		// 存圖片
		PostImg newPostImg = new PostImg();
		for (MultipartFile img : postImg) {
			// 存資料夾
			if (!(img.isEmpty())) {
				String fileName = img.getOriginalFilename();
				String postImgPath = "C:/Git/Project/finalprojectdemo/src/main/webapp/img/postimg/" + fileName;
				img.transferTo(new File(postImgPath));
				// 存PostImg資料表
				newPostImg.setPost(newPost);
				newPostImg.setPostImgPath(fileName);
				service.addPostImg(newPostImg);
			} else {
				break;
			}
		}

		// 影片存資料夾
		if (!(postVideo.isEmpty())) {
			String fileName = postVideo.getOriginalFilename();
			String videoPath = "C:/Git/Project/finalprojectdemo/src/main/webapp/video/" + fileName;
			postVideo.transferTo(new File(videoPath));
		}
		return "redirect:/getMainPagePosts.controller";
	}

	// 修改post
	@PostMapping("/editPost.controller")
	public String editPost(@RequestParam Integer postId, @RequestParam String postText,
			@RequestParam MultipartFile[] postImg, @RequestParam MultipartFile postVideo,
			@RequestParam Integer whoCanSeeIt, HttpSession session) throws IllegalStateException, IOException {
		Posts p = service.getPostByPostId(postId);
//		Users u = (Users) session.getAttribute("user");
//		Users author = TimmyService.getUserById(u.getUserId());
		p.setPostText(postText);
		p.setPostTime(new Date());
		p.setPostVideoSrc(postVideo.getOriginalFilename());
		p.setWhoCanSeeIt(whoCanSeeIt);
//		p.setPostUser(author);
		service.editPost(p);
		service.deleteExtraImgs(postId);

		// 存圖片
		PostImg newPostImg = new PostImg();
		for (MultipartFile img : postImg) {
			// 存資料夾
			if (!(img.isEmpty())) {
				String fileName = img.getOriginalFilename();
				String postImgPath = fileName;
				img.transferTo(new File(postImgPath));
				newPostImg.setPostImgPath(postImgPath);
				// 存PostImg資料表
				newPostImg.setPost(p);
				newPostImg.setPostImgPath(postImgPath);
				service.addPostImg(newPostImg);
			} else {
				break;
			}
		}

		return "redirect:/getMainPagePosts.controller";
	}

	// post移到垃圾桶
	@PostMapping("/movePostToTrash.controller")
	public String movePostToTrash(@RequestParam Integer postId) {
		service.movePostToTrash(0, postId);
		return "redirect:/getMainPagePosts.controller";
	}
}
