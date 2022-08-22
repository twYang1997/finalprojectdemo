package com.finaldemo.model;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface ShoppingCarRepository extends JpaRepository<ShoppingCar, Integer> {

	@Query(value = "SELECT * FROM ShoppingCar S INNER JOIN Products P on S.fk_product_Id = P.productId  WHERE S.fk_user_id= ?1" ,nativeQuery = true)
	public List<ShoppingCar> ShoppingCarProducts(@Param("userId") String fk_user_id);	
	
	//刪除
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM ShoppingCar WHERE shoppingCarId = ?1" ,nativeQuery = true)
	public void deleteShoppingCarProducts(@Param("shoppingCarId") Integer shoppingCarId);	
}
