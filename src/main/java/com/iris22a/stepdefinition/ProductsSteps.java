package com.iris22a.stepdefinition;

import java.util.List;
import org.testng.Assert;
import com.iris22a.keywords.UIKeyword;
import com.iris22a.pages.HomePage;
import com.iris22a.pages.MenTShirtsPage;
import com.iris22a.util.Environment;
import com.iris22a.util.WaitFor;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductsSteps {

	@And("मिंत्रा का पेज खुला होना चाहिए")
	public void launchMyntraUrl() {
		UIKeyword.launchUrl(Environment.URL);
	}
	
	@When("user searches for polo t shirt")
	public void searchPoloTShirts() {
		HomePage home = new HomePage();
		home.searchProduct("Polo");
	}

	@When("user searches for product {string}")
	public void searchProduct(String productName) {
		HomePage home = new HomePage();
		home.searchProduct(productName);
	}
	@Then("all results should be related to polo")
	public void verifyAllResults() {
		HomePage home = new HomePage();
		List<String> productTexts = home.getSearchResultTexts();
		for (String text : productTexts) {
			Assert.assertTrue(text.toLowerCase().contains("polo"),"Product is mismatch: "+text);
		}
	}
	
	@When("user hovers on men menue")
	public void hoverOnMenMenu() {
		HomePage home = new HomePage();
		home.hoverOnMenMenu();
	}
	
	@And("user clicks on men t-shirt")
	public void clickOnMenTShirt() {
		HomePage home = new HomePage();
		WaitFor.elementToBeClickable(home.menTShirt);
		home.clickOnMenTShirt();
	}
	
	@Then("user selects popularity filter")
	public void selectPopularityFilter() {
		MenTShirtsPage menTShirt = new MenTShirtsPage();
		WaitFor.elementToBeClickable(menTShirt.sortByFilter);
		menTShirt.selectPopularityFilter();
	}
}
