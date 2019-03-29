package PageObjects;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

public class BA_Credentials {

		private static WebElement element = null;

		public static WebElement BA_Username(WebDriver driver){

		element = driver.findElement(By.xpath("//input[@id='input-username']"));
				
		return element;
		
		}
		
		public static WebElement BA_Password(WebDriver driver){

		element = driver.findElement(By.id("input-password"));
				
		return element;
		
		}
		
		public static WebElement BA_Login(WebDriver driver){

		element = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
					
		return element;

}

}