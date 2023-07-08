package sparkleHomeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class LinkRedirectionTest {

	public static void main(String[] args) {
		// Set the path to the ChromeDriver executable
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Chromedriver\\chromedriver.exe");
		
	
        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();
     // Maximize the browser window
        driver.manage().window().maximize();
        
     // Open the link
        driver.get("http://the-internet.herokuapp.com/status_codes");
     // Implement implicit wait for page elements
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // Find and click on the link
        WebElement link = driver.findElement(By.linkText("301"));
        link.click();

        // Verify the redirection
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "http://the-internet.herokuapp.com/redirect";
        if (currentUrl.equals(expectedUrl)) {
            System.out.println("Redirection successful!");
        } else {
            System.out.println("Redirection failed! Expected: " + expectedUrl + ", Actual: " + currentUrl);
        }

        // Close the browser
        driver.quit();

	}

}
