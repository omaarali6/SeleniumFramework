package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.HomePage;

public class TestCurrencyChange extends TestBase {
HomePage HomePage1;
	
@Test
public void testCurrChangeToEuro()
{
	HomePage1 = new HomePage(driver);
	HomePage1.ChangeCurrToEuro();
	assertTrue(HomePage1.FirstElementPrice.getText().contains("€"));
}
	
}
