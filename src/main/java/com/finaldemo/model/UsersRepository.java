package com.finaldemo.model;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UsersRepository extends JpaRepository<Users, Integer> {
	//Users
	@Query(value = "select * from Users where email = :email and password = :password", nativeQuery = true) 
	public Users selectUserByNameAndPwd(@Param("email") String email, @Param("password") String password);
	
	@Query(value = "select * from Users where nickName like %:search%", nativeQuery = true) 
	public List<Users> searchPeopleByNickName(@Param("search") String search);
	
	
	
}
