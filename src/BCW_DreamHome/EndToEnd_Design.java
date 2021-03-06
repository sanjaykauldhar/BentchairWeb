package BCW_DreamHome;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EndToEnd_Design {
  private WebDriver driver;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testEndToEnd_Design() throws Exception {
	  
    driver.get("https://www.bentchair.com/");
    
    driver.manage().window().maximize();
    
    WebElement DREAM_HOME = driver.findElement(By.xpath("//div[@class='links top-header']/ul/li[1]/a"));
    DREAM_HOME.click();
    
    WebElement EndToEnd_Design = driver.findElement(By.xpath("//img[@alt='End to End Design']"));
    JavascriptExecutor executor1 = (JavascriptExecutor) driver;
    executor1.executeScript("arguments[0].click();", EndToEnd_Design);
    
    WebElement BOOK_A_CONSULTATION = driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg btn_tel']"));
    JavascriptExecutor executor10 = (JavascriptExecutor) driver;
    executor10.executeScript("arguments[0].click();", BOOK_A_CONSULTATION);
    
    WebElement form_name = driver.findElement(By.id("form_name"));
    form_name.sendKeys("Test Sanjay");
    
    WebElement form_email = driver.findElement(By.id("form_email"));
    form_email.sendKeys("sanjaykauldhar123@gmail.com");
    
    WebElement form_contact = driver.findElement(By.id("form_contact"));
    form_contact.sendKeys("9876543210");
    
    WebElement form_company = driver.findElement(By.id("form_company"));
    form_company.sendKeys("END TO END DESIGN LTD.");
    
    WebElement form_date = driver.findElement(By.id("form_date"));
    form_date.sendKeys("03-03-2018");
    
    WebElement form_time = driver.findElement(By.id("form_time"));
    form_time.click();
    
    WebElement form_message = driver.findElement(By.id("form_message"));
    form_message.sendKeys("BOOKED APPOINTMENT FOR END TO END DESIGN SUCCESSFULLY!");
    
    WebElement req_agree = driver.findElement(By.id("req_agree"));
    req_agree.click();
    
    WebElement SUBMIT = driver.findElement(By.xpath("//*[@id=\"bentchair-form\"]/div[5]/div/button"));
    JavascriptExecutor executor2 = (JavascriptExecutor) driver;
    executor2.executeScript("arguments[0].click();", SUBMIT);
    
    WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-primary btn-lg btn_tel']")));    
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
	driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
}
