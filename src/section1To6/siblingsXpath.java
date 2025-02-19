package section1To6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import firstSelenium.constantElement;

public class siblingsXpath {

	public static void main(String[] args) {
		// từ parent to child => trên xuống, header to bottom
		constantElement e = new constantElement();
		System.setProperty(e.edgeString, e.WebDriveLink + e.edgeDriver);
		WebDriver edge = new EdgeDriver();

		edge.get(e.autoPracticeLink);
		// Sibling child

		// cấu trúc là header chứa div, div chứa 3 nút và 1 thẻ a href
		// header/div/button[1]/following-sibling::button --> xPath từ cha
		// header -> div -> button (1 thẻ bất kì) => /following-sibling::
		// (chú ý 2 chấm, và dấu /)
		// sau 2 chấm sẽ là thẻ đối tượng mà muốn tìm kiếm cùng cấp

		// VD: cấu trúc là header chứa div, div chứa 3 nút và 1 thẻ a href
		// header => div => a và 3 button đồng cấp
		edge.findElements(By.xpath("//header/div/a/following-sibling::button")).forEach(t -> breakElements(t));
		edge.quit();
	}

	private static void breakElements(WebElement item) {
		System.out.println(item.getText());
	};

}
