package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterationPage extends PageBase {



public RegisterationPage(WebDriver driver) {
		super(driver);
	}


@FindBy(id = "gender-male")
WebElement GenderRadioBtn;

@FindBy(id = "FirstName")
WebElement FNameTxtBox;

@FindBy(id = "LastName")
WebElement LNameTxtBox;

@FindBy(id = "Email")
WebElement EmailTxtBox;

@FindBy(id = "Password")
WebElement PasswordTxtBox;

@FindBy(id = "ConfirmPassword")
WebElement ConfirmPasswordTxtBox;

@FindBy(id = "register-button")
WebElement RegButton;

@FindBy(css = "div.result")
public WebElement RegisterResult;



public void register(String FirstName,String LastName, String Email, String Password, String ConfirmPassword)
{
	clickButton(GenderRadioBtn);
	FillTextBox(FNameTxtBox, FirstName);
	FillTextBox(LNameTxtBox, LastName);
	FillTextBox(EmailTxtBox, Email);
	FillTextBox(PasswordTxtBox, Password);
	FillTextBox(ConfirmPasswordTxtBox, ConfirmPassword);
	clickButton(RegButton);
}



}
