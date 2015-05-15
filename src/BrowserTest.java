import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrowserTest {
	String message = "Hurray!";	
    MessageUtil messageUtil = new MessageUtil(message);
	   
    public static void main(String[] args) throws Exception {
        // The GoogleChrome driver need you to write the path to it 
        
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Helfdane\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
    	WebDriver driver = new  ChromeDriver();
    	
        // Firefox version is much more simple
        // WebDriver driver = new FirefoxDriver();
    	
    	// Open window in full screen mode
    	driver.manage().window().maximize();
        // Go to the Google.com.ua
        driver.get("http://www.google.com.ua");
       
        
        // Locating search field by it's name
        WebElement query = driver.findElement(By.name("q"));
        // Type what we're looking for in the search field
        query.sendKeys("Automation QA");
        // Locate magnifying glass button
        WebElement btnG = driver.findElement(By.name("btnG"));
        // and clicking it
        btnG.click();
        // we have to wait for some time, because page is loading and next string of code will throw an error (sleep time may vary from system to system)
        Thread.sleep(1000);
        // Getting second link from results row by it's xpath (thx to chrome f12 and copy xpath)
        driver.findElement(By.xpath("//*[@id=\"rso\"]/div[2]/li[2]/div/h3/a")).click();
        // Wait some more time to recognize the page
        Thread.sleep(5000);
        // end of session
        driver.quit();
        
    }
    
    @Test
    public void testPrintMessage() {	  
       Assert.assertEquals(message,messageUtil.printMessage());
    }

}

