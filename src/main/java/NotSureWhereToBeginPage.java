import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NotSureWhereToBeginPage {

    WebDriver driver;

    public NotSureWhereToBeginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By notSure = By.xpath("//h1 [text() = \"Where To Start\"]"); //Заголовок страницы Not Sure Where To Begin?

    public String GetNotSureText () {
        return driver.findElement(notSure).getText();
    }
}
