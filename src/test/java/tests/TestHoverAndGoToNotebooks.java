package tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.NotebooksPage;

public class TestHoverAndGoToNotebooks extends TestBase {
HomePage HomePage1;
NotebooksPage NotebooksPage1;	
@Test
public void testGoToNotebooks()
{
	HomePage1 = new HomePage(driver);
	HomePage1.GoToNotebooks();
	NotebooksPage1 = new NotebooksPage(driver);
	assertTrue(driver.findElements(By.cssSelector("div.page-title")).size()!=0);
}
}
