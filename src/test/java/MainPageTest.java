import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class MainPageTest {

    private WebDriver driver;
    private MainPage mainPage;
    private WebSitePage webSitePage;
    private GetSertifiedPage getSertifiedPage;
    private ProNewPage proNewPage;
    private NotSureWhereToBeginPage notSureWhereToBeginPage;

    @Before
    public void startBerofeTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Project\\Desktop\\ProjectForGitHub\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.w3schools.com/");
        mainPage = new MainPage(driver);
        webSitePage = new WebSitePage(driver);
        getSertifiedPage = new GetSertifiedPage(driver);
        proNewPage = new ProNewPage(driver);
        notSureWhereToBeginPage = new NotSureWhereToBeginPage(driver);
    }

    //Тест кнопки LogIn
    @Test
    public void logInTest() {
        LoginPage loginPage = mainPage.clickLoginIn();
        String heading = loginPage.GetHeadingText();
        Assert.assertEquals("Log in", heading);
    }

    //Тест кнопки WebSitePage
    @Test
    public void clickWebSitePage() {
        WebSitePage websitepage = mainPage.clickWebSiteButton();

        for (String s : driver.getWindowHandles()) {
            driver.switchTo().window(s);
        }

        String heading = websitepage.GetHeaderWebSitePageText();
        Assert.assertEquals("Create a Free Website", heading);
    }

    //Тест кнопки GetSertifiedPage
    @Test
    public void clickGetSertifiedPage() {
        GetSertifiedPage getsertifiedpage = mainPage.clickGetSertifiedButton();

        for (String s : driver.getWindowHandles()) {
            driver.switchTo().window(s);
        }

        String heading = getsertifiedpage.GetHeaderText();
        Assert.assertEquals("Already knowledgeable? Take the exam only and get certified faster.", heading);
    }

    //Тест кнопки ProNewPage
    @Test
    public void clickProNew() {
        ProNewPage pronewpage = mainPage.clickProNewPage();

        for (String s : driver.getWindowHandles()) {
            driver.switchTo().window(s);
        }

        String heading = pronewpage.GetHeaderText();
        Assert.assertEquals("Become a PRO User", heading);
    }

    //Тест кнопки Not Sure Where To Begin?
    @Test
    public void clickNotSurePage () {
        NotSureWhereToBeginPage notsure = mainPage.clickNotSurePageButton();
        String heading = notsure.GetNotSureText();
        Assert.assertEquals("Where To Start", heading);
    }


    @Ignore
    public void afterTest() {
        driver.quit();
    }

}
