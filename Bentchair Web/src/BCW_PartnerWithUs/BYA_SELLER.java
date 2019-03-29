package BCW_PartnerWithUs;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;

import PageObjects.BYA_Form;

import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BYA_SELLER {
  private WebDriver driver;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testBYA_SELLER() throws Exception {
	  
    driver.get("https://www.bentchair.com/");
    
    driver.manage().window().maximize();
    
    WebElement PARTNER_WITH_US = driver.findElement(By.xpath("//div[@class='links top-header']/ul/li[2]/a"));
    PARTNER_WITH_US.click();
    
    WebElement GET_STARTED = driver.findElement(By.xpath("//*[@id=\"content\"]/main/div/div/div[2]/div[4]/div/div/div[2]/div/div/a/button"));
    JavascriptExecutor executor = (JavascriptExecutor) driver;
    executor.executeScript("arguments[0].click();", GET_STARTED);
    
    WebElement BOOK_A_CONSULTATION = driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg btn_tel']"));
    JavascriptExecutor executor1 = (JavascriptExecutor) driver;
    executor1.executeScript("arguments[0].click();", BOOK_A_CONSULTATION);
    
    BYA_Form.form_name(driver).sendKeys("Test Sanjay");
    
    BYA_Form.form_email(driver).sendKeys("sanjaykauldhar123@gmail.com");
    
    BYA_Form.form_contact(driver).sendKeys("9876543210");
    
    BYA_Form.form_company(driver).sendKeys("MNC Ltd.");
    
    BYA_Form.form_date(driver).sendKeys("11-11-2018");
    
    BYA_Form.form_time(driver).click();
    
    BYA_Form.form_message(driver).sendKeys("BOOKED AN APPOINTMENT FOR SELLER SUCCESSFULLY!");
    
    BYA_Form.req_agree(driver).click();
    
    BYA_Form.SUBMIT1(driver).click();
    
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
