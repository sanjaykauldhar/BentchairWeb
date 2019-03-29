package BCW_BentStudio;

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

public class BentStudio_HYDERABAD {
  private WebDriver driver;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testBentStudio_HYDERABAD() throws Exception {
	  
    driver.get("https://www.bentchair.com/");
    
    driver.manage().window().maximize();
    
    WebElement BENT_STUDIO = driver.findElement(By.xpath("//div[@class='col-sm-3 col-xs-6 text-left'][2]/p[1]/a"));
    JavascriptExecutor executor11 = (JavascriptExecutor) driver;
    executor11.executeScript("arguments[0].click();", BENT_STUDIO);
    
    WebElement BENT_STUDIO_HYDERABAD = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div[2]/div[1]/div/div[3]/a/img"));
    JavascriptExecutor executor10 = (JavascriptExecutor) driver;
    executor10.executeScript("arguments[0].click();", BENT_STUDIO_HYDERABAD);
    
    WebElement BOOK_AN_APPOINTMENT = driver.findElement(By.xpath("//*[@id=\"appointment-btn\"]"));
    JavascriptExecutor executor1 = (JavascriptExecutor) driver;
    executor1.executeScript("arguments[0].click();", BOOK_AN_APPOINTMENT);
    
    WebElement inputName = driver.findElement(By.id("inputName"));
    inputName.sendKeys("Test Sanjay");
    
    WebElement inputEmail = driver.findElement(By.id("inputEmail"));
    inputEmail.sendKeys("sanjaykauldhar123@gmail.com");
    
    WebElement inputPhone = driver.findElement(By.id("inputPhone"));
    inputPhone.sendKeys("9876543210");
    
    WebElement inputCompany = driver.findElement(By.id("inputCompany"));
    inputCompany.sendKeys("HYDERABAD STUDIO LTD");
    
    WebElement inputDate = driver.findElement(By.id("inputDate"));
    inputDate.sendKeys("06-06-2018");
    
    WebElement inputTime = driver.findElement(By.id("inputTime"));
    inputTime.click();
    
    WebElement inputMessage = driver.findElement(By.id("inputMessage"));
    inputMessage.sendKeys("BOOKED AN APPOINTMENT FOR BENT STUDIO HYDERABAD SUCCESSFULLY!");
    
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
