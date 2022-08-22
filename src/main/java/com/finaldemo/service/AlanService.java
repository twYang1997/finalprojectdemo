package com.finaldemo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finaldemo.model.Foundation;
import com.finaldemo.model.FoundationRepository;
import com.finaldemo.model.Products;
import com.finaldemo.model.ProductsRepository;
import com.finaldemo.model.ShoppingCar;
import com.finaldemo.model.ShoppingCarRepository;
import com.finaldemo.model.Users;
import com.finaldemo.model.UsersRepository;

@Service
@Transactional
public class AlanService {

	@Autowired
	private UsersRepository userDao;

	@Autowired
	private FoundationRepository foundationDao;

	@Autowired
	private ShoppingCarRepository shoppingCarDao;

	@Autowired
	private ProductsRepository productsDao;

	/** 取得所有基金會資料 */
	public List<Users> findAllCharities() {
		return userDao.findAllCharities();
	}

	/** 取得基金會商品資料 */
	public List<Foundation> findAllFoundationProducts(String foundationId) {
		return foundationDao.findAllFoundationProducts(foundationId);
	}

	/** 取得單筆基金會資料 */
	public List<Users> findFoundation(String foundationId) {
		return userDao.findFoundation(foundationId);
	}

	/** 取得單個會員訂單資料 */
	public List<ShoppingCar> findShoppingCarProducts(String userId) {
		return shoppingCarDao.ShoppingCarProducts(userId);

	}

	/******** 多方新增 *******/
	public ShoppingCar insertShoppingCar(ShoppingCar shop, Users us, Products pd) {
//		MemberBean member = memReps.findById(shop.getShopUser().getUserId()).get();
//		ProductBean pd = pdReps.findById(shop.getProductBean().getProductId()).get(); 
		us.getShoppingCar().add(shop);
		pd.getShoppingCar().add(shop);
		shop.setProducts(pd);
		shop.setShopUser(us);
		return shoppingCarDao.save(shop);
	}

	/******** JPA *******/
	public Products productsfindById(Integer id) {
		Optional<Products> op1 = productsDao.findById(id);

		if (op1.isPresent()) {
			Products pd = op1.get();
			return pd;
		}
		return null;
	}

	public Users usersfindById(Integer id) {
		Optional<Users> op1 = userDao.findById(id);

		if (op1.isPresent()) {
			Users pd = op1.get();
			return pd;
		}
		return null;
	}
	
	/******** 刪除 *******/
	public void deleteShoppingCarProducts(Integer shoppingCarId) {
		System.out.println("shoppingCarId:" + shoppingCarId);
		shoppingCarDao.deleteShoppingCarProducts(shoppingCarId);
	}
 
}
