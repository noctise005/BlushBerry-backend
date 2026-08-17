package com.blushberry.blushberry.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blushberry.blushberry.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}