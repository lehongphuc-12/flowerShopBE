package com.phucle.flowerShopBE.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phucle.flowerShopBE.model.FlowerType;

@Repository
public interface FlowerTypeRepository extends JpaRepository<FlowerType, Integer> {

}
