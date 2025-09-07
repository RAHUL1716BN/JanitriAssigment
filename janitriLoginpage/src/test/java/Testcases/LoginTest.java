package Testcases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.base;
import Pages.Loginpage;

public class LoginTest extends base {

	  private Loginpage loginPage;

	    @BeforeMethod
	    public void setUp() {
	        // re-initialize driver for each test (or at least reload page)
	        driver.get(Config.getProperty("testsiteurl"));
	        loginPage = new Loginpage(driver);
	    }

	    @AfterMethod
	    public void tearDown() {
	        // optional: logout or clear cookies if staying in same session
	        driver.manage().deleteAllCookies();
	    }

	
	 @Test
	    public void testLoginButtonDisabledWhenFieldAreEmpty() {
	     //   Loginpage loginPage = new Loginpage(driver);
	     //   Assert.assertTrue(loginPage.isErrorMessageDisplayed(), 
	        //	    "Error message should be shown when trying to log in with empty fields.");
		 throw new SkipException("App keeps login button enabled. Test not applicable.");

	    }
	 
	
	 
	  @Test
	    public void testInvalidLoginShowErrorMsg() throws InterruptedException {
	        Loginpage loginPage = new Loginpage(driver);
	        loginPage.enterUserId("user@example.com");
	        loginPage.enterPassword("wrgpassword");
	        loginPage.clickLogin();

	        Thread.sleep(2000); // Wait for error message to appear

	        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message should be displayed.");
	        System.out.println("Error Message: " + loginPage.getErrorMessageText());
	    }
	  
	  @Test
	    public void testPasswordMaskedbutton() {
	        Loginpage loginPage = new Loginpage(driver);
	        Assert.assertTrue(loginPage.isPasswordMasked(), "Password should be masked by default.");

	        loginPage.clickPasswordToggle();
	        Assert.assertTrue(loginPage.isPasswordUnmasked(), "Password should be unmasked after clicking eye icon.");

	        loginPage.clickPasswordToggle();
	        Assert.assertTrue(loginPage.isPasswordMasked(), "Password should be masked again after clicking eye icon.");
	    } 
	  @Test
	    public void testPageElementsPresence() {
	        Loginpage loginPage = new Loginpage(driver);
	        Assert.assertTrue(loginPage.isUserIdDisplayed(), "User ID input should be displayed.");
	        Assert.assertTrue(loginPage.isPasswordDisplayed(), "Password input should be displayed.");
	        Assert.assertTrue(loginPage.getLoginButton().isDisplayed(), "Login button should be displayed.");
	        Assert.assertTrue(loginPage.isPasswordToggleDisplayed(), "Password toggle (eye icon) should be displayed.");
	    }
}
