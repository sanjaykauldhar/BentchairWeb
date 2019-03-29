package BCW_PriceOnRequest;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;

import PageObjects.POR_Form;

import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class POR_ProductPage{
  private WebDriver driver;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testPOR_ProductPage() throws Exception {
	  
    driver.get("https://www.bentchair.com/bent-luxury");
    
    driver.manage().window().maximize();
    
    WebElement SelectProduct = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/div[1]/div/figure/a/div/img"));
    JavascriptExecutor executor1 = (JavascriptExecutor) driver;
    executor1.executeScript("arguments[0].click();", SelectProduct);
    
    WebElement BOOK_NOW = driver.findElement(By.xpath("//*[@id=\"Dproduct\"]/div[2]/div/div[2]/div/button"));
    JavascriptExecutor executor3 = (JavascriptExecutor) driver;
    executor3.executeScript("arguments[0].click();", BOOK_NOW);
  
    POR_Form.form_name(driver).sendKeys("Test Sanjay");
    
    POR_Form.form_email(driver).sendKeys("sanjaykauldhar123@gmail.com");
    
    POR_Form.form_contact(driver).sendKeys("9876543210");
    
    POR_Form.form_city(driver).sendKeys("New Delhi");
    
    POR_Form.form_message(driver).sendKeys("PRICE ON REQUEST ON PRODUCT PAGE RECEIVED SUCCESSFULLY!");

    POR_Form.req_agree(driver).click();
    
    POR_Form.SUBMIT(driver).click();
    
    WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"Dproduct\"]/div[2]/div/div[2]/div/button")));
    
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
