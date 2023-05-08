package pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class PageBase {
	public JavascriptExecutor jes;
	public Actions action;

	//protected WebDriver driver;
	public PageBase(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public static void clickButton(WebElement Button)
	{
		Button.click();
	}
	public static void FillTextBox(WebElement TextBox, String s)
	{
		TextBox.sendKeys(s);
	}
	public void scrollToBottom()
	{
		jes.executeScript("scrollBy(0,2500)");
	}
	public void Hover(WebElement element)
	{
		action.moveToElement(element).build().perform();
	}
	public void hoverAndClick(WebElement element)
	{
		action.moveToElement(element).click().build().perform();
	}
}
