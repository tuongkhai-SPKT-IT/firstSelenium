package section7;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import firstSelenium.constantElement;

public class StaticDropdown {

	public static void main(String[] args) throws InterruptedException {

		// test Scenario: 2 Adult, 2 Child, 1 Infant, USD, From Bangkok TO Delhi (DEL)
		// Derpart: 20/02/2025 and return in 31/8

		constantElement e = new constantElement();
		System.setProperty(e.edgeString, e.WebDriveLink + e.edgeDriver);
		WebDriver edge = new EdgeDriver();
		edge.get(e.section7Link);
		edge.manage().window().maximize();

		WebElement staticDropdown = edge.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByIndex(3); // chọn USD trong dropdown

		edge.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
		edge.findElement(By.xpath("//a[@value = 'BLR']")).click(); // chọn điểm From: (BLR)
		Thread.sleep(2000); // cho thời gian chờ để dropdown load hết data và hiển thị ở TO
		// sau khi chọn from, thì dropdown của To se hiển thị luôn
		edge.findElement(By.xpath("(//a[@value = 'MAA'])[2]")).click(); // chọn điểm đi TO: (MAA)

		//
		// 06/2019 -> 02/2025
		//
		edge.findElement(By.id("ctl00_mainContent_view_date1")).click(); // mở datepicker Depart Date
		for (int i = 1; i <= 68; i++) {
			edge.findElement(By.xpath("//a[contains(@class, 'ui-datepicker-next ui-corner-all')]")).click();
		}
		// sau loop for trên ngày được chọn đang default là 5/5/2019 sẽ đến 02/2025
		edge.findElement(By.xpath("(//td[@data-month = '1' and @data-year = '2025'])[20]")).click(); // chọn ngày depart là 20/02/2025

		edge.findElement(By.id("ctl00_mainContent_view_date2")).click(); // mở datepicker return Date
		for (int i = 1; i <= 5; i++) { // đang tháng 3 nhấn next đến tháng 8
			edge.findElement(By.xpath("//a[contains(@class, 'ui-datepicker-next ui-corner-all')]")).click();
		}
		edge.findElement(By.xpath("(//td[@data-month = '7' and @data-year = '2025'])[31]")).click(); // chọn ngày 31/08/2025
		// data-month = tháng thật - 1, data-year = năm. index = ngày

		//
		// có 2 adult do mặc định có 1 adult nên chỉ click 1
		//
		edge.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(500);
		edge.findElement(By.id("hrefIncAdt")).click();
		// có 2 child
		edge.findElement(By.id("hrefIncChd")).click();
		edge.findElement(By.id("hrefIncChd")).click();
		// 1 Infant
		edge.findElement(By.id("hrefIncInf")).click();
		edge.findElement(By.id("btnclosepaxoption")).click();

		//
		// Confirm Scenario
		//
		try {

			// Xác thực From
			Assert.assertTrue(edge.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).getDomAttribute("value").contains("BLR"));
			// Xác thực TO
			Assert.assertTrue(edge.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).getDomAttribute("value").contains("MAA"));

			// xác thực PASSENGERS
			Assert.assertEquals(edge.findElement(By.id("divpaxinfo")).getText(), "2 Adult, 2 Child, 1 Infant");

			// xác thực Depart date và return date
			DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E, MMM dd yyyy"); // tạo format để ktra description
			LocalDateTime departInput = LocalDateTime.of(2025, 2, 20, 0, 0); // tạo ngày depart
			LocalDateTime returnInput = LocalDateTime.of(2025, 8, 31, 0, 0); // tạo ngày return
			Assert.assertEquals(edge.findElement(By.id("view_fulldate_id_1")).getText(), departInput.format(myFormatObj));
			Assert.assertEquals(edge.findElement(By.id("view_fulldate_id_2")).getText(), returnInput.format(myFormatObj));

			// xác thực radio button Round trip được checked
//			System.out.println(edge.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).getAttribute("checked").getClass());
			Assert.assertTrue(edge.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).isSelected());
			System.out.println(e.ANSI_GREEN_BACKGROUND + "Passed");
			edge.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();

		} catch (AssertionError err) {
			System.out.print(e.ANSI_RED_BACKGROUND + "Failed" + e.ANSI_RESET + " ");
			System.out.println("Informations is not correct");
			System.out.println(err);
		}
		edge.quit();
	}

}
