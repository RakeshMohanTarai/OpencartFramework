package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPageRegistration extends BasePage {

	public AccountPageRegistration (WebDriver driver) {
		
		super(driver);
		
	}
	
@FindBy(xpath="//input[@id='input-firstname']") WebElement firstName;
@FindBy(xpath="//input[@id='input-lastname']") WebElement lastName;
@FindBy(xpath="//input[@id='input-email']") WebElement email;
@FindBy(xpath="//input[@id='input-password']") WebElement password;
@FindBy(xpath="//input[@name='agree']") WebElement Agree;
@FindBy(xpath="//button[normalize-space()='Continue']") WebElement submit;
@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement msgConfirmation;


public void setFirstName(String fname) {
	firstName.sendKeys(fname);
}

public void setLastName(String lname) {
	lastName.sendKeys(lname);
}

public void setEmail(String sendemail) {
	email.sendKeys(sendemail);
}

public void setPassword(String pass) {
	password.sendKeys(pass);
}

public void clickAgree() {
	((JavascriptExecutor) driver).executeScript("arguments[0].click();", Agree);
}

public void clickSubmit() {
	((JavascriptExecutor) driver).executeScript("arguments[0].click();", submit);
}

public String getConfirmationMsg() {
	try {
		return (msgConfirmation.getText());
	}catch (Exception e) {
		return (e.getMessage());
	}
	
}



}
