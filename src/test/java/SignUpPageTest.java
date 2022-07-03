import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SignUpPageTest {

    private WebDriver driver;
    private SignUpPage signUpPage;

    @Before
    public void startBeforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Project\\Desktop\\ProjectForGitHub\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://profile.w3schools.com/log-in?redirect_url=https%3A%2F%2Fmy-learning.w3schools.com");
        signUpPage = new SignUpPage(driver);
        signUpPage.SignUpClick();
    }

    //Регистрация с путыми полями почты и пароля
    @Test
    public void ClickRegistrationWithNullFields() {
        signUpPage.FieldEmailAndPassword("", "");
        String error = signUpPage.GetEmailErrorText();
        Assert.assertEquals("Please enter an email", error);
    }

    //Регистрация с корректной почтой, но коротким паролем
    @Test
    public void MinLengthPassword() {
        signUpPage.FieldEmailAndPassword("adfvfd@gmail.com", "asd");
        String error = signUpPage.GetMinLengthPasswordErrorText();
        Assert.assertEquals("8 characters minimum", error);
    }
    //Регистрация с корректной почтой, но некорректным паролем без цифр
    @Test
    public void OneNumberPassword() {
        signUpPage.FieldEmailAndPassword("adfvfd@gmail.com", "asdASD^@!");
        String error = signUpPage.GetIncorrectPasswordOneNumberErrorText();
        Assert.assertEquals("One number", error);
    }
    //Регистрация с корректной почтой, но некорректным паролем без букв нижнего регистра
    @Test
    public void OneLowerCaseCharacter () {
        signUpPage.FieldEmailAndPassword("adfvfd@gmail.com", "ASD123!@#");
        String error = signUpPage.GetIncorrectPasswordLowerCaseErrorText();
        Assert.assertEquals("One lowercase character", error);
    }

    //Успешная регистрация
    @Test
    public void CorrectRegistraion () {
        signUpPage.FieldEmailAndPassword("adfvfaggdfgdd@gmail.com", "ASD123!@#asd");
        signUpPage.ClickNameField("Marat", "Maratovich");
        String success = signUpPage.GetSuccessRegistration();
        Assert.assertEquals("Please verify email", success);
    }



    @Ignore
    public void AfterTest() {
        driver.quit();
    }
}