package BCW_BentStudio;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;

import PageObjects.BYA_Form;
import PageObjects.menu;

import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Bengaluru {
  private WebDriver driver;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testBengaluru() throws Exception {
	  
    driver.get("https://www.bentchair.com/");
    
    driver.manage().window().maximize();
    
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    
    Actions action = new Actions(driver);
    WebElement we = menu.company(driver);
    action.moveToElement(we).build().perform();
    
    WebElement studio =(WebElement)new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(menu.bent_studio(driver)));
    studio.click();
    
    driver.findElement(By.xpath("//img[contains(@src,'bengaluru-studio-page.jpg')]")).click();
    //BYA_Form.appointment(driver).submit();
    WebElement element = driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg westend-btn']"));
    ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);

    WebElement form_name = driver.findElement(By.id("form_name"));
    form_name.sendKeys("Test Sanjay");
    
    WebElement form_email = driver.findElement(By.id("form_email"));
    form_email.sendKeys("sanjaykauldhar123@gmail.com");
    
    WebElement form_contact = driver.findElement(By.id("form_contact"));
    form_contact.sendKeys("9876543210");
    
    WebElement form_company = driver.findElement(By.id("form_company "));
    form_company.sendKeys("Bengaluru Ltd");
    
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='×'])[1]/following::span[2]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Su'])[2]/following::th[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='×'])[1]/following::span[4]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Clear'])[1]/following::span[7]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='FAQ'])[1]/following::span[3]")).click();
    
    WebElement form_message = driver.findElement(By.id("form_message"));
    form_message.sendKeys("BOOKED AN APPOINTMENT FOR BENT STUDIO BENGALURU SUCCESSFULLY!");
    
    WebElement req_agree = driver.findElement(By.id("req_agree"));
    req_agree.click();
    
    //BYA_Form.captcha(driver).sendKeys("test");
    /*Actions actions = new Actions(driver);
    actions.moveToElement(driver.findElement(By.tagName("body")), 0, 0);
    actions.moveByOffset(660, 930).click().build().perform();*/
    
    
    BYA_Form.submit(driver).click();
    
    //Thread.sleep(1000);
    
    /*String actual = BYA_Form.error(driver).getText();
    String expected = "Captcha Does Not Match";
    Assert.assertEquals(actual, expected);*/
    
    /*WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='appointment-btn']")));
    */
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
