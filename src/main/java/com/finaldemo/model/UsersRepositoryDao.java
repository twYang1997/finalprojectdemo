package com.finaldemo.model;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UsersRepositoryDao extends JpaRepository<Users, Integer> {

	public Users findFirstByOrderByAddedDesc();
}
