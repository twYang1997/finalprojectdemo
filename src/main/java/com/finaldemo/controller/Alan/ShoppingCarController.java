package com.finaldemo.controller.Alan;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.hibernate.dialect.identity.Ingres10IdentityColumnSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.finaldemo.dto.IdDto;
import com.finaldemo.model.Foundation;
import com.finaldemo.model.Posts;
import com.finaldemo.model.Products;
import com.finaldemo.model.ProductsRepository;
import com.finaldemo.model.ShoppingCar;
import com.finaldemo.model.Users;
import com.finaldemo.service.AlanService;

@Controller
public class ShoppingCarController {

	@Autowired
	private AlanService alanService;

	@Autowired
	private HttpSession session;

	/***
	 * 取得目前購物車商品資料
	 */
	@RequestMapping(path = "/Alan/shoppingCar")
	public String getShoppingCarProduct(Model model) {
//		Users users = (Users) session.getAttribute("login");
		Integer usersId = ((Users) session.getAttribute("user")).getUserId(); // 取得users session
		System.out.println(usersId);
		List<ShoppingCar> ShoppingCarList = alanService.findShoppingCarProducts(Integer.toString(usersId));   //
		model.addAttribute("ShoppingCarProducts", ShoppingCarList);
		System.out.println("ShoppingCarProducts:" + ShoppingCarList);
		return "Alan/shoppingCar";
	}

	/***
	 * 新增購物車商品資料
	 * 
	 * @param checkbox
	 */
	@PostMapping(path = "/Alan/insertShoppingCar")
//	@RequestParam("quantity") Integer quantity
	public String insertShoppingCarProduct(Model model, @RequestParam("checkbox") List<String> productIdList,
			@RequestParam("quantity") List<Integer> quantityList) {
		Integer usersId = ((Users) session.getAttribute("user")).getUserId(); // 取得users session
		for (int i = 0; i < productIdList.size(); i++) {
			Users usBean = alanService.usersfindById(usersId);
			ShoppingCar shBean = new ShoppingCar();
			Products pdBean = alanService.productsfindById(Integer.parseInt(productIdList.get(i)));
			shBean.setProducts(pdBean);
			shBean.setShopUser(usBean);
			shBean.setQuantity(quantityList.get(i));
			alanService.insertShoppingCar(shBean, usBean, pdBean);
		}
		System.out.println("productId::::" + productIdList);
		System.out.println("count::::" + quantityList);
		return this.getShoppingCarProduct(model);
	}

	/***
	 * 成立訂單商品頁面(尚未下單)
	 */
	@RequestMapping(path = "/Alan/order")
	public String getOrderShoppingCarProduct(Model model) {
//		Users users = (Users) session.getAttribute("login");

		List<ShoppingCar> ShoppingCarList = alanService.findShoppingCarProducts("1");

		model.addAttribute("ShoppingCarProducts", ShoppingCarList);

		System.out.println("ShoppingCarProducts:" + ShoppingCarList);
		return "Alan/foundOrder";
	}
	
	/***
	 * 刪除購物車商品
	 */
	@PostMapping(path = "/Alan/deleteShoppingCarProduct")
	public String deleteComment(Model model,@RequestParam("deleteShoppingCarProducts") Integer shoppingCarId) {
		System.out.println("shoppingCarId:" + shoppingCarId);
		alanService.deleteShoppingCarProducts(shoppingCarId);		
		return this.getShoppingCarProduct(model);
	}

}
