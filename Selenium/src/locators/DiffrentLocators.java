package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DiffrentLocators {

	/*
	 Locators:
	 *	Elements can be located by using findElement() and findElements() methods provided in WebDriver and
	 	WebElements class.
	 	
	 	 	findElement() - method returns WebElement object (throws an exception if element not matched or found)
	 	 	findElements() - method returns a list of WebElements (it returns an empty list)
	  
	 * There are 8 locators - ID, name, class name, tag name, link text, partial link test, CSS and Xpath.
	  
	 * findElement() and findElement() - throws NoSuchElementFoundException when they fail to locate specified element
	  
	 */
	
	static final String chromeDriver = "C:\\Users\\Madhan\\git\\Selenium\\Selenium\\Google Chrome Driver\\";
	//static final String geckoDriver = "C:\\Users\\Madhan\\git\\Selenium\\Selenium\\Mozilla GeckoDriver\\";
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", chromeDriver+"chromedriver.exe");
		
		// For Fire fox browser
		// System.setProperty("webdriver.gecko.driver", geckoDriver+"geckodriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://book.theautomatedtester.co.uk/chapter2");
		
		// Finding an element by - ID
		driver.findElement(By.id("but1")).click();
		
		// Finding an element by - name
		driver.findElement(By.name("but2")).click();
		
		// Finding an element by - CSS Selector
		driver.findElement(By.cssSelector("#divontheleft")).click();
				
		// Finding an element by - Xpath query
		driver.findElement(By.xpath("//*[@id=\"random\"]")).click();
		
		// Finding an element by - link text
		driver.findElement(By.linkText("Index")).click();	
		
		driver.quit();
		
	}

}
