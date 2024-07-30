package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {

	@Test(groups={"Sanity", "Master"})
	public void account_login() {
		logger.info("*** Starting TC002_AccountLoginTest ***");

		try {
			//Home page
			HomePage hp = new HomePage(driver);		
			logger.info("*** click on MyAccount ***");
			hp.clickMyAccount();
			logger.info("*** click on Login ***");
			hp.clickLogin();

			//Login Page
			LoginPage login = new LoginPage(driver);
			logger.info("*** set email on the login form ***");
			login.setEmail(p.getProperty("email"));
			logger.info("*** set password on the login form ***");
			login.setPassword(p.getProperty("password"));
			logger.info("*** click on the login form submit button ***");
			login.clickLogin();
			
			//My Account
            MyAccountPage myacc = new MyAccountPage(driver);
            boolean targetPage = myacc.isMyAccountPageExists();
			
            Assert.assertTrue(targetPage);		
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("*** Finished TC002_LoginPageTest ***");
	}
}
