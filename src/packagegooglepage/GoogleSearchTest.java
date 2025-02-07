package packagegooglepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\raman\\eclipse-workspace\\testerr\\HKAselenium_PageObjectModel_framework\\resources\\chromedriver.exe");
	    
		WebDriver driver = new ChromeDriver();
		
		//use Page Object Model for Google Search
		GooglePage googlePage = new GooglePage(driver);
		driver.get("https://www.google.com");
		googlePage.searchFor("Selenium with Java");
		
		
		
		//Validate the Result
		String title = googlePage.getTitle();
		if (title.contains("Selenium with Java"))
		{
			System.out.println("Test Passed!");
		}
		else
		{
			System.out.println("Test Failed!");
		}
	
		driver.quit();
	}

	
	 
}
