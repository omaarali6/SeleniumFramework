package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import utilities.Helper;

public class TestBase extends AbstractTestNGCucumberTests {
public static WebDriver driver;

@SuppressWarnings("deprecation")
@BeforeSuite
@Parameters({"Browser"})
public void startDriver(@Optional("chrome") String BrowserName)
{
	if (BrowserName.equalsIgnoreCase("chrome"))
	{
	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "/Drivers/chromedriver.exe");
	driver = new ChromeDriver();
	} else if (BrowserName.equalsIgnoreCase("firefox"))
	{
		//System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+ "/Drivers/geckodriver.exe");
		driver = new FirefoxDriver();
	} else if (BrowserName.equalsIgnoreCase("headless"))
	{
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setJavascriptEnabled(true);
		caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, 
				"C://Users//Lenovo//Documents//Eclipse_Github_Clonetest//SeleniumFramework//Drivers//phantomjs.exe");
		String [] PhantomArgs = {"--web-security=no","--ignore-ssl-errors=yes"};
		caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, PhantomArgs);
		driver = new PhantomJSDriver(caps);
	} else if (BrowserName.equalsIgnoreCase("headless-chrome"))
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "/Drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		options.addArguments("--window-size=1920x1080");
		driver = new ChromeDriver(options);
	}
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
