package com.blushberry.blushberry.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blushberry.blushberry.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}