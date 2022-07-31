package com.iris22a.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.iris22a.keywords.UIKeyword;

public class MenTShirtsPage {

	@FindBy(xpath = "//div[@class='sort-sortBy']")
	public WebElement sortByFilter;
	@FindBy(xpath = "//h4[contains(text(),'Country of Origin')]")
	public WebElement countryOfOrigin;
	@FindBy(xpath = "//div[@class='sort-sortBy']/span[contains(text(),'Popularity')]")
	public WebElement popularityFilter;
	
	
	public MenTShirtsPage() {
		PageFactory.initElements(UIKeyword.driver, this);
	}
	
	public void clickOnSortByFilter() {
		sortByFilter.click();
	}
	
	public void selectPopularityFilter() {
		UIKeyword.mouseMove(sortByFilter);
		UIKeyword.click(popularityFilter);
	}
	
	public void selectWhatsNewFilter() {

	}
	
	public void selectBetterDiscountFilter() {

	}
}
