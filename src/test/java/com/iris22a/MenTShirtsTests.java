package com.iris22a;

import org.testng.annotations.Test;

import com.iris22a.config.TestBase;
import com.iris22a.keywords.UIKeyword;
import com.iris22a.pages.HomePage;
import com.iris22a.pages.MenTShirtsPage;
import com.iris22a.util.Environment;
import com.iris22a.util.WaitFor;

/**
 * 
 * @author kiran
 *
 */
public class MenTShirtsTests {
	
	@Test
	public void verifyIfSearchByPopularityYeildsProperResults() {
		UIKeyword.launchUrl(Environment.URL);
		HomePage home = new HomePage();
		home.hoverOnMenMenu();
		WaitFor.elementToBeClickable(home.menTShirt);
		home.clickOnMenTShirt();
		MenTShirtsPage menTShirt = new MenTShirtsPage();
		WaitFor.elementToBeClickable(menTShirt.sortByFilter);
		menTShirt.selectPopularityFilter();
	}
	
	
}
