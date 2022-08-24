package com.finaldemo.controller.timmy;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

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
import com.finaldemo.model.PostImg;
import com.finaldemo.model.Posts;
import com.finaldemo.service.TimmyService;

@Controller
public class PostSettingController {
	
	@Autowired
	private TimmyService service;
	
	@PostMapping("/timmy/uploadPostImgAjax")
	@ResponseBody
	public String uploadPostImgAjax(@RequestBody List<ImageDto> dtoList) throws InterruptedException, ParseException {
		Integer imgNumber = 0;
		for (ImageDto dto:dtoList) {
			// 處理圖片資源 bytes type
			String extension = dto.getImg64().replaceAll("data:" + dto.getType().trim() + ";base64,", "");
			String type = dto.getType().replaceAll("image/", "");
			Integer id = dto.getId();
			byte[] content = Base64.decodeBase64(extension);
			// 取得 post 
			Posts p1 = service.getPostById(id);
			// 從 post 拿到 圖片集合
			Set<PostImg> postImg = p1.getPostImg();
			// new PostImg
			PostImg postImg2 = new PostImg();
			// 指定路徑
//			Thread.sleep(1000);
			SimpleDateFormat sdFormat = new SimpleDateFormat("yyyyMMddHHmmss");
			Date current = new Date();
			String now = sdFormat.format(current);
			String newPath = "/img/postimg/"+ id.toString() + "-" + now + imgNumber + "." + type;
			System.out.println("newPath: " + newPath);
			// 從圖片集合裡找，若有相同路徑者，該筆資料取代新 new 的 PostImg
			for (PostImg pImg:postImg) {
				if (pImg.getPostImgPath().equals(newPath)) {
					postImg2 = pImg;
					break;
				} 
			}
			try {
				// 存進硬碟 檔名由 PostID + 該圖片生成時間 + 單筆資料的第幾張圖片 + type 命名
				FileUtils.writeByteArrayToFile(
						new File(System.getProperty("user.dir") + "\\src\\main\\webapp\\img\\postimg\\" + id.toString() + "-" + now + imgNumber + "." + type),
						content);
				// 設定存進資料庫的屬性並存進資料庫
				postImg2.setPostImgPath(newPath);
				postImg2.setPost(p1);
				postImg.add(postImg2);
				service.insertNewPost(p1);
				imgNumber += 1;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Integer postImgId = service.getAllPostImg().get(service.getAllPostImg().size()-1).getPostImgId() + 1;
		return postImgId.toString();
	}
	
	@GetMapping("/timmy/deletePostImgAjax")
	@ResponseBody
	public String deletePostImgAjax(@RequestParam(name = "imgId") String imgId, @RequestParam(name = "postId") String postId, @RequestParam(name="onceAdd") String onceAdd) {
//		判斷是不是臨時加的圖片想刪掉
		System.out.println("imgId:" + imgId);         // imgid
		System.out.println("onceAdd:" + onceAdd);     // 一次加幾筆
		System.out.println("postID: " + postId);
		if (imgId.contains("add")) {
//			Integer onceAddNum = Integer.parseInt(onceAdd);
//			List<PostImg> postImgList = service.getPostImgListByPostId(Integer.parseInt(postId));
//			Integer maxId = 0;
//			for (PostImg postImg:postImgList) {
//				System.out.println("PostImgId: " + postImg.getPostImgId());
//				if (postImg.getPostImgId() > maxId) {
//					maxId = postImg.getPostImgId();
//				}
//			}
//			System.out.println(maxId);
//			Integer num = maxId - onceAddNum;
//			imgId = imgId.replaceAll("add", "");
//			Integer newImgId = Integer.parseInt(imgId);
//			System.out.println("To del Id is: " + (num + newImgId));
//			service.deletePostImgById(num + newImgId);
			Integer onceAddNum = Integer.parseInt(onceAdd);
			Integer postIdNum = Integer.parseInt(postId);
			imgId = imgId.replaceAll("add", "");
			Integer newImgId = Integer.parseInt(imgId);
			List<PostImg> postImgList = service.getPostImgListByPostIdOrderById(onceAddNum, postIdNum);
			Integer maxId = 0;
			for (PostImg postImg:postImgList) {
				System.out.println("PostImgId: " + postImg.getPostImgId());
				if (postImg.getPostImgId() > maxId) {
					maxId = postImg.getPostImgId();
				}
			}
			Integer num = maxId;
			System.out.println("To del Id is: " + num);
			service.deletePostImgById(num);
		} else {
			System.out.println("To del Id is: " + imgId);
			service.deletePostImgById(Integer.parseInt(imgId));
		}
		return imgId;
	}
}	
