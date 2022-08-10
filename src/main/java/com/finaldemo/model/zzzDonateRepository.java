package com.finaldemo.model;

import org.springframework.data.jpa.repository.JpaRepository;


public interface zzzDonateRepository extends JpaRepository<Donate, Integer> {
	public Donate findFirstByOrderByDonateDateDesc();

}
