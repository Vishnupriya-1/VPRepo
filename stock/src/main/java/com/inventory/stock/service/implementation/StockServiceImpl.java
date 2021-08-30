package com.inventory.stock.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.stock.model.Stock;
import com.inventory.stock.repository.StockRepository;
import com.inventory.stock.service.StockService;

@Service
public class StockServiceImpl implements StockService{
	
	@Autowired
	private StockRepository stockRepository;
	
	@Override
	public Stock create(Stock stock)
	{
		if(stock.getStockNumber() == null)
		{
			return null;
		}
		stockRepository.save(stock);
		return stock;
	}
	
	@Override
	public Stock update(Stock stock)
	{
		Stock stockInfo = findByStockName(stock.getStockName());
		if(stockInfo == null)
		{
			return null;
		}
		stockRepository.save(stock);
		return stock;
	}
	
	@Override
	public Stock findByStockName(String stockName)
	{
		Stock stock = stockRepository.findByStockName(stockName);
		return stock;
	}
	
}
