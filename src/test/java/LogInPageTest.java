import org.checkerframework.checker.units.qual.A;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LogInPageTest {

    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void startBeforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Project\\Desktop\\ProjectForGitHub\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://profile.w3schools.com/log-in?redirect_url=https%3A%2F%2Fmy-learning.w3schools.com");
        loginPage = new LoginPage(driver);
    }
    //Тест войти без заполнения полей почты и пароль
    @Test
    public void clickLogInWithNullFields() {
        loginPage.FieldsEmailAndPassword("", "");
        String error = loginPage.GetErrorEmail();
        Assert.assertEquals("Please enter an email", error);
    }
    //Тест ввод почты и клик войти
    @Test
    public void clickLogInWithEmail () {
        loginPage.FieldsEmailAndPassword("mail@mail.com", "");
        String error = loginPage.EnterPassword();
        Assert.assertEquals("Please enter your password.", error);
    }

    //Тест ввод пароля без почты и клик войти
    @Test
    public void clickLogInWithPassword () {
        loginPage.FieldsEmailAndPassword("", "sdfA2!@");
        String error = loginPage.GetErrorEmail();
        Assert.assertEquals("Please enter an email", error);
    }

    //Тест ввод некорректной почты и корректного пароля
    @Test
    public void clickLogInWithIncorrectEmail () {
        loginPage.FieldsEmailAndPassword("mail@gmail.", "asAS12!@%^");
        String error = loginPage.IncorrectEmail();
        Assert.assertEquals("Looks like you forgot something", error);
    }

    //Тест пользователь с данной почтой или паролей не найден в системе
    @Test
    public void clickUserNotFound () {
        loginPage.FieldsEmailAndPassword("bghbg3423324@gmai.commmmser", "hvdfHF^%!@*^126416541");
        String error = loginPage.UserNotFound();
        Assert.assertEquals("A user with this email does not exist", error);
    }

    //Тест проверки кнопки Forgot password?
    @Test
    public void clickResetPassword () {
     loginPage.ClickForgorPasswordButton();
     String error = loginPage.ResetYourPasswordText();
     Assert.assertEquals("Reset your password", error);
    }

    @Ignore
    public void afterTest() {
        driver.quit();
    }
}
