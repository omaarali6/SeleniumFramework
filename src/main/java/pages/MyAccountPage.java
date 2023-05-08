package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

@FindBy(linkText = "Change password")
WebElement ChangePasswordLink;

@FindBy(id = "OldPassword")
WebElement OldPasswordTxtBox;

@FindBy(id = "NewPassword")
WebElement NewPasswordTxtBox;

@FindBy(id = "ConfirmNewPassword")
WebElement CnfrmNewPasswordTxtBox;

@FindBy(css = "button.button-1.change-password-button")
WebElement ChngPasswordBtn;

@FindBy(css = "p.content")
public WebElement ChngPasswordResult;

@FindBy(css = "span.close")
WebElement DismissMsgBtn;

@FindBy(linkText = "Log out")
public WebElement LogOutLink;

public void goToChangePassword()
{
	clickButton(ChangePasswordLink);
}
	
public void changePassword(String OldPassword,String NewPassword)
{
	FillTextBox(OldPasswordTxtBox, OldPassword);
	FillTextBox(NewPasswordTxtBox, NewPassword);
	FillTextBox(CnfrmNewPasswordTxtBox, NewPassword);
	clickButton(ChngPasswordBtn);
}

public void dismissMsg()
{
	clickButton(DismissMsgBtn);
}

public void logOut()
{
	clickButton(LogOutLink);
}
}
