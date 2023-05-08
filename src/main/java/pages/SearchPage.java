package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase {

	public SearchPage(WebDriver driver) {
		super(driver);
	}

@FindBy(id = "small-searchterms")
WebElement SearchTextBox;

@FindBy(css = "button.button-1.search-box-button")
WebElement SearchBtn;

@FindBy(id = "ui-id-1")
List<WebElement> ProductList;

public void searchForProduct(String Name)
{
	FillTextBox(SearchTextBox, Name);
	clickButton(SearchBtn);
}

public void SearchAutoComplete(String Name) throws InterruptedException
{
	FillTextBox(SearchTextBox, Name);
	Thread.sleep(3000);
	ProductList.get(0).click();
}



}
