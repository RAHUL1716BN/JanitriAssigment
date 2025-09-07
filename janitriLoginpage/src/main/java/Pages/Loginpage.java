package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Base.base;

public class Loginpage extends base{
	
	  private WebDriver driver;
	  
	  private By userIdInput = By.xpath(OR.getProperty("userinput"));
	  private By passwordInput = By.xpath(OR.getProperty("password"));
	  private By loginbutton = By.xpath(OR.getProperty("loginbtn"));
	  private By passwordtoggle = By.xpath(OR.getProperty("passwordToggle"));
	  private By errormsg = By.xpath(OR.getProperty("errormsg"));
	  
	  public Loginpage(WebDriver driver) {
		  this.driver = driver;
	  }
	  
	  public WebElement getUserId() {
	        return driver.findElement(userIdInput);
	    }

	    public WebElement getPassword() {
	        return driver.findElement(passwordInput);
	    }

	    public WebElement getLoginButton() {
	        return driver.findElement(loginbutton);
	    }

	    public WebElement getPasswordToggle() {
	        return driver.findElement(passwordtoggle);
	    }

	    public WebElement getErrorMessage() {
	        return driver.findElement(errormsg);
	    }
	    
	    
	    
	    public void enterUserId(String userId) {
	        getUserId().sendKeys("rahulbn@7676");
	    }

	    public void enterPassword(String password) {
	        getPassword().sendKeys("password@123");
	    }

	    public void clickLogin() {
	        getLoginButton().click();
	        
	    }

	    public void clickPasswordToggle() {
	        getPasswordToggle().click();
	    }

	    
	    public boolean isLoginButtonDisabled() {
	        return !getLoginButton().isEnabled();
	    }

	    public boolean isPasswordMasked() {
	        String type = getPassword().getAttribute("type");
	        return type.equals("password");
	    }

	    public boolean isPasswordUnmasked() {
	    	 String type = getPassword().getAttribute("type");
		        return type.equals("text");
		    } 
	    
	    
	    public boolean isErrorMessageDisplayed() {
	        try {
	            return getErrorMessage().isDisplayed();
	        } catch (Exception e) {
	            return false;
	        }
	    }

	    public String getErrorMessageText() {
	        return getErrorMessage().getText();
	    }

	    public boolean isUserIdDisplayed() {
	        return getUserId().isDisplayed();
	    }

	    public boolean isPasswordDisplayed() {
	        return getPassword().isDisplayed();
	    }

	    public boolean isPasswordToggleDisplayed() {
	        return getPasswordToggle().isDisplayed();
	    }
}
