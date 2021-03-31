package com.xoriant.bsg.sendemail.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xoriant.bsg.sendemail.model.Car;
import com.xoriant.bsg.sendemail.model.Employee;
import com.xoriant.bsg.sendemail.model.StockData;
import com.xoriant.bsg.sendemail.model.Trade;

public class ReadJson {

	public static void main(String[] args) {
		File trades = new File("src/main/java/com/xoriant/bsg/sendemail/service/trades.json");
		parseJsonManually(trades);
		
		Date issueDate = new Date();
		
//		writeJson(new Car("MH041234", issueDate), new File("src/main/java/com/xoriant/bsg/sendemail/service/cars.json"));
		
//		parseCarJsonManually(new File("src/main/java/com/xoriant/bsg/sendemail/service/cars.json"));
		
		readStockData(new File("src/main/java/com/xoriant/bsg/sendemail/service/stock-data.json"));
		
		List<Trade> portfolioTrades = new ArrayList<>();
//		List<Trade> portfolioTrades2 = new Collection<>();
//		List<Object> portfolioTrades3 = new ArrayList<Trade>();
		List<? extends Object> portfolioTrades4 = new ArrayList<Trade>();
	}

	private static void parseJsonManually(File file){
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			Trade[] trades = objectMapper.readValue(file, Trade[].class);
			for(Trade trade: trades){
				System.out.println(trade);
			}
		} catch (Exception e) {
			e.printStackTrace();
		};
	}
	
	private static void writeJson(Object data, File outputFile){
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			objectMapper.writeValue(outputFile, data);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void parseCarJsonManually(File file){
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			Car car = objectMapper.readValue(file, Car.class);
//			for(Car car: cars){
				System.out.println(car);
//			}
		} catch (Exception e) {
			e.printStackTrace();
		};
	}
	
	private static void readStockData(File stockDataFile){
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			//Json to Object deserialize
			StockData[] stockData = mapper.readValue(stockDataFile, StockData[].class);
			
			//Object to Json serialize
			mapper.writeValue(new File("src/main/java/com/xoriant/bsg/sendemail/service/new-stock-data.json"), stockData);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void readEmployeeData(File file){
		ObjectMapper mapper = new ObjectMapper();
		try {
			Employee emp = mapper.readValue(file, Employee.class);
			Map<String, Employee> map = new HashMap<String, Employee>();
			String key = emp.getName() +"#"+ emp.getRole() +"#"+ emp.getCity();
			map.put(key, emp);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
