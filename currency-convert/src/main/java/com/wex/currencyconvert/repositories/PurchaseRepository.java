package com.wex.currencyconvert.repositories;

import com.wex.currencyconvert.domains.vos.models.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, String> {
}
