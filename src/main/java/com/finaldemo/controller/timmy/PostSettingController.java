package com.finaldemo.controller.timmy;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public String uploadPostImgAjax(@RequestBody ImageDto dto) {
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
		String newPath = "/img/postimg/"+ id.toString() + "-" + postImg.size() + "." + type;
		System.out.println("newPath: " + newPath);
		// 從圖片集合裡找，若有相同路徑者，該筆資料取代新 new 的 PostImg
		for (PostImg pImg:postImg) {
			if (pImg.getPostImgPath().equals(newPath)) {
				postImg2 = pImg;
				break;
			} 
		}
		try {
			// 存進硬碟 檔名由 PostID + 該Post的第幾張圖片取名
			FileUtils.writeByteArrayToFile(
					new File(System.getProperty("user.dir") + "\\src\\main\\webapp\\img\\postimg\\" + id.toString() + "-" + postImg.size() + "." + type),
					content);
			// 設定存進資料庫的屬性並存進資料庫
			postImg2.setPostImgPath(newPath);
			postImg2.setPost(p1);
			postImg.add(postImg2);
			service.insertNewPost(p1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dto.getType();
	}
}	
