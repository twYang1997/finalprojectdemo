package com.finaldemo.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UsersRepository extends JpaRepository<Users, Integer> {
<<<<<<< HEAD
=======

	
	//Users
	@Query(value = "select * from Users where email = :email and password = :password", nativeQuery = true) 
	public Users selectUserByNameAndPwd(@Param("email") String email, @Param("password") String password);
	
	//Posts
	



>>>>>>> 1dd7fff4bf61e6d7b9815cf31d56b5e6251b565f
}
