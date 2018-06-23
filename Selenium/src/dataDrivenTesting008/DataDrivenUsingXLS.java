package dataDrivenTesting008;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DataDrivenUsingXLS {

	static final String chromeDriver = System.getProperty("user.dir")+ "\\Google Chrome Driver\\";
	//static final String geckoDriver = System.getProperty("user.dir")+ "\\Mozilla GeckoDriver\\"; // For Fire fox browser
	static WebDriver driver;
	static XSSFRow row;
	static XSSFCell cell;
	static int columnIndex;
	static DataFormatter formatedData;
	static Select conDropdown;
	static String arrOfDOB[];
	static Random randomNum ;
	static WebDriverWait wait;
	
	// method to wait until the element is clickable
	public static void elementToClickable(By expression) {
		 wait = new WebDriverWait(driver, 10);
		 wait.until(ExpectedConditions.elementToBeClickable(expression));
	}
	
	// method to setting up browser
	public static void browserSetup() {
		System.setProperty("webdriver.chrome.driver", chromeDriver+"chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demoqa.com/registration/");
	}
	
	public static void main(String[] args) throws IOException, InterruptedException {

		browserSetup(); // calling browser setup method

		InputStream excelFileToRead = new FileInputStream(System.getProperty("user.dir")+ "\\" + "Data_Driven_001.xlsx"); // creating a input stream to the xlsx file 
		XSSFWorkbook workBook = new XSSFWorkbook (excelFileToRead); // accessing workbook
		XSSFSheet sheet = workBook.getSheetAt(0); // getting first sheet
		
		Iterator<Row> rows = sheet.iterator();
		
		// loop through all the rows in the xlsx file
		while(rows.hasNext()) {
			row = (XSSFRow) rows.next();
			Iterator<Cell> cells = row.iterator();

			if (row.getRowNum() == 0) {
				continue;// skip first row, as it contains column names
			}
			
			// loop through all the cell in the row
			while (cells.hasNext()) {
				cell = (XSSFCell) cells.next();
				formatedData = new DataFormatter();
				columnIndex =  cell.getColumnIndex();

				// based on the respective cell - column index of the xlsx file
				switch (columnIndex) {
				
				// first name
				case 0:
					elementToClickable(By.id("name_3_firstname"));
					
					driver.findElement(By.id("name_3_firstname")).clear();
					driver.findElement(By.id("name_3_firstname")).sendKeys(formatedData.formatCellValue(cell));
					break;
				
				// last name
				case 1:
					elementToClickable(By.id("name_3_lastname"));
					
					driver.findElement(By.id("name_3_lastname")).clear();
					driver.findElement(By.id("name_3_lastname")).sendKeys(formatedData.formatCellValue(cell));
					break;
				
				// marital status
				case 2:
					elementToClickable(By.xpath("//input[contains(@value,'single')]"));
					
					if (formatedData.formatCellValue(cell).equalsIgnoreCase("Single")) {
						driver.findElement(By.xpath("//input[contains(@value,'single')]")).click();;
					}
					else if (formatedData.formatCellValue(cell).equalsIgnoreCase("Married")) {
						driver.findElement(By.xpath("//input[contains(@value,'married')]")).click();
					}
					else {
						driver.findElement(By.xpath("//input[contains(@value,'divorced')]")).click();
					}
					break;
					
				// hobby
				case 3:
					elementToClickable(By.xpath("//input[contains(@value,'reading')]"));
					
					if (formatedData.formatCellValue(cell).equalsIgnoreCase("Dance")) {
						driver.findElement(By.xpath("//input[contains(@value,'dance')]")).click();
					}
					else if (formatedData.formatCellValue(cell).equalsIgnoreCase("Reading")) {
						driver.findElement(By.xpath("//input[contains(@value,'reading')]")).click();
					}
					else {
						driver.findElement(By.xpath("//input[contains(@value,'cricket')]")).click();
					}
					break;
					
				// country
				case 4:
					elementToClickable(By.id("dropdown_7"));
					
					conDropdown = new Select (driver.findElement(By.id("dropdown_7")));
					conDropdown.selectByValue(formatedData.formatCellValue(cell));
					break;
					
				// D.O.B
				case 5:
					elementToClickable(By.xpath("//select[@id='mm_date_8']"));
					
					arrOfDOB = formatedData.formatCellValue(cell).split("-"); // splitting the string based on delimiter(-) 

					Select monthDropdown = new Select (driver.findElement(By.xpath("//select[@id='mm_date_8']")));
					monthDropdown.selectByValue(arrOfDOB[1]); // select month

					Select dayDropdown = new Select (driver.findElement(By.xpath("//select[@id='dd_date_8']")));
					dayDropdown.selectByValue(arrOfDOB[0]); // select date

					Select yearDropdown = new Select (driver.findElement(By.xpath("//select[@id='yy_date_8']")));
					yearDropdown.selectByValue(arrOfDOB[2]); // select year
					break;
					
				// phone number
				case 6:
					elementToClickable(By.id("phone_9"));
					
					driver.findElement(By.id("phone_9")).clear();
					driver.findElement(By.id("phone_9")).sendKeys(formatedData.formatCellValue(cell));
					break;

				// username
				case 7:
					elementToClickable(By.id("username"));
					randomNum = new Random();
					driver.findElement(By.id("username")).clear();
					driver.findElement(By.id("username")).sendKeys(formatedData.formatCellValue(cell) + (randomNum.nextInt(99999)+10000));
					break;
					
				// email
				case 8:
					elementToClickable(By.id("email_1"));
					driver.findElement(By.id("email_1")).clear();
					driver.findElement(By.id("email_1")).sendKeys(formatedData.formatCellValue(cell));
					break;
					
				// password
				case 9:
					elementToClickable(By.id("password_2"));
					driver.findElement(By.id("password_2")).clear();
					driver.findElement(By.id("password_2")).sendKeys(formatedData.formatCellValue(cell));
					break;

				// confirm password
				case 10:
					elementToClickable(By.id("confirm_password_password_2"));
					driver.findElement(By.id("confirm_password_password_2")).clear();
					driver.findElement(By.id("confirm_password_password_2")).sendKeys(formatedData.formatCellValue(cell));
					break;

				}
			}
			Thread.sleep(5000);
			driver.findElement(By.xpath("//input[@name='pie_submit']")).click();
			
			// wait until registration message displays
			wait.until(ExpectedConditions.textToBe(By.xpath("//p[@class='piereg_message']"), "Thank you for your registration"));
		}
		
		// close the xlsx files
		excelFileToRead.close();
		workBook.close();
		
		// close driver
		driver.quit();
	}
}
