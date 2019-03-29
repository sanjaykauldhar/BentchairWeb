package BCW_PartnerWithUs;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.*;

import PageObjects.BYA_Form;

import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Affiliate {
  private WebDriver driver;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @Test
  public void testAffiliate() throws Exception {
	  
    driver.get("https://www.bentchair.com/");
    
    driver.manage().window().maximize();
    
    WebElement PARTNER_WITH_US = driver.findElement(By.xpath("//*[@id=\"stickyh\"]/div[1]/div/div[1]/div[2]/div/div/ul/li[2]/a"));
    PARTNER_WITH_US.click();
    
    WebElement GET_STARTED = driver.findElement(By.xpath("//*[@id=\"content\"]/main/div/div/div[2]/div[2]/div/div/div[1]/div/div/a/button"));
    JavascriptExecutor executor = (JavascriptExecutor) driver;
    executor.executeScript("arguments[0].click();", GET_STARTED);
    
    WebElement BOOK_A_CONSULTATION = driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg btn_tel']"));
    JavascriptExecutor executor1 = (JavascriptExecutor) driver;
    executor1.executeScript("arguments[0].click();", BOOK_A_CONSULTATION);
    
    BYA_Form.form_name(driver).sendKeys("Test Sanjay");
    
    BYA_Form.form_email(driver).sendKeys("sanjaykauldhar123@gmail.com");
    
    BYA_Form.form_contact(driver).sendKeys("9876543210");
       
    BYA_Form.form_company(driver).sendKeys("Affiliate Company");
    
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='×'])[1]/following::span[2]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Su'])[2]/following::th[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='×'])[1]/following::span[4]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Clear'])[1]/following::span[7]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='FAQ'])[1]/following::span[3]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='×'])[1]/following::div[9]")).click();
    //BYA_Form.form_date(driver).sendKeys("07-07-2018");
    
    //BYA_Form.form_time(driver).click();
    
    BYA_Form.form_message(driver).sendKeys("BOOKED AN APPOINTMENT FOR AFFILIATE SUCCESSFULLY!");
    
    BYA_Form.req_agree(driver).click();
    
    BYA_Form.captcha(driver).sendKeys("test");
    
    BYA_Form.SUBMIT1(driver).click();
    
    Thread.sleep(1000);
    String actual = BYA_Form.error(driver).getText();
    String expected = "Captcha Does Not Match";
    Assert.assertEquals(actual, expected);
    
    /*WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-primary btn-lg btn_tel']")));*/
        
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
