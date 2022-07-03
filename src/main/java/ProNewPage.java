import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProNewPage {

    WebDriver driver;

    public ProNewPage (WebDriver driver) {
        this.driver = driver;
    }

    private By header = By.xpath("//h1 [text() = \"Become a PRO User\"]"); //Заголовок страницы NotSurePage


    public String GetHeaderText () {
        return driver.findElement(header).getText();
    }
}
