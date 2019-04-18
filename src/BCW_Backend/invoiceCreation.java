package BCW_Backend;

import org.testng.annotations.*;

import PageObjects.BA_Credentials;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;

//import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.Select;

public class invoiceCreation {
	
  public WebDriver driver;
  
  @Test(alwaysRun = true)
  
  public void testInvoiceCreation() throws Exception {
	  
	  	System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
	  
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.bentchair.com/bentadmin");
	    driver.switchTo().alert().sendKeys("bentbackend" + Keys.TAB + "10kal$feri!@#");
	    driver.switchTo().alert().accept();
	    BA_Credentials.BA_Username(driver).sendKeys("sanjay");
	    BA_Credentials.BA_Password(driver).sendKeys("sanjay@123");
	    BA_Credentials.BA_Login(driver).click();
	    //Mouse Hover Start
	    Actions action = new Actions(driver);
	    WebElement Cart = driver.findElement(By.xpath("//i[@class='fa fa-shopping-cart fa-fw']"));
	    action.moveToElement(Cart).build().perform();
	    //Mouse Hover End
	    WebElement Orders = driver.findElement(By.xpath("//li[@id='sale']/ul/li[1]/a"));
	    Orders.click();
	    
	    WebElement customer = driver.findElement(By.xpath("//*[@id=\"input-customer\"]"));
	    customer.sendKeys("TEST SANJAY");
	    
	    WebElement filter = driver.findElement(By.xpath("//*[@id=\"button-filter\"]"));
	    filter.click();
	    
	    WebElement viewOrder = driver.findElement(By.xpath("//i[@class='fa fa-eye'][1]"));
	    viewOrder.click();
	    
	    Select confirmed = new Select(driver.findElement(By.xpath("//select[@id='input-order-status']")));
	    confirmed.selectByValue("15");
	    WebElement addHistoryConfirm = driver.findElement(By.xpath("(//button[contains(text(),' Add History')])"));
	    addHistoryConfirm.click();
	    
	    Select processing = new Select(driver.findElement(By.xpath("//select[@id='input-order-status']")));
	    processing.selectByValue("2");
	    WebElement addHistoryProcess = driver.findElement(By.xpath("(//button[contains(text(),' Add History')])"));
	    addHistoryProcess.click();
	    
	    Select readyToDispatch = new Select(driver.findElement(By.xpath("//select[@id='input-order-status']")));
	    readyToDispatch.selectByValue("16");
	    	    
	    Select selectCourier = new Select(driver.findElement(By.xpath("//select[@id='input-courier']")));
	    selectCourier.selectByValue("1");
	    
	    WebElement pickUpDate = driver.findElement(By.xpath("//input[@id='pickup-date']"));
	    pickUpDate.click();
	    
	    WebElement pickUpTime = driver.findElement(By.xpath("//input[@id='pickup-time']"));
	    pickUpTime.click();
	    
	    WebElement courier = driver.findElement(By.xpath("//input[@id='courier']"));
	    courier.sendKeys("Test Courier");
	    
	    WebElement awb_no = driver.findElement(By.xpath("//input[@id='awbno']"));
	    awb_no.sendKeys("12345");
	    
	    WebElement invoice_no = driver.findElement(By.xpath("//input[@id='invoice_no']"));
	    invoice_no.sendKeys("54321");
	    
	    WebElement invoice_date = driver.findElement(By.xpath("//input[@id='invoice_date']"));
	    invoice_date.click();
	    
	    WebElement weight = driver.findElement(By.xpath("//input[@id='weight']"));
	    weight.sendKeys("10");
	    
	    WebElement height = driver.findElement(By.xpath("//input[@id='height']"));
	    height.sendKeys("7");
	    
	    WebElement width = driver.findElement(By.xpath("//input[@id='width']"));
	    width.sendKeys("7");
	    
	    WebElement length = driver.findElement(By.xpath("//input[@id='length']"));
	    length.sendKeys("7");
	    
	    WebElement comments = driver.findElement(By.xpath("//textarea[@id='input-comment']"));
	    comments.sendKeys("Test product is ready to dispatch...");
	    WebElement addHistoryDispatch = driver.findElement(By.xpath("(//button[contains(text(),' Add History')])"));
	    addHistoryDispatch.click();
	    
	    Select intransit = new Select(driver.findElement(By.xpath("//select[@id='input-order-status']")));
	    intransit.selectByValue("17");
	    WebElement addHistoryIntransit = driver.findElement(By.xpath("(//button[contains(text(),' Add History')])"));
	    addHistoryIntransit.click();
	    
	    Select delivered = new Select(driver.findElement(By.xpath("//select[@id='input-order-status']")));
	    delivered.selectByValue("13");
	    WebElement addHistoryDelivered = driver.findElement(By.xpath("(//button[contains(text(),' Add History')])"));
	    addHistoryDelivered.click();
	    
	    driver.navigate().refresh();
	    
	    WebElement viewInvoice = driver.findElement(By.xpath("//i[@class='fa fa-print']"));
	    viewInvoice.click();

  }
}
