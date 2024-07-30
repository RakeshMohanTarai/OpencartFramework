package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
      public LoginPage (WebDriver driver) {
    	  super(driver);
      }
      
@FindBy(xpath="//input[@id='input-email']") WebElement sendemail;
@FindBy(xpath="//input[@id='input-password']") WebElement sendpassword;
@FindBy(xpath="//button[normalize-space()='Login']") WebElement clicklogin;
 
public void setEmail(String email) {
	sendemail.sendKeys(email);
}

public void setPassword(String pass) {
	sendpassword.sendKeys(pass);
}

public void clickLogin() {
	clicklogin.click();
}
    
}
