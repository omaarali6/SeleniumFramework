package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase{

	public LoginPage(WebDriver driver) {
		super(driver);
	}

@FindBy(id="Email")
WebElement EmailTextBox;

@FindBy(id="Password")
WebElement PassTextBox;

@FindBy(css="button.button-1.login-button")
WebElement LoginButton;


public void login(String Email, String Password)
{
	FillTextBox(EmailTextBox, Email);
	FillTextBox(PassTextBox, Password);
	clickButton(LoginButton);
}
	
}
