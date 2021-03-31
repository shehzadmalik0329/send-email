package com.xoriant.bsg.sendemail.model;

public class StockData {
	
	private String date;
	
	private double close;
	
	private double high;
	
	private double low;
	
	private double open;
	
	private long volume;
	
	private double adjClose;
	
	private double adjHigh;
	
	private double adjLow;
	
	private double adjOpen;
	
	private long adjVolume;
	
	private double divCash;
	
	private double splitFactor;

	public StockData() {
	}

	public StockData(String date, double close, double high, double low, double open, long volume, double adjClose,
			double adjHigh, double adjLow, double adjOpen, long adjVolume, double divCash, double splitFactor) {
		this.date = date;
		this.close = close;
		this.high = high;
		this.low = low;
		this.open = open;
		this.volume = volume;
		this.adjClose = adjClose;
		this.adjHigh = adjHigh;
		this.adjLow = adjLow;
		this.adjOpen = adjOpen;
		this.adjVolume = adjVolume;
		this.divCash = divCash;
		this.splitFactor = splitFactor;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getClose() {
		return close;
	}

	public void setClose(double close) {
		this.close = close;
	}

	public double getHigh() {
		return high;
	}

	public void setHigh(double high) {
		this.high = high;
	}

	public double getLow() {
		return low;
	}

	public void setLow(double low) {
		this.low = low;
	}

	public double getOpen() {
		return open;
	}

	public void setOpen(double open) {
		this.open = open;
	}

	public long getVolume() {
		return volume;
	}

	public void setVolume(long volume) {
		this.volume = volume;
	}

	public double getAdjClose() {
		return adjClose;
	}

	public void setAdjClose(double adjClose) {
		this.adjClose = adjClose;
	}

	public double getAdjHigh() {
		return adjHigh;
	}

	public void setAdjHigh(double adjHigh) {
		this.adjHigh = adjHigh;
	}

	public double getAdjLow() {
		return adjLow;
	}

	public void setAdjLow(double adjLow) {
		this.adjLow = adjLow;
	}

	public double getAdjOpen() {
		return adjOpen;
	}

	public void setAdjOpen(double adjOpen) {
		this.adjOpen = adjOpen;
	}

	public long getAdjVolume() {
		return adjVolume;
	}

	public void setAdjVolume(long adjVolume) {
		this.adjVolume = adjVolume;
	}

	public double getDivCash() {
		return divCash;
	}

	public void setDivCash(double divCash) {
		this.divCash = divCash;
	}

	public double getSplitFactor() {
		return splitFactor;
	}

	public void setSplitFactor(double splitFactor) {
		this.splitFactor = splitFactor;
	}

	@Override
	public String toString() {
		return "StockData [date=" + date + ", close=" + close + ", high=" + high + ", low=" + low + ", open=" + open
				+ ", volume=" + volume + ", adjClose=" + adjClose + ", adjHigh=" + adjHigh + ", adjLow=" + adjLow
				+ ", adjOpen=" + adjOpen + ", adjVolume=" + adjVolume + ", divCash=" + divCash + ", splitFactor="
				+ splitFactor + "]";
	}
	
}
