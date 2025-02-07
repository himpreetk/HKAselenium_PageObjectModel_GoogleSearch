# HKAselenium_PageObjectModel_GoogleSearch

A. Project Overview 📌

    This project demonstrates automated testing of Google Search using Selenium WebDriver with Java following the Page Object Model (POM) framework. The script automates a simple search query on Google and validates the page title to ensure that the search operation was successful.

B. Features 🚀

    B.1. Uses Selenium WebDriver to automate Google Search
    B.2. Implements Page Object Model (POM) for better maintainability
    B.4. Includes implicit waits for better test stability
    B.5. Easy setup and execution

C. Project Structure 📂 

    GoogleSearchAutomation/
    │-- src/
    │   ├── packagegooglepage/
    │   │   ├── GooglePage.java       # Page Object Model for Google Search
    │   │   ├── GoogleSearchTest.java # Test execution file
    │-- resources/
    │   ├── chromedriver.exe          # ChromeDriver for Selenium
    │-- README.md                     # Project documentation
    │-- pom.xml                        # Maven dependencies (if using Maven)

D. Tech Stack 🛠️

    D.1. Programming Language: Java
    D.2. Automation Tool: Selenium WebDriver
    D.3. Framework: Page Object Model (POM)
    D.4. Browser: Google Chrome
    D.5. Build Tool (Optional): Maven

E. Prerequisites 📌

    E.1. Ensure you have the following installed on your system:
    E.2. Java Development Kit (JDK) 8+
    E.3. Eclipse/IntelliJ IDEA (or any preferred IDE)
    E.4. Selenium WebDriver dependencies
    E.5. Chrome Browser and Chromedriver (compatible with your browser version)

F. Setup Instructions 🚀

    F.1. Clone the repository:
           - git clone https://github.com/your-username/GoogleSearchAutomation.git
           - cd GoogleSearchAutomation

    F.2. Open the project in your IDE (Eclipse/IntelliJ)

    F.3. Set up ChromeDriver Path in GoogleSearchTest.java:
           - System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");

    F.4. Run the test:

          F.4.1. If using an IDE, run GoogleSearchTest.java
          F.4.2. If using Maven, execute:
                 - mvn test

 G. Code Explanation 📝

    G.1. GooglePage.java (Page Object Model Implementation)
         This class encapsulates the Google Search Page elements and actions:

             package packagegooglepage;

             import org.openqa.selenium.By;
             import org.openqa.selenium.WebDriver;
             import org.openqa.selenium.WebElement;

             public class GooglePage 
             {
             WebDriver driver;

                 // Constructor
                public GooglePage(WebDriver driver) 
                {
                this.driver = driver;
                }

               // Locators
               private By searchBox = By.name("q");

               // Method to perform search
               public void searchFor(String keyword) 
               {
                 WebElement searchInput = driver.findElement(searchBox);
                 searchInput.sendKeys(keyword);
                 searchInput.submit(); // Simulates pressing "Enter" instead of clicking 'btnK'
               }

               // Get Page Title
               public String getTitle() 
               {
                return driver.getTitle();
               }
            }

    G.2. GoogleSearchTest.java (Test Execution)
         This class contains the test case execution:

           package packagegooglepage;

           import org.openqa.selenium.WebDriver;
           import org.openqa.selenium.chrome.ChromeDriver;
           import java.time.Duration;

           public class GoogleSearchTest 
           {
             public static void main(String[] args) 
              {
               // Set up Chrome Driver Path
               System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");

               // Initialize WebDriver
               WebDriver driver = new ChromeDriver();
               driver.manage().window().maximize();
               driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Implicit Wait
 
               // Open Google
               driver.get("https://www.google.com");

               // Use Page Object Model for Google Search
               GooglePage googlePage = new GooglePage(driver);
               googlePage.searchFor("Selenium with Java");

               // Validate the Result
               String title = googlePage.getTitle();
               if (title.contains("Selenium with Java")) 
               {
                 System.out.println("Test Passed!");
               } 
               else 
               {
                 System.out.println("Test Failed!");
               }

            // Close Browser
           driver.quit();
         }
       }

H. Expected Output 🎯

    H.1. If the search result page contains the query "Selenium with Java", the console will print:
         Test Passed!

    H.2. Otherwise, it will print:
         Test Failed!

I. Contributing 🤝

    Contributions are welcome! Feel free to fork the repo, create a new branch, and submit a pull request.
