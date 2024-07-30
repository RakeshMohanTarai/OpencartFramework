package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountPageRegistration;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test(groups={"Regression","Master"})	
	public void verify_account_registration() {
	logger.info("*** Starting TC001_AccountRegistrationTest ***");
	
	try
	{
	HomePage hp = new HomePage(driver);

	logger.info("*** Click on the My Account ***");
		hp.clickMyAccount();
		
	logger.info("*** Click on the Register ***");
		hp.clickRegister();
	
	AccountPageRegistration regpage = new AccountPageRegistration(driver);
	
	logger.info("*** Fill the details on the form ***");
	regpage.setFirstName(randomeString().toUpperCase());
	regpage.setLastName(randomeString().toUpperCase());
	regpage.setEmail(randomeString()+ "@gmail.com");
	
	String password = randomeNumber();
	regpage.setPassword(password);
	
	logger.info("*** Click on the Agree button ***");
	regpage.clickAgree();
	
	logger.info("*** Click on the Continue button ***");
	regpage.clickSubmit();
	
	logger.info("*** Validating Expected Message ***");
	String check = regpage.getConfirmationMsg();
	
	if(check.equals("Your Account Has Been Created!")) {
		Assert.assertTrue(true);
	}else {
		  logger.error("Test Failed...");	
		  logger.debug("Debug Logs...");
		  Assert.assertTrue(false);
	}
	
    // Assert.assertEquals(check, "Your Account Has Been Created!");
	
	} catch(Exception e) {
	  Assert.fail();
	 }
	logger.info("*** Finished TC001_AccountRegistrationTest ***");
   }
}
