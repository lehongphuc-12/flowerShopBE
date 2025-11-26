package com.phucle.flowerShopBE.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phucle.flowerShopBE.model.Voucher;

@Repository
public interface VoucherRepository extends JpaRepository<Voucher, Integer> {

}
