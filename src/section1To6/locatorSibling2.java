package section1To6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import firstSelenium.constantElement;

public class locatorSibling2 {

	public static void main(String[] args) {
		// từ child to parent => trên xuống, bottom to header
		constantElement e = new constantElement();
		System.setProperty(e.edgeString, e.WebDriveLink + e.edgeDriver);
		WebDriver edge = new EdgeDriver();

		edge.get(e.autoPracticeLink);
		// Sibling parent

		edge.findElements(By.xpath("//header/div/button[3]/parent::div")).forEach(t -> breakElements(t));
//		edge.quit();
	}

	private static void breakElements(WebElement item) {
		System.out.println(item.getAttribute("style"));
	};

}
