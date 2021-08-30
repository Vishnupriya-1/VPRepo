package com.inventory.stock.service;

import com.inventory.stock.model.Stock;

public interface StockService {
	
	public Stock create(Stock stock);
	
	public Stock update(Stock stock);
	
	public Stock findByStockName(String stockName);

}
