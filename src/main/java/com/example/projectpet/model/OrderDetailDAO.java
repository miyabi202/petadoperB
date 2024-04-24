package com.example.projectpet.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailDAO extends JpaRepository<OrderDetail, ODId> {

	List<OrderDetail> findByorderId(Order oId);

	OrderDetail findByOrderIdAndItemId(Order oId, Item iId);

}
