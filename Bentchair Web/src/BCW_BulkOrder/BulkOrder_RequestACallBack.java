package BCW_BulkOrder;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class BulkOrder_RequestACallBack {
  private WebDriver driver;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testBulkOrder_RequestACallBack() throws Exception {
	  
    driver.get("https://www.bentchair.com/");
    
    driver.manage().window().maximize();
    
    WebElement BULK_ORDER = driver.findElement(By.xpath("//div[@class='links top-header']/ul/li[3]/a"));
    BULK_ORDER.click();
    
    WebElement REQUEST_A_CALL_BACK = driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg btn_tel']"));
    JavascriptExecutor executor1 = (JavascriptExecutor) driver;
    executor1.executeScript("arguments[0].click();", REQUEST_A_CALL_BACK);
    
    WebElement form_name = driver.findElement(By.id("form_name"));
    form_name.sendKeys("Test Sanjay");
    
    WebElement form_email = driver.findElement(By.id("form_email"));
    form_email.sendKeys("sanjaykauldhar123@gmail.com");
    
    WebElement form_contact = driver.findElement(By.id("form_contact"));
    form_contact.sendKeys("9876543210");
    
    WebElement form_company = driver.findElement(By.id("form_company"));
    form_company.sendKeys("PQR Ltd.");
    
    WebElement form_date = driver.findElement(By.id("form_date"));
    form_date.sendKeys("05-05-2018");
    
    WebElement form_time = driver.findElement(By.id("form_time"));
    form_time.click();
    
    WebElement form_message = driver.findElement(By.id("form_message"));
    form_message.sendKeys("REQUESTED A CALL BACK FOR BULK ORDER SUCCESSFULLY!");
    
    WebElement req_agree = driver.findElement(By.id("req_agree"));
    req_agree.click();
    
    WebElement SUBMIT = driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg btn-block']"));
    JavascriptExecutor executor2 = (JavascriptExecutor) driver;
    executor2.executeScript("arguments[0].click();", SUBMIT);        
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
	//driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
}
