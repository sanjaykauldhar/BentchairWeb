package BCW_BentStudio;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BentStudio_CORPORATE_OFFICE_DELHI {
  private WebDriver driver;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testBentStudio_CORPORATE_OFFICE_DELHI() throws Exception {
	  
    driver.get("https://www.bentchair.com/");
    
    driver.manage().window().maximize();
    
    WebElement BENT_STUDIO = driver.findElement(By.xpath("//div[@class='col-sm-3 col-xs-6 text-left'][2]/p[1]/a"));
    JavascriptExecutor executor11 = (JavascriptExecutor) driver;
    executor11.executeScript("arguments[0].click();", BENT_STUDIO);
    
    WebElement CORPORATE_OFFICE_DELHI = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div[2]/div[2]/div/a/img"));
    JavascriptExecutor executor10 = (JavascriptExecutor) driver;
    executor10.executeScript("arguments[0].click();", CORPORATE_OFFICE_DELHI);
    
    WebElement BOOK_AN_APPOINTMENT = driver.findElement(By.xpath("//button[@id='appointment-btn']"));
    JavascriptExecutor executor1 = (JavascriptExecutor) driver;
    executor1.executeScript("arguments[0].click();", BOOK_AN_APPOINTMENT);
    
    WebElement form_name = driver.findElement(By.id("form_name"));
    form_name.sendKeys("Test Sanjay");
    
    WebElement form_email = driver.findElement(By.id("form_email"));
    form_email.sendKeys("sanjaykauldhar123@gmail.com");
    
    WebElement form_contact = driver.findElement(By.id("form_contact"));
    form_contact.sendKeys("9876543210");
    
    WebElement form_company = driver.findElement(By.id("form_company"));
    form_company.sendKeys("DELHI STUDIO LTD");
    
    WebElement form_date = driver.findElement(By.id("form_date"));
    form_date.sendKeys("03-03-2018");
    
    WebElement form_time = driver.findElement(By.id("form_time"));
    form_time.click();
    
    WebElement form_message = driver.findElement(By.id("form_message"));
    form_message.sendKeys("BOOKED AN APPOINTMENT FOR BENT STUDIO CORPORATE OFFICE DELHI SUCCESSFULLY!");
    
    WebElement req_agree = driver.findElement(By.id("req_agree"));
    req_agree.click();
    
    WebElement SUBMIT = driver.findElement(By.xpath("//button[@id='submit_studio']"));
    JavascriptExecutor executor2 = (JavascriptExecutor) driver;
    executor2.executeScript("arguments[0].click();", SUBMIT);
    
    WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='appointment-btn']")));
    
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
