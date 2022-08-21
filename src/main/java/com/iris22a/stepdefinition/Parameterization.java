package com.iris22a.stepdefinition;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Parameterization {
	int x, y, r = 0;
	float f, g;
	String fruitName;

	@Given("I have two numbers {short} and {short}")
	public void acceptTwoNumbers(short x, short y) {
		this.x = x;
		this.y = y;
	}

	@When("I add them")
	public void addNumbers() {
		this.r = x + y;
	}

	@Then("Print the result")
	public void displayResult() {
		System.out.println("Result: " + r);
	}

	@Given("I have two float numbers {float} and {float}")
	public void acceptTwoFloats(float x, float y) {
		f = x;
		g = y;
	}

	@Then("Display numbers")
	public void display() {
		System.out.println(f + "\t" + g);
	}

	@Given("I have a fruite {string}")
	public void acceptFruite(String fruit) {
		fruitName = fruit;
	}

	@Then("Display its {string}")
	public void displayColor(String color) {
		System.out.println(fruitName + " is " + color);
	}

	@Given("I have following <states>")
	public void acceptCities(DataTable states) {
		System.out.println("==========STATES===========");
		Map<String, List> statDetails = states.asMap(String.class, List.class);
		Set<Map.Entry<String, List>> entries = statDetails.entrySet();

		for (Entry<String, List> entry : entries) {
			List<String> data = entry.getValue();
			System.out.println(entry.getKey() + "\t" + data.get(0) + "\t" + data.get(1));
		}
	}

	@Given("I have {int} and {int}")
	public void acceptNumbers(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Then("print if their addition is prime")
	public void isPrime() {
		System.out.println("Checking: " + r);
		int count = 0;
		for (int i = 1; i < r; i++) {
			if (r % i == 0) {
				count++;
			}

			if (count > 2) {
				break;
			}
		}

		if (count <= 2) {
			System.out.println("Number " + r + "is prime");
		} else {
			System.out.println("Number " + r + " is NOT primea");
		}
	}

	@Given("I have {int}")
	public void getRowNumber(int rowNum) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("/Users/avinashpingale/Documents/Iris22A/Numbers.xlsx");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		XSSFWorkbook book = null;
		try {
			book = new XSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFSheet sheet = book.getSheetAt(0);

		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(1);
		x = (int) cell.getNumericCellValue();
		cell = row.getCell(2);
		y = (int) cell.getNumericCellValue();

	}

}
