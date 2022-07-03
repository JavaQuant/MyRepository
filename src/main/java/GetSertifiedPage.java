import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GetSertifiedPage {

    WebDriver driver;

    public GetSertifiedPage (WebDriver driver) {
        this.driver = driver;
    }

    private By heading = By.xpath("//header [@class = \"optimize-banner-p13n\"]/p/a[1]"); //Текст заголовка страницы SertifiedPage

    public String GetHeaderText () {
        return driver.findElement(heading).getText();
    }
}
