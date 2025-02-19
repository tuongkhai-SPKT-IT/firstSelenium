package section7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import firstSelenium.constantElement;

public class AutoSuggestiveDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		constantElement e = new constantElement();
		System.setProperty(e.edgeString, e.WebDriveLink + e.edgeDriver);
		WebDriver edge = new EdgeDriver();
		edge.get(e.section7Link);
		edge.manage().window().maximize();

		// handle auto suggest when input word dropdown
//		edge.findElement(By.id("autosuggest")).sendKeys("ind");
//		Thread.sleep(3000);
//		List<WebElement> options = edge.findElements(By.cssSelector("li[class ='ui-menu-item'] a"));
//
//		for (var option : options) {
//			if (option.getText().equalsIgnoreCase("India")) {
//				option.click();
//				break;
//			}
//		}

		// handle checkbox
		edge.findElement(By.cssSelector("input[id='ctl00_mainContent_chk_SeniorCitizenDiscount']")).click();
		System.out.println(edge.findElement(By.cssSelector("input[id='ctl00_mainContent_chk_SeniorCitizenDiscount']")).isSelected());
		edge.findElement(By.cssSelector("input[id='ctl00_mainContent_chk_SeniorCitizenDiscount']")).click();
		System.out.println(edge.findElement(By.cssSelector("input[id='ctl00_mainContent_chk_SeniorCitizenDiscount']")).isSelected());

		System.out.println(edge.findElements(By.cssSelector("input[type ='checkbox']")).size());

		edge.quit();
	}

}
