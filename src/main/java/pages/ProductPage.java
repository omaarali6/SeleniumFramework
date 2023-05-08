package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends PageBase {

	public ProductPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

@FindBy(id = "add-to-cart-button-4")
WebElement AddToCartBtn;

@FindBy(css = "span.cart-label")
WebElement WishListLink;

public void addToCart()
{
	clickButton(AddToCartBtn);
}

public void goToCart()
{
	clickButton(WishListLink);
}
	
}
