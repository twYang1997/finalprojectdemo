package com.finaldemo.model;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface ProductRepository extends JpaRepository<Product, Integer> {

	// 此為小郭寫的亂刪砍手

	@Query(value = "Select * from Product where fk_user_id", nativeQuery = true)
	public List<Product> findProudtsByUserId(@Param("id") Integer userId);

}
