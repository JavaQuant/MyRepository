import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebSitePage {
    WebDriver driver;

    public WebSitePage(WebDriver driver) {
        this.driver = driver;
    }

    private By HeaderWebSitePage = By.xpath("//h1 [text() = \"Create a Free Website\"]"); //Заголовок страницы WebSitePage


    public String GetHeaderWebSitePageText() {
        return driver.findElement(HeaderWebSitePage).getText();
    }
}
