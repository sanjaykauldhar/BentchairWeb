package BCW_BentStudio;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.*;

import PageObjects.BYA_Form;
import PageObjects.menu;

import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Chennai {
  private WebDriver driver;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testChennai() throws Exception {
	  
    driver.get("https://www.bentchair.com/");
    
    driver.manage().window().maximize();
    
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    
    Actions action = new Actions(driver);
    WebElement we = menu.company(driver);
    action.moveToElement(we).build().perform();
    
    WebElement studio =(WebElement)new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(menu.bent_studio(driver)));
    studio.click();
    
    driver.findElement(By.xpath("//img[contains(@src,'chennai.jpg')]")).click();
    
    BYA_Form.appointment(driver);
    
    WebElement form_name = driver.findElement(By.id("form_name"));
    form_name.sendKeys("Test Sanjay");
    
    WebElement form_email = driver.findElement(By.id("form_email"));
    form_email.sendKeys("sanjaykauldhar123@gmail.com");
    
    WebElement form_contact = driver.findElement(By.id("form_contact"));
    form_contact.sendKeys("9876543210");
    
    driver.findElement(By.xpath("//input[@id='form_company ']")).sendKeys("Test Chennai Studio Appointment");
    driver.findElement(By.xpath("//span[@class='glyphicon glyphicon-calendar']")).click();
    driver.findElement(By.xpath("//div[4]/div[3]/table/tfoot/tr/th")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//span[@class='glyphicon glyphicon-time']")).click();
    driver.findElement(By.xpath("//div[2]/table/tbody/tr/td/span[2]")).click();
    driver.findElement(By.xpath("//td/span[2]")).click();
    WebElement form_message = driver.findElement(By.id("form_message"));
    form_message.sendKeys("BOOKED AN APPOINTMENT FOR BENT STUDIO CHENNAI SUCCESSFULLY!");
    
    WebElement req_agree = driver.findElement(By.id("req_agree"));
    req_agree.click();
    
    BYA_Form.submit(driver).click();
        
    Thread.sleep(1000);
    
    String actual = BYA_Form.error(driver).getText();
    String expected = "Please check 'I'm not a robot'.";
    Assert.assertEquals(actual, expected);
    
    /*WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='form_sub_btn']")));
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
