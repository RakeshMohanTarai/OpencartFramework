package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDataDrivenTest extends BaseClass {

	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups="Datadriven")
	public void varify_LoginDDT(String email, String pass, String exp) {

		logger.info("*** Starting TC003_ TC003_LoginDataDrivenTest ***");

		try {
			// Home page
			HomePage hp = new HomePage(driver);
			logger.info("*** click on MyAccount ***");
			hp.clickMyAccount();
			logger.info("*** click on Login ***");
			hp.clickLogin();

			// Login Page
			LoginPage login = new LoginPage(driver);
			logger.info("*** set email on the login form ***");
			login.setEmail(email);
			logger.info("*** set password on the login form ***");
			login.setPassword(pass);
			logger.info("*** click on the login form submit button ***");
			login.clickLogin();

			// My Account
			MyAccountPage myacc = new MyAccountPage(driver);
			boolean targetPage = myacc.isMyAccountPageExists();

			/*
			 * Data is valid - login success - test pass - logout Data is valid -- login
			 * failed - test fail
			 * 
			 * Data is invalid - login success - test fail - logout Data is invalid -- login
			 * failed - test pass
			 */

			if (exp.equalsIgnoreCase("valid")) {
				if (targetPage == true) {
					Assert.assertTrue(true);
					myacc.clickLogout();
				} else {
					Assert.assertTrue(false);
				}
			}

			if (exp.equalsIgnoreCase("invalid")) {
				if (targetPage == true) {
					Assert.assertTrue(false);
					myacc.clickLogout();
				} else {
					Assert.assertTrue(true);
				}
			}
		} catch (Exception e) {
			Assert.fail();
		}

		logger.info("*** Finished TC003_ TC003_LoginDataDrivenTest ***");
		
	}
}
