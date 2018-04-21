package featuresInWebDriver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingAlrets {
	
	static final String chromeDriver = System.getProperty("user.dir")+ "\\Google Chrome Driver\\";
	//static final String geckoDriver = System.getProperty("user.dir")+ "\\Mozilla GeckoDriver\\"; // For Fire fox browser
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", chromeDriver+"chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/javascript_alerts");
		Thread.sleep(5000);

		// Javascript alert
		driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(5000);
		
		// Javascript confirm pop-up
		driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
		alert.dismiss();
		Thread.sleep(5000);
		
		// Javascript prompt
		driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
		alert.sendKeys("Hello !...");
		alert.accept();
		Thread.sleep(5000);
		
		driver.quit();

	}

}
