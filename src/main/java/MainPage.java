import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    static WebDriver driver;

    MainPage (WebDriver driver) {
        this.driver = driver;
    }

    private By LogInButton = By.xpath("//a [text() = \"Log in\"]");  //Кнопка LogIn
    private By WebSiteButton = By.xpath("//a [text() = \"Website\"]"); //Кнопка WebSite
    private By GetSertifiedButton = By.xpath("//a [text() = \"Get Certified\"]"); //Кнопка GetSertified
    private By ProNewButton = By.xpath("//a [text() = \"Pro \"]"); //Кнопка ProNew
    private By FieldButton = By.xpath("//input [@id = \"search2\"]");  //Поле ввода для поиска
    private By SearchButton = By.xpath("//i [@id = \"learntocode_searchicon\"]/parent::button [@type = \"button\"]"); //Кнопка поиска
    private By NotSureButton = By.xpath("//a [text() = \"Not Sure Where To Begin?\"]"); //Кнопка Not Sure Where To Begin?
    private By LogoButton = By.xpath("//i [@class = \"fa fa-logo\"]"); //Кнопка Логотипа Сайта

    //Клик по кнопке LogIn
    public LoginPage clickLoginIn () {
        driver.findElement(LogInButton).click();
        return new LoginPage(driver);
    }
    //Клик по кнопке WebSite
    public WebSitePage clickWebSiteButton () {
        driver.findElement(WebSiteButton).click();
        return new WebSitePage(driver);
    }
    //Клик по кнопке Get Sertified
    public GetSertifiedPage clickGetSertifiedButton () {
        driver.findElement(GetSertifiedButton).click();
        return new GetSertifiedPage(driver);
    }
    //Клик по кнопке Pro New
    public ProNewPage clickProNewPage () {
        driver.findElement(ProNewButton).click();
        return new ProNewPage(driver);
    }
    //Клик по форме поиска
    public MainPage clickFieldButton (String s) {
        driver.findElement(FieldButton).sendKeys(s);
        driver.findElement(SearchButton).click();
        return this;
    }
    //Клик по кнопке Not Sure Where To Begin?
    public NotSureWhereToBeginPage clickNotSurePageButton () {
        driver.findElement(NotSureButton).click();
        return new NotSureWhereToBeginPage(driver);
    }
    //Клик по логотипу
    public MainPage clickLogoButton () {
        driver.findElement(LogoButton).click();
        return this;
    }
}
