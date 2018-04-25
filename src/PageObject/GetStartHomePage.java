package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class GetStartHomePage {
	final WebDriver driver;
	@FindBy(how=How.XPATH,using="//android.widget.Button[@text='Get started']")

	
  public WebElement ClickOnGetStarted;
	
	protected GetStartHomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	

}
