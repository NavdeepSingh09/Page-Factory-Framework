package AutomationFrameworkMain;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import PageObject.GetStartHomePage;
import PageObject.RegistrationForm;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class TestCaseMain {
	
	static WebDriver driver;
	GetStartHomePage objHomePage;
	RegistrationForm objRegForm;
	String userName = " ";//Your UserName of BrowserStack
	String accessKey = " ";//Your access Key of BrowserStack
	String AppURL= " ";//App URL 
	
	@BeforeSuite
	public void setupMyAppium() throws Exception
	{
	    DesiredCapabilities caps = new DesiredCapabilities();
	    caps.setCapability("os", "android");
	    caps.setCapability("os_version", "7.0"); 
	    caps.setCapability("device", "Samsung Galaxy S8");
	    caps.setCapability("realMobile", true);
	    caps.setCapability("browserstack.debug", "true");
	    caps.setCapability("project","Test App");
		caps.setCapability("build", "Factory");
        caps.setCapability("name", "Thrive Factory Method");
	    caps.setCapability("browserstack.video", "true");
	    caps.setCapability("browserstack.timezone", "Toronto");
	    caps.setCapability("app", AppURL);
	    driver = new AndroidDriver <AndroidElement> (new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), caps);		
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    objHomePage= PageFactory.initElements(driver, GetStartHomePage.class);
	    objRegForm= PageFactory.initElements(driver, RegistrationForm.class);
	}
	
	@AfterSuite
	public void quit()
	{
		driver.quit();
	}
	
	@Test(priority=0)
	public void GetStart()
	{
		String TEXT=objHomePage.ClickOnGetStarted.getText();
		Assert.assertEquals(TEXT, "Get started");
		objHomePage.ClickOnGetStarted.click();
	}
	@Test(priority=1)
	public void RegForm() throws Exception
	{
		boolean value= objRegForm.Close_Button.isDisplayed();
		Assert.assertEquals(value, true);
		
		String T1=objRegForm.WelCome_Title.getText();
		Assert.assertEquals(T1, "Welcome to Thrive!");
		
		String T2=objRegForm.ProfileInfo_Title.getText();
		Assert.assertEquals(T2, "Please enter your profile info:");
		
		String T3=objRegForm.Warning_Title.getText();
		Assert.assertEquals(T3, "(all text fields are mandatory)");
		
		boolean value1=objRegForm._CheckBox.isDisplayed();
		Assert.assertEquals(value1,true);
		
		String T4=objRegForm.AlreadyAcc_SignIn_Button.getText();
		Assert.assertEquals(T4, "Already have an account? Sign in");
		
		objRegForm.Create_Account_Button.click();
		
		String AlertMadField1=objRegForm.Alert1.get(0).getText();
		Assert.assertEquals(AlertMadField1, "Mandatory Field");
		
		String AlertMadField2=objRegForm.Alert1.get(1).getText();
		Assert.assertEquals(AlertMadField2, "Mandatory Field");
		
		String AlertMadField3=objRegForm.Alert2.get(0).getText();
		Assert.assertEquals(AlertMadField3, "Mandatory field");
		
		String AlertMadField4=objRegForm.Alert2.get(1).getText();
		Assert.assertEquals(AlertMadField4, "Mandatory field");
		
		String AlertMadField5=objRegForm.Alert2.get(2).getText();
		Assert.assertEquals(AlertMadField5, "Mandatory field");
		
		objRegForm.RegForm(objRegForm.ExcelFirstName(), objRegForm.ExcelLastName(), "abc@mailinator", "abcd123", "1234");
		
		objRegForm.Create_Account_Button.click();
		
		String T5=objRegForm.Email_Alert.getText();
		Assert.assertEquals(T5,"Incorrect email format");
		
		String T6=objRegForm.Password_Alert.getText();
		Assert.assertEquals(T6,"Minimum 8 characters, 1 capital letter and 1 number");
		
		String T7=objRegForm.Phone_Alert.getText();
		Assert.assertEquals(T7,"10 digit phone number required");
		
	}
}
