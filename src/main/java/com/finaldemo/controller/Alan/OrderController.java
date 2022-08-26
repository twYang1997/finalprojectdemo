package com.finaldemo.controller.Alan;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.finaldemo.model.Foundation;
import com.finaldemo.model.Orders;
import com.finaldemo.model.Products;
import com.finaldemo.model.ShoppingCar;
import com.finaldemo.model.Users;
import com.finaldemo.service.AlanService;

@Controller
public class OrderController {

	@Autowired
	private AlanService alanService;
	
	@Autowired
	private HttpSession session;

	/***
	 * 將確認訂單畫面新增進結帳頁面
	 */
	@PostMapping(path = "/Alan/Orders")
	public String insertOrders(Model model, @RequestParam("Q") List<Integer> strQ ,@RequestParam("Id") List<Integer> Id,@RequestParam("orderSubtotal") List<Integer> orderSubtotal) {
		Integer usersId = ((Users) session.getAttribute("user")).getUserId();
		System.out.print("OrderQ="+ strQ);
		System.out.print("fk_product_id="+ Id);
		System.out.print("orderSubtotal="+ orderSubtotal);
		
		for (int i = 0; i < strQ.size(); i++) { 
			
			System.out.println("strQstrQstrQ= " + strQ);
			
//			alanService.insertOrders(strQ);
		}
		
//	 	 List<ShoppingCar> shoppingCarList  = alanService.findShoppingCarProductsToOrders(strQ);
	 	 
//		System.out.print("購物車新增進結帳畫面="+ shoppingCarList);
//		
//		model.addAttribute("shoppingCarList", shoppingCarList);
//		
		
        return "Alan/foundOrder";
    }

}
