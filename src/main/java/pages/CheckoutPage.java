package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends PageBase {

	public CheckoutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

@FindBy(css = "button.remove-btn")
WebElement RemoveBtn;


@FindBy(id = "itemquantity11222")
WebElement QtyTextBox;

public void changeQuantity(String s)
{
	QtyTextBox.sendKeys(s);
}
	
}
