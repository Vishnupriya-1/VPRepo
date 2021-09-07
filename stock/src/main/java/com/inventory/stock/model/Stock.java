package com.inventory.stock.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "STOCK")
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="STOCKNUMBER")
	private Long stockNumber;
	
	@Column(name="STOCKNAME")
	private String stockName;
	
	@Column(name="PURCHASEPRICE")
	private int purchasePrice; 
	
	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name="PURCHASEDATE")
	private Date purchaseDate;
	
	@Column(name="QUANTITY")
	private int Quantity;

	public Long getStockNumber() {
		return stockNumber;
	}

	public void setStockNumber(Long stockNumber) {
		this.stockNumber = stockNumber;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public int getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(int purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public Stock(Long stockNumber, String stockName, int purchasePrice, Date purchaseDate, int quantity) {
		super();
		this.stockNumber = stockNumber;
		this.stockName = stockName;
		this.purchasePrice = purchasePrice;
		this.purchaseDate = purchaseDate;
		Quantity = quantity;
	}

	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Stock [stockNumber=" + stockNumber + ", stockName=" + stockName + ", purchasePrice=" + purchasePrice
				+ ", purchaseDate=" + purchaseDate + ", Quantity=" + Quantity + "]";
	}

}
