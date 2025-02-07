package packagegooglepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GooglePage {

 WebDriver driver;
	 
	 By searchBox = By.name("q");
	 By searchButton = By.name("btnk");
	 
	 public GooglePage(WebDriver driver)
	 {
		 this.driver = driver;
	 }
	 public void searchFor(String query)
	 {
		 WebElement searchInput = driver.findElement(searchBox);
		 searchInput.sendKeys(query);
		 searchInput.submit();
	 }
	 public String getTitle()
	 {
		 return driver.getTitle();
	 }

}
