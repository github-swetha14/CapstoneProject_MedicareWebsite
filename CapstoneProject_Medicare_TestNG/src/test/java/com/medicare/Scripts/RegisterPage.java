package com.medicare.Scripts;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class RegisterPage extends TestBase{
		
		@FindBy(xpath="//input[@id='name']")
		WebElement registername;
		
		@FindBy(xpath="//input[@id='email']")
		WebElement registeremail;
		
		@FindBy(xpath="//input[@id='password']")
		WebElement registerpassword;
		
		@FindBy(xpath="//button[@type='submit']")
		WebElement registerBtn;
		
		@FindBy(xpath="/html/body/div[2]/div/p[3]")
		WebElement userText;
		
		
		public RegisterPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
			
		}
		
		public void register_user() throws InterruptedException
		{
			registername.sendKeys("user");
			registeremail.sendKeys("user@medicare.com");
			registerpassword.sendKeys("12345");
			Thread.sleep(5000);
			registerBtn.click();
		}
		
		public String validate_registration_URL()
		{
			String register_url = driver.getCurrentUrl();
			return register_url;
		}
		
		public String validate_registration_Text()
		{
			String user_name = userText.getText();
			return user_name;
		}
		

}
