package tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import data.LoadProperties;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import utilities.Helper;

public class TestBase2 extends AbstractTestNGCucumberTests {

public static final String Username = LoadProperties.SauceData.getProperty("username");
public static final String AccessKey = LoadProperties.SauceData.getProperty("accesskey"); 
public static final String SeleniumURL = LoadProperties.SauceData.getProperty("url"); 

public static RemoteWebDriver driver;

@BeforeSuite
@Parameters({"Browser"})
public void startDriver(@Optional("chrome") String BrowserName) throws MalformedURLException
{
	//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "/Drivers/chromedriver.exe");
	//driver = new ChromeDriver();
	ChromeOptions browserOptions = new ChromeOptions();
	browserOptions.setPlatformName("Windows 11");
	browserOptions.setBrowserVersion("latest");
	Map<String, Object> sauceOptions = new HashMap<>();
	sauceOptions.put("username", Username.toString());
	sauceOptions.put("accessKey", AccessKey);
	sauceOptions.put("build", "selenium-build-436SY");
	sauceOptions.put("name", "<First Test>");
	browserOptions.setCapability("sauce:options", sauceOptions);
	URL url = new URL(SeleniumURL.toString());
	driver = new RemoteWebDriver(url, browserOptions);
	driver.navigate().to("https://demo.nopcommerce.com/");
}

@AfterMethod
public void takeScreenshotOnFail(ITestResult result)
{
	if (result.getStatus() == ITestResult.FAILURE) {
		System.out.println("Failure, Taking a screenshot.. ");
		Helper.captureScreenshot(driver, result.getName());
	}
}


@AfterSuite
public void stopDriver()
{
	driver.quit();
}
}
