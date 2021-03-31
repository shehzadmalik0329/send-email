package com.xoriant.bsg.sendemail.model;

public class Trade {
	  
	  private String symbol;
	  private String quantity;
	  private String purchaseDate;
	  
	  public Trade() {
	  }
	  
	  public Trade(String symbol, String quantity, String purchaseDate) {
	    this.symbol = symbol;
	    this.quantity = quantity;
	    this.purchaseDate = purchaseDate;
	  }
	  
	  public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	@Override
	  public String toString() {
	    return "Trade [purchaseDate=" + purchaseDate + ", quantity=" + quantity + ", symbol=" + symbol + "]";
	  }
	}

