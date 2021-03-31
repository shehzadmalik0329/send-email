package com.xoriant.bsg.sendemail.service;

import java.util.ArrayList;

import java.util.LinkedList;

import java.util.Arrays;

import java.util.IntSummaryStatistics;

import java.util.List;

import java.util.Random;

import java.util.stream.Collectors;

public class MyClass {


   public static void main(String args[]) {

      

      //print ten random numbers

      Random random = new Random();

	  for(int i = 0; i < 10; i++) {

         System.out.println(random.nextInt());

      }

      List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");

      

      System.out.println("List: " +strings);

		

      long count = strings.stream().filter(string->string.isEmpty()).count();

      System.out.println("Empty Strings: " + count);

	

      List<String> filtered = strings.stream().filter(string ->!string.isEmpty()).collect(Collectors.toList());

      System.out.println("Filtered List: " + filtered);

		

      String mergedString = strings.stream().filter(string ->!string.isEmpty()).collect(Collectors.joining(", "));

      System.out.println("Merged String: " + mergedString);

}	

}
