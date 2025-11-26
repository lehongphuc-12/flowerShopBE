package com.phucle.flowerShopBE.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phucle.flowerShopBE.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
