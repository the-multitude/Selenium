package advancedInteractions004;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionBuildPerform2 {
	
	static final String chromeDriver = System.getProperty("user.dir")+ "\\Google Chrome Driver\\";
	//static final String geckoDriver = System.getProperty("user.dir")+ "\\Mozilla GeckoDriver\\"; // For Fire fox browser
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", chromeDriver+"chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/key_presses");
		
		// Add all actions into the Actions builder.
		Actions builder = new Actions(driver);
		builder.keyDown(Keys.SHIFT).sendKeys("m").keyUp(Keys.SHIFT);

		// Perform action.
		builder.perform();
		
		Thread.sleep(2000);
		driver.quit();
		
	}
}
