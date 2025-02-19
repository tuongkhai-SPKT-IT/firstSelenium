package section1To6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import firstSelenium.constantElement;

public class windowActivies {
	public static void main(String[] args) {
		constantElement e = new constantElement();
		System.setProperty(e.edgeString, e.WebDriveLink + e.edgeDriver);
		WebDriver edge = new EdgeDriver();

		edge.manage().window().maximize();
		edge.get(e.autoPracticeLink); // selenium sẽ chờ tất cả các component được hiển thị
		edge.navigate().to(e.APILink); // selenium chỉ chuyển qua trang không đợi load hết
		edge.navigate().back(); // selenium sẽ quay trở lại trang trước đó
		edge.navigate().forward();

		// fullscreen(); sẽ mở full screen như ấn f11
		// .maximize(); sẽ mở browser to ra
	}

}
