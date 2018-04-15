package advancedInteractions004;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import actionsOnWebElements002.SendKeys;

public class ActionBuildPerform {
	
	static final String chromeDriver = System.getProperty("user.dir")+ "\\Google Chrome Driver\\";
	//static final String geckoDriver = System.getProperty("user.dir")+ "\\Mozilla GeckoDriver\\"; // For Fire fox browser
	static WebDriver driver;	
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", chromeDriver+"chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/key_presses");

		// Add action(s) into the Actions builder.
		Actions builder = new Actions(driver);
		builder.sendKeys("3");

		// Generate composite action.
		Action compositeAction = builder.build();

		// Perform composite action.
		compositeAction.perform();
		
		Thread.sleep(2000);
		driver.quit();
		
	}

}