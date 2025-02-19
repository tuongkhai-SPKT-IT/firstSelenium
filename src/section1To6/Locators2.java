package section1To6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import firstSelenium.constantElement;

public class Locators2 {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		constantElement e = new constantElement();
		System.setProperty("webdriver.edge.driver", e.WebDriveLink + e.edgeDriver);
		WebDriver edge = new EdgeDriver();
		edge.get(e.APILink);
		String inpUserName = "username123";
		edge.findElement(By.id("inputUsername")).sendKeys(inpUserName);
		edge.findElement(By.cssSelector("input[type*='pass'")).sendKeys("rahulshettyacademy"); // tìm thẻ input có type LIKE "pass"
		edge.findElement(By.xpath("//button[contains(@class, 'submit')]")).click(); // tìm nút có class chứa cụm "submit"
		Thread.sleep(1000);

		// code xác thực Assertion giống trong postman Script
		Assert.assertEquals(edge.findElement(By.tagName("p")).getText(), "You are successfully logged in."); // xác thực text trong P
		Assert.assertEquals(edge.findElement(By.tagName("h2")).getText(), "Hello " + inpUserName + ","); // xác thực user trong h2

		Thread.sleep(1000);
		edge.findElement(By.xpath("//button[text()='Log Out']")).click(); // tìm nút có HTML inner text là Log Out

		Thread.sleep(1000);
		edge.quit();
	}

}
