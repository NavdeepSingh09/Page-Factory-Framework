package PageObject;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RegistrationForm {
	
	 final WebDriver driver;
		@FindBy(how=How.XPATH,using="//android.widget.EditText[@text='First Name']")
		public WebElement F_name_TextBox;
		
		@FindBy(how=How.XPATH,using="//android.widget.EditText[@text='Last Name']")
		public WebElement L_Name_TextBox;
		
		@FindBy(how=How.XPATH,using="//android.widget.EditText[@text='Email address']")
		public WebElement Email_TextBox;
		
		@FindBy(how=How.XPATH,using="//android.widget.EditText[@text='Password']")
		public WebElement Password_TextBox;
		
		@FindBy(how=How.XPATH,using="//android.widget.EditText[@text='Mobile number']")
		public WebElement M_No_TextBox;
		
		@FindBy(how=How.XPATH,using="//android.widget.Button[@index='8' and @text='Create your account']")
		public WebElement Create_Account_Button;
		
		@FindBy(how=How.XPATH,using="//android.widget.TextView[@text='Mandatory Field']")
		public List <WebElement> Alert1;
		
		@FindBy(how=How.XPATH,using="//android.widget.TextView[@text='Mandatory field']")
		public List<WebElement> Alert2;
		
		@FindBy(how=How.XPATH,using="//android.widget.TextView[@resource-id='com.compass_canada.thrive:id/toolbar_title']")
		public WebElement WelCome_Title;
		
		@FindBy(how=How.XPATH,using="//android.widget.ImageView[contains(@resource-id,'toolbar_back_button')]")
		public WebElement Close_Button;
		
		@FindBy(how=How.XPATH,using="//android.widget.TextView[@text='Please enter your profile info:']")
		public WebElement ProfileInfo_Title;
		
		@FindBy(how=How.XPATH,using="//android.widget.TextView[@text='(all text fields are mandatory)']")
		public WebElement Warning_Title;
		
		@FindBy(how=How.XPATH,using="//android.widget.TextView[@index='1' and @text='Subscribe to promotions']")
		public WebElement Subscribe_Text;
		
		@FindBy(how=How.CLASS_NAME,using="android.widget.CheckBox")
		public WebElement _CheckBox;
		
		@FindBy(how=How.XPATH,using="//android.widget.Button[@index='9']")
		public WebElement AlreadyAcc_SignIn_Button;
		
		@FindBy(how=How.XPATH,using="//android.widget.TextView[@text='Incorrect email format']")
		public WebElement Email_Alert;
		
		@FindBy(how=How.XPATH,using="//android.widget.TextView[@text='Minimum 8 characters, 1 capital letter and 1 number']")
		public WebElement Password_Alert;
		
		@FindBy(how=How.XPATH,using="//android.widget.TextView[@text='10 digit phone number required']")
		public WebElement Phone_Alert;
		
		File filename= new File(" Your Excel path here");
		
		
		public RegistrationForm(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		public String ExcelFirstName() throws Exception
		{
			FileInputStream LoadFile= new FileInputStream(filename);
			XSSFWorkbook wb=new XSSFWorkbook(LoadFile);
			XSSFSheet sh1= wb.getSheetAt(0);
			String FirstName= sh1.getRow(0).getCell(0).getStringCellValue();
			wb.close();
			return FirstName;
			
		}
		public String ExcelLastName() throws Exception
		{
			FileInputStream LoadFile= new FileInputStream(filename);
			XSSFWorkbook wb=new XSSFWorkbook(LoadFile);
			XSSFSheet sh1= wb.getSheetAt(0);
			String LastName= sh1.getRow(0).getCell(1).getStringCellValue();
			wb.close();
			return LastName;
			
		}

		public void RegForm(String FName,String LName,String EMail,String PassWord, String PH) throws Exception
		{
			
			this.setFirstName(FName);
			this.setLastName(LName);
			this.setEmailAddress(EMail);
			this.setPass(PassWord);
			this.setMobileNo(PH);
		}
			
		private void setMobileNo(String PH)
		{
			M_No_TextBox.sendKeys(PH);
		}

		private void setPass(String PassWord) 
		{
			Password_TextBox.sendKeys(PassWord);	
		}

		private void setEmailAddress(String EMail) 
		{
			Email_TextBox.sendKeys(EMail);	
		}

		private void setLastName(String LName)
		{
			L_Name_TextBox.sendKeys(LName);	
		}

		private void setFirstName(String FName) 
		{
			F_name_TextBox.sendKeys(FName);
			
		}
}
