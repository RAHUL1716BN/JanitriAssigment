package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;



public class base {

	public static WebDriver driver;
	public static Properties Config = new Properties();
	public static Properties OR = new Properties();
	public static  FileInputStream fis;
	public static WebDriverWait wait;
	public static String browser;
	
	public   base() {
	if(driver==null) {
		
		
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Config.load(fis);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			OR.load(fis);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		 if (System.getenv("browser") != null && !System.getenv("browser").isEmpty()) {
	            browser = System.getenv("browser");
	         } else {
	            browser = Config.getProperty("browser");
	         }
		
		Config.setProperty("browser", browser);
		
		if(Config.getProperty("browser").equals("firefox")) {
			//	System.out.println();
				driver = new FirefoxDriver();
				
			}else if(Config.getProperty("browser").equals("chrome")) {
			//  System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chrome.exe");
		
		
	System.getProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\excutables\\chromedriver.exe");
	
	Map<String, Object> prefs = new HashMap<String,Object>();
	prefs.put("profile.default_content_setting_values.notifications", 1);
	prefs.put("credentials_enable_service", false);
	prefs.put("profile.password_manager_enabled", false);
	ChromeOptions options = new ChromeOptions();
	options.setExperimentalOption("prefs", prefs);
	options.addArguments("--disable-extensions");
	options.addArguments("--disable-infobars");
	driver =  new ChromeDriver(options);
	
			}	else if(Config.getProperty("browser").equals("ie")) {
				  System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\excutables\\IEDriverServer.exe");
					driver = new InternetExplorerDriver();
		}
	 
		driver.get(Config.getProperty("testsiteurl"));

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(Config.getProperty("implicit.wait"))));

	wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
 

	}
	 
}
	public static void quitDriver() {
		// TODO Auto-generated method stub
	   
            driver.quit();
           
	    }
}

