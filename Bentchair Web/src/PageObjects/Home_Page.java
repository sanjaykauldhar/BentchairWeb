package PageObjects;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

public class Home_Page {

		private static WebElement element = null;

		public static WebElement LOGO(WebDriver driver){

		element = driver.findElement(By.xpath("//img[@src='image/catalog/image/Bent-Chair-Logo-3.png']"));

		return element;

}

}