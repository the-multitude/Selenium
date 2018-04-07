package actionsOnWebElements002;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class isSelected {
	
	static final String chromeDriver = "C:\\Users\\Madhan\\git\\Selenium\\Selenium\\Google Chrome Driver\\";
	//static final String geckoDriver = "C:\\Users\\Madhan\\git\\Selenium\\Selenium\\Mozilla GeckoDriver\\"; // For Fire fox browser
	static WebDriver driver;
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", chromeDriver+"chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.google.com");
		
		WebElement searchBox = driver.findElement(By.name("q"));
		System.out.println(searchBox.isSelected());
		
		driver.quit();
	}
}
