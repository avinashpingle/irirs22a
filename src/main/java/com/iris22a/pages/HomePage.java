package com.iris22a.pages;


import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.iris22a.keywords.UIKeyword;

public class HomePage {
	private static final Logger log = Logger.getLogger(HomePage.class);
	
	//PageFactory
	@FindBy(xpath = "//div[@class='desktop-navLink']/a[@href=\"/shop/men\"]")
	public WebElement menMenu;
	
	@FindBy(xpath = "//a[@href=\"/men-tshirts\"]")
	public WebElement menTShirt;

	@FindBy(xpath = "(//li[@class='desktop-oddColumnContent'])[1]/descendant::a[contains(text(),'Casual')]")
	public WebElement casualShirts;
	
	@FindBy(css = "div.desktop-query>input.desktop-searchBar")
	public WebElement searchComponent;
	
	@FindBy(css= "h3.product-brand")
	public List<WebElement> productTexts;
	
	public HomePage() {
		PageFactory.initElements(UIKeyword.driver, this);
	}
	
	public void hoverOnMenMenu() {
		UIKeyword.mouseMove(menMenu);
	}
	
	public void clickOnMenTShirt() {
		UIKeyword.click(menTShirt);
	}

	public void searchProduct(String productName) {
		UIKeyword.enterText(searchComponent, productName+Keys.ENTER);
	}
	public void clickOnCasualShirts() {
		casualShirts.click();
		log.info("Clicked on Casual Shirts");
	}
	
	public List<String> getSearchResultTexts() {
		List<String> productTexts = new ArrayList<String>();
		
		for (WebElement product : this.productTexts) {
			productTexts.add(product.getText());
		}
		
		return productTexts;
	}
	
}
