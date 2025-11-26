package com.phucle.flowerShopBE.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phucle.flowerShopBE.model.Flower;

@Repository
public interface FlowerRepository extends JpaRepository<Flower, Integer> {

}
