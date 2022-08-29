package com.finaldemo.controller.Alan;

import java.util.Date;
import java.util.List;
import java.util.Set;
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
import com.finaldemo.model.OrderDetail;
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
		System.out.println("OrderQ="+ strQ);
		System.out.println("fk_product_id="+ Id);
		System.out.println("orderSubtotal="+ orderSubtotal);
		
		Integer usersId = ((Users) session.getAttribute("user")).getUserId();
		Users u1 = (Users) session.getAttribute("user");
		Users u2 = alanService.findUserById(u1.getUserId()); 
		System.out.println(u2.getNickName());
		// 從user拿到 orders 集合 Set<Orders>
		Set<Orders> orders = u2.getOrders();
		// 新增一筆訂單 new Orders()
		Orders newOrder = new Orders();
		// 要設定訂單詳細資料，從訂單拿到訂單詳細集合 List<OrderDetail>
		List<OrderDetail> od1 = newOrder.getOrderDetails();
		// 新增一筆詳細資料new OrderDetail() 並添加到訂單詳細集合 List<OrderDetail>
		Integer price = 0;
		for (int i = 0; i < strQ.size(); i++) { 
			OrderDetail d1 = new OrderDetail();
			d1.setOrderQuantity(u2.getUserId());
			d1.setOrders(newOrder); // *
			//我需要再做出關聯product
			
			d1.setOrderQuantity(strQ.get(i));
			d1.setOrderSubtotal(orderSubtotal.get(i));
			od1.add(d1); // *
			price += (strQ.get(i) * orderSubtotal.get(i));
		}
		orders.add(newOrder); // *
		newOrder.setOrderUser(u2); // *
		newOrder.setOrderDate(new Date());
		String num = "";
		for (int i=0;i<5;i++) {
			Integer r1 = (int)Math.floor(Math.random() * 9) ;
			num = num + r1.toString();
		}
		
		newOrder.setOrderNo(num);
		newOrder.setOrderPrice(usersId);
		newOrder.setOrderPrice(price);
		alanService.insertUsers(u2); // *
		
        return "Alan/foundOrder";
    }

}
