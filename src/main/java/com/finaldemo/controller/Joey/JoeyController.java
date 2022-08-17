package com.finaldemo.controller.Joey;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.finaldemo.model.Donate;
import com.finaldemo.model.PostImg;
import com.finaldemo.model.Posts;
import com.finaldemo.model.Product;
import com.finaldemo.model.Users;
import com.finaldemo.service.JoeyService;
import com.finaldemo.service.PhoebeService;
import com.finaldemo.service.TimmyService;

@Controller
public class JoeyController {

	@Autowired
	private JoeyService service;

	@Autowired
	private PhoebeService PhoebeService;

	@Autowired
	private TimmyService TimmyService;

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
		model.addAttribute("postsToShow", postsToShow);
		Users users = new Users();
		model.addAttribute("u", users);

//		Integer postId = ((Posts) session.getAttribute("post")).getPostId();
//		List<PostImg> postImgsByPostId = PhoebeService.getPostImgsByPostId(postId);
//		
//		PostImg postImg = new PostImg();
//		Integer postImgId = postImg.getPostImgId();
//		String postImgPath = postImg.getPostImgPath();
//		System.out.println("postImgPath:"+postImgPath);
//		System.out.println("postImgsByPostId:"+postImgsByPostId);
//		model.addAttribute("postImgPath", postImgPath);

		Users userBefore = (Users) session.getAttribute("user");
		Users userAfter = service.findById(userBefore.getUserId());
		session.setAttribute("user", userAfter);

		Set<Donate> donation = userAfter.getDonate();
		model.addAttribute("oneMember", userAfter);
		model.addAttribute("dotation", donation);

		return "joey/editMember";
	}

	// 新增商品（待完成）
	@PostMapping("/addProductJoey")
	public String addProduct(@RequestParam String productName, @RequestParam Integer productPrice,
			@RequestParam String productContext, @RequestParam MultipartFile[] productImg,
			HttpSession session)
			throws IllegalStateException, IOException {
		
		System.out.println("productName:"+productName+"  "+"productPrice:"+productPrice+"  "+"productContext:"+productContext+"  "+"productImg:"+productImg);

		Product product = new Product();
		Users user = (Users) session.getAttribute("user");
		Users fundation = PhoebeService.getUserById(user.getUserId());
		
		product.setProductName(productName);
		product.setProductPrice(productPrice);
		product.setProductStatus(1);
		product.setBuyCount(0);
		product.setProductContext(productContext);
		product.setProductDate(new Date());

		

		for (MultipartFile img : productImg) {
			// 存資料夾
			if (!(img.isEmpty())) {
				String fileName = img.getOriginalFilename();
				String productImgPath = "C:/Git/Project/Team3FinalPorject/src/main/webapp/img/joeyimg/joeyproductimg/"
						+ fileName;
				img.transferTo(new File(productImgPath));
//				// 存Product資料表
				product.setProductImg("/img/joeyimg/joeyproductimg/" + fileName);
				product.setUser(fundation);
				System.out.println("fundation:"+fundation);
				service.addProduct(product);

			} else {
				break;
			}

		}
		return "redirect:/findById2";
	}

	// 列出所有商品（待完成）
	@GetMapping("/findProductsById")
	public String findPrductsById(HttpSession session, Model model) {
		Integer userId = ((Users) session.getAttribute("user")).getUserId();
		List<Product> productsToShow = service.findProudtsByUserId(userId);
		model.addAttribute("productsToShow", productsToShow);
		Users users = new Users();
		model.addAttribute("u", users);

		return "redirect:/findById2";
	}

	// 修改商品（待完成）
	@PostMapping("/editProdut")
	public String editProduct(@RequestParam Integer productId) {
		return null;

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
			FileUtils.writeByteArrayToFile(
					new File(System.getProperty("user.dir") + "\\src\\main\\webapp\\img\\joeyimg\\joeypostimg\\",
							userId + photoType),
					bytes);

			return "joey/joeytest";
		} catch (IOException e) {
			e.printStackTrace();
			return "joey/joeytest";
		}
	}

	// 新增post
	@PostMapping("/addPostJoey")
	public String addPostJoey(@RequestParam String postText, @RequestParam MultipartFile[] postImg,
			@RequestParam MultipartFile postVideo, @RequestParam Integer whoCanSeeIt, HttpSession session,
			HttpServletRequest request) throws IllegalStateException, IOException {
		Posts posts = new Posts();
		Users user = (Users) session.getAttribute("user");
		Users author = TimmyService.getUserById(user.getUserId());
		posts.setIsReport(0);
		posts.setPostLike(0);
		posts.setPostText(postText);
		posts.setPostTime(new Date());
		posts.setPostVideoSrc(postVideo.getOriginalFilename());
		posts.setWhoCanSeeIt(whoCanSeeIt);
		posts.setPostUser(author);

		Posts newPost = PhoebeService.addPost(posts);

		// 存圖片
		PostImg newPostImg = new PostImg();
		for (MultipartFile img : postImg) {
			// 存資料夾
			if (!(img.isEmpty())) {
				String fileName = img.getOriginalFilename();
				String postImgPath = "C:/Git/Project/Team3FinalPorject/src/main/webapp/img/joeyimg/joeypostimg/"
						+ fileName;
//				String postImgPath = "C:/upload/" + fileName;
				img.transferTo(new File(postImgPath));
				// 存PostImg資料表
				newPostImg.setPost(newPost);
				newPostImg.setPostImgPath("/img/joeyimg/joeypostimg/" + fileName);
				PhoebeService.addPostImg(newPostImg);
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

	@PostMapping("/postuploadjoey")
	public String uploadPost(@RequestParam Integer postId, @RequestParam String postText,
			@RequestParam MultipartFile[] postImg, @RequestParam MultipartFile postVideo,
			@RequestParam Integer whoCanSeeIt, HttpSession session) throws IllegalStateException, IOException {
		Posts post = PhoebeService.getPostByPostId(postId);
		post.setPostText(postText);
		post.setPostTime(new Date());
		post.setPostVideoSrc(postVideo.getOriginalFilename());
		post.setWhoCanSeeIt(whoCanSeeIt);
		PhoebeService.editPost(post);
		PhoebeService.deleteExtraImgs(postId);

		// 存圖片
		PostImg newPostImg = new PostImg();
		for (MultipartFile img : postImg) {
			// 存資料夾
			if (!(img.isEmpty())) {
				String fileName = img.getOriginalFilename();
				String postImgPath = "C:/Git/Project/Team3FinalPorject/src/main/webapp/img/joeyimg/joeypostimg/"
						+ fileName;
				img.transferTo(new File(postImgPath));
				newPostImg.setPostImgPath(postImgPath);
				// 存PostImg資料表
				newPostImg.setPost(post);
				newPostImg.setPostImgPath("/img/joeyimg/joeypostimg/" + fileName);
				PhoebeService.addPostImg(newPostImg);
			} else {
				break;
			}
		}

		return "redirect:/findById2";

	}

	@PostMapping("/deleteMember")
	public String deleteUser(@RequestParam Integer id) {
		service.deleteUser(id);

		return "/joey/editMember";
	}

	@GetMapping("/ajaxtest")
	public @ResponseBody String testAjax() {

		String ajaxText = "Ajax回傳內容";

		return ajaxText;

	}

}
