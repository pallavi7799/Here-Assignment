package FlipkartBaseClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BaseClasses {
	
	protected static WebDriver driver;
	
	public void openbrowser() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Shivraj\\Desktop\\shiv\\chromedriver.exe");
		 driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
	}
	}
