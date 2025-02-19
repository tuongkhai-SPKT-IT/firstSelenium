package section1To6;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import firstSelenium.constantElement;

public class SeleniumIntroduction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		constantElement e = new constantElement();
		// Microsoft Edge
		System.setProperty("webdriver.edge.driver", e.WebDriveLink + e.edgeDriver);
		WebDriver edge = new EdgeDriver();

		edge.get(e.APILink);
		try {
			edge.findElement(By.id("inputUsername")).sendKeys("username123"); // nhập tên bằng id
			edge.findElement(By.name("inputPassword")).sendKeys("password"); // nhập pass bằng name
			edge.findElement(By.className("signInBtn")).click(); // nhấn nút login bằng classname
			// rahulshettyacademy

			edge.manage().timeouts().implicitlyWait(Duration.ofSeconds(2)); // timeout để chờ web phản hồi
//			String test = edge.findElement(By.cssSelector("p.error")).getText(); // lấy text để thông báo lỗi
//			System.out.println(test); // in câu thông báo lỗi

			edge.findElement(By.linkText("Forgot your password?")).click(); // nhấn vào quên password

			edge.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("username123"); // nhập tên bằng Xpath placeholder
			edge.findElement(By.xpath("//input[@placeholder='Name']")).clear(); // xoá text của Name
			edge.findElement(By.xpath("//input[@type='text'][1]")).sendKeys("username123"); // nhập tên bằng Xpath type và sử dụng array index để trỏ đúng
			edge.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("test123@gmail.com"); // nhập email bằng css Selector
			edge.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("0123456789"); // nhập sđt Xpath
			edge.findElement(By.className("reset-pwd-btn")).click(); // nhấn nút quên mật khẩu

			String resetInfo = edge.findElement(By.cssSelector("form p")).getText(); // lấy text để thông báo lỗi

			// cắt resetInfo thành các mảng String phân cách bằng dấu '
			String tempPass = resetInfo.split("'")[1]; // resetInfo.substring(resetInfo.indexOf("'") + 1, resetInfo.lastIndexOf("'"));

			edge.findElement(By.className("go-to-login-btn")).click();

			// login lại sau khi đã có mật khẩu mới
			Thread.sleep(1000); // chờ nó hiển thị form login
			edge.findElement(By.id("inputUsername")).sendKeys("username123");
			edge.findElement(By.cssSelector("input[type*='pass'")).sendKeys(tempPass); // tìm thẻ input có type LIKE "pass"
			edge.findElement(By.xpath("//button[contains(@class, 'submit')]")).click(); // tìm nút có class chứa cụm "submit"

			// kiểm tra login
			Thread.sleep(1000); // chờ nó hiển thị form login
			String message = edge.findElement(By.cssSelector("div.login-container p")).getText(); // lấy text
			if (message.equals("You are successfully logged in.")) {
				System.out.println(message);
				edge.quit(); // tắt edge
			} else {
				System.out.println(message);
			}

		} catch (

		Exception err) {
			System.out.println(err.getMessage());

		}

//		edge.quit();
	}

}
