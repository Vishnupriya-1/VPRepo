package com.inventory.stock.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.stock.model.Stock;
import com.inventory.stock.repository.StockRepository;
import com.inventory.stock.service.StockService;


@RestController
@RequestMapping("api/stock")
public class StockController {
	
	@Autowired
	private StockRepository stockRepository;
	
	@Autowired
	private StockService stockService;
	
	/**
	 * Get all stock details.
	 * 
	 * @return all stock info in the system
	 */
	@RequestMapping(method=RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getStockdetails(){
		System.out.println("Listing all the stock details");
		return new ResponseEntity<>(stockRepository.findAll(),HttpStatus.OK);
		
	}
	
	/**
	 * Create stock with the provided info.
	 * 
	 * @return create stock in the system
	 */
	@RequestMapping(method=RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Stock> createStock(@RequestBody Stock stock){
		
		System.out.println("Creating Stock");
		stock = stockService.create(stock);
		return new ResponseEntity<Stock>(stock,HttpStatus.CREATED);
		
	}
	
	/**
	 * Updated stock with the provided new info.
	 * 
	 * @return update stock in the system
	 */
	
	@RequestMapping(value="/{id}",method=RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Stock> updateStock(@RequestBody Stock stock){
		
		System.out.println("Updating Stock details for the given id");
		stock = stockService.update(stock);
		if(stock == null)
		{
			return new ResponseEntity<Stock>(HttpStatus.FORBIDDEN);
		}
		return new ResponseEntity<Stock>(stock,HttpStatus.OK);
		
	}
}

