package featuresInWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WindowHandling {
	
	static final String chromeDriver = System.getProperty("user.dir")+ "\\Google Chrome Driver\\";
	//static final String geckoDriver = System.getProperty("user.dir")+ "\\Mozilla GeckoDriver\\"; // For Fire fox browser
	static WebDriver driver;
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", chromeDriver+"chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/windows");

		String parentWindow = driver.getWindowHandle();
		System.out.println("First Window Handle is: " + parentWindow);

		WebElement link = driver.findElement(By.xpath("//a[@href='/windows/new']"));
		link.click();

		String childWindow = driver.getWindowHandle();
		System.out.println("Second Window Handle is: " + childWindow);
		System.out.println("Number of Window Handles so for: " + driver.getWindowHandles().size());

		driver.switchTo().window(parentWindow);
		
		driver.quit();

	}
}
