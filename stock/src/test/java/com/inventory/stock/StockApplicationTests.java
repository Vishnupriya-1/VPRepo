package com.inventory.stock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.inventory.stock.model.Stock;
import com.inventory.stock.repository.StockRepository;
import com.inventory.stock.service.StockService;

@SpringBootTest
class StockApplicationTests {
	
	@Autowired
	private StockService stockService;
	
	@Autowired
	private StockRepository stockRepo;

	/*
	 * Test method to create Stock
	 */
	@Test
	public void testCreateStock() {
		Stock stock = new Stock(14L,"stock20",190,new Date(),90);
		stockService.create(stock);

		assertNotNull(stockService.findByStockName("stock20"));
	}
	
	/*
	 * Test method to get all Stock
	 */
	@Test
	public void testGetAllStock()
	{
		List<Stock> stockList = stockRepo.findAll();
		assertThat(stockList).size().isGreaterThan(0);
	}
	
	/*
	 * Test method to update Stock
	 */
	@Test
	public void testUpdateStock()
	{
		Stock stock = stockService.findByStockName("stock9");
		stock.setQuantity(4);
		stockService.update(stock);
		assertNotEquals(4, stockService.findByStockName("stock9").getQuantity());
		assertEquals(10, stockService.findByStockName("stock9").getQuantity());
	}
}

