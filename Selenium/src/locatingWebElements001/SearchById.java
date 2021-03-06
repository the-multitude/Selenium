package locatingWebElements001;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class SearchById {
	
	static final String chromeDriver = "C:\\Users\\Madhan\\git\\Selenium\\Selenium\\Google Chrome Driver\\";
	//static final String geckoDriver = "C:\\Users\\Madhan\\git\\Selenium\\Selenium\\Mozilla GeckoDriver\\"; // For Fire fox browser
	static WebDriver driver;
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", chromeDriver+"chromedriver.exe");
		driver = new ChromeDriver();
		// For Fire fox browser
		// System.setProperty("webdriver.gecko.driver", geckoDriver+"geckodriver.exe");
		
		driver.get("http://book.theautomatedtester.co.uk/chapter2");
		WebElement buttonWithID = driver.findElement(By.id("but1"));
		buttonWithID.click();
		
		System.out.println("Done");
		
		driver.quit();
		
	}
}
