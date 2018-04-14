package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GetStartHomePage {
	final WebDriver driver;
	@FindBy(how=How.ID,using="com.compass_canada.thrive:id/login_getStarted")
	 public WebElement ClickOnGetStarted;
	
	public GetStartHomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	

}
