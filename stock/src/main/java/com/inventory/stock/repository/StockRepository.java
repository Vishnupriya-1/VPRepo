package com.inventory.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.inventory.stock.model.Stock;

public interface StockRepository extends JpaRepository<Stock, Long>{	
	
	Stock findByStockName(@Param("stockName") String stockName);

}
