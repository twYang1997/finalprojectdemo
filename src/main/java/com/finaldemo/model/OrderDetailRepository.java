package com.finaldemo.model;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {

}
