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

public class POR_ShopTheLook {
  private WebDriver driver;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testPOR_ShopTheLook() throws Exception {
	  
    driver.get("https://www.bentchair.com/");
    
    driver.manage().window().maximize();
    
    WebElement SHOP_THE_LOOK = driver.findElement(By.xpath("//div[@class='col-sm-3 col-xs-6 text-left'][2]/p[2]/a"));
    JavascriptExecutor executor1 = (JavascriptExecutor) driver;
    executor1.executeScript("arguments[0].click();", SHOP_THE_LOOK);
    
    WebElement DAZZLING_FURNITURE_LOOKS = driver.findElement(By.xpath("//*[@id=\"furniture_look_div\"]/div/a/img"));
    JavascriptExecutor executor2 = (JavascriptExecutor) driver;
    executor2.executeScript("arguments[0].click();", DAZZLING_FURNITURE_LOOKS);

    WebElement WINSTON_BEDROOM = driver.findElement(By.xpath("//*[@id=\"container\"]/section/div/div[2]/div/div[1]/div/div/h4/a"));
    JavascriptExecutor executor3 = (JavascriptExecutor) driver;
    executor3.executeScript("arguments[0].click();", WINSTON_BEDROOM);

    WebElement PRICE_ON_REQUEST = driver.findElement(By.xpath("//*[@id=\"container\"]/div[1]/div[3]/div/div/button"));
    JavascriptExecutor executor10 = (JavascriptExecutor) driver;
    executor10.executeScript("arguments[0].click();", PRICE_ON_REQUEST);
    
    POR_Form.form_name(driver).sendKeys("Test Sanjay");
    
    POR_Form.form_email(driver).sendKeys("sanjaykauldhar123@gmail.com");
    
    POR_Form.form_contact(driver).sendKeys("9876543210");
    
    POR_Form.form_city(driver).sendKeys("New Delhi");
    
    POR_Form.form_message(driver).sendKeys("PRICE ON REQUEST FOR SHOP THE LOOK RECEIVED SUCCESSFULLY!");
    
    POR_Form.req_agree(driver).click();
    
    POR_Form.SUBMIT(driver).click();
        
    WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"container\"]/div[1]/div[3]/div/div/button")));
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
