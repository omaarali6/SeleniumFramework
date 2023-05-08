package tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pages.SearchPage;

public class SearchTest extends TestBase {

SearchPage SearchPage1;	
String SearchName = "Macbook";	
@Test(enabled=false)
public void TestSearch()
{
	SearchPage1 = new SearchPage(driver);
	SearchPage1.searchForProduct(SearchName);
	assertTrue(driver.findElements(By.cssSelector("h2.product-title")).size() != 0);
}

@Test
public void TestSearchAutoComplete() throws InterruptedException
{
	SearchPage1 = new SearchPage(driver);
	SearchPage1.SearchAutoComplete(SearchName);
	assertTrue(driver.findElements(By.cssSelector("div.product-name")).size() != 0);
}
	
}
