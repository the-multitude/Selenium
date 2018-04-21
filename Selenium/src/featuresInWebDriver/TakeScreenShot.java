package featuresInWebDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TakeScreenShot {
	
	static final String chromeDriver = System.getProperty("user.dir")+ "\\Google Chrome Driver\\";
	//static final String geckoDriver = System.getProperty("user.dir")+ "\\Mozilla GeckoDriver\\"; // For Fire fox browser
	static WebDriver driver;
	
	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", chromeDriver+"chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com");
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		System.out.println(scrFile.getAbsolutePath()); // saves the screenshot in temporary folder, which will be deleted once JVM is shutdown.
		
		FileUtils.copyFile(scrFile, new File("screen_shot001.png")); // copying image to locally using "Apache IO commons" library
		System.out.println("Path of the image stored locally: " + System.getProperty("user.dir"));
		
		driver.quit();
		
	}

}
