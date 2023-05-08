package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
		jes = (JavascriptExecutor) driver;
		action = new Actions(driver);
	}

@FindBy(linkText = "Register")
WebElement Registerlink;

@FindBy(linkText = "Log in")
WebElement Loginlink;

@FindBy(linkText = "Log out")
WebElement LogOutLink;

@FindBy(linkText = "My account")
WebElement MyAccountLink;

@FindBy(linkText = "Contact us")
WebElement ContactUs;

@FindBy(id = "customerCurrency")
WebElement CurrencyList;

@FindBy(css = "span.price.actual-price")
public WebElement FirstElementPrice;

@FindBy(linkText = "Computers")
WebElement ComputersMenu;

@FindBy(linkText = "Notebooks")
WebElement NotebooksMenu;


public void ChangeCurrToEuro()
{
	Select sel = new Select(CurrencyList);
	sel.selectByVisibleText("Euro");
}

public void openRegisterationPage()
{
	clickButton(Registerlink);
}

public void openLoginPage()
{
	clickButton(Loginlink);
}

public void logOut()
{
	clickButton(LogOutLink);
}

public void openMyAccount()
{
	clickButton(MyAccountLink);
}

public void openContactUsPage()
{
	scrollToBottom();
	clickButton(ContactUs);
}

public void GoToNotebooks()
{
	Hover(ComputersMenu);
	hoverAndClick(NotebooksMenu);
}

}
