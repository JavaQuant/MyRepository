import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By FieldEmail = By.xpath("//input [@id = \"modalusername\"]");  //Поле Почта
    private By FieldPassword = By.xpath("//input [@id = \"current-password\"]"); //Поле пароля
    private By LogInButton = By.xpath("//span [text() = \"Log in\"]"); //Кнопка Логин
    private By ForgotPasswordButton = By.xpath("//a [text() = \"Forgot password?\"]"); //Кнопка forgorPassword
    private By ShowPasswordButton = By.xpath("//span [@class = \"PasswordInput_show_pwd_btn__Ncc9S\"]"); //Показать пароль
    private By SignUpButton = By.xpath("//span [text() = \" Sign up\"]"); //Кнопка SignUp
    private By LogoBarButton = By.xpath("//a [@href = \"https://w3schools.com\"]"); //Кнопка иконки сайта
    private By HeadingLogIn = By.xpath("//div [contains(@class, \"LoginModal_modal_inner__zNxJo\")]/div/h1"); //Шапка страницы логин с текстом Логин
    private By ErrorEmail = By.xpath("//span [text() = \"Please enter an email\"]"); //Ошибка ввода почты
    private By ErrorPassword = By.xpath("//div [text() = \"Please enter your password.\"]"); //Ошибка введите пароль
    private By IncorrectPassOrEmail = By.xpath("//div [text() = \"A user with this email does not exist\"]"); //Неверная почта или пароль
    private By LooksLikeEmailError = By.xpath("//span [text() = \"Looks like you forgot something\"]"); //Вы ввели не точную почту
    private By UserNotFound = By.xpath("//div [text() = \"A user with this email does not exist\"]"); //Пользователь с такими данными не найден
    private By ResetPassword = By.xpath("//h1 [text() = \"Reset your password\"]"); //Заголовок страницы восстановления пароля


    //Клик войти без ввода данных
    public LoginPage LoginButtonClick() {
        driver.findElement(LogInButton).click();
        return this;
    }

    //Ввод почты без пароля и клик войти
    public LoginPage FieldEmailClick(String email) {
        driver.findElement(FieldEmail).sendKeys(email);
        driver.findElement(LogInButton).click();
        return this;
    }

    //Ввод пароля
    public LoginPage FieldPasswordClick(String password) {
        driver.findElement(FieldPassword).sendKeys(password);
        driver.findElement(LogInButton);
        return this;
    }

    //Ввод почты и пароля и клик войти
    public LoginPage FieldsEmailAndPassword(String email, String password) {
        this.FieldEmailClick(email);
        this.FieldPasswordClick(password);
        driver.findElement(LogInButton).click();
        return this;
    }

    //Кнопка забыли пароль
    public LoginPage ClickForgorPasswordButton() {
        driver.findElement(ForgotPasswordButton).click();
        return this;
    }

    //Кнопка регистрации
    public SignUpPage SignUpClick() {
        driver.findElement(SignUpButton).click();
        return new SignUpPage(driver);
    }

    //Кнопка показать пароль
    public LoginPage ShowPasswordButtonClick() {
        driver.findElement(ShowPasswordButton).click();
        return this;
    }

    //Кнопка логотипа и переход
    public LoginPage LogoBarButtonCLick() {
        driver.findElement(LogoBarButton).click();
        return this;
    }

    //Получение текста ошибки поле Email не заполнено
    public String GetErrorEmail() {
        return driver.findElement(ErrorEmail).getText();
    }

    //Получение текста ошибки не заполненного поля пароль
    public String EnterPassword() {
        return driver.findElement(ErrorPassword).getText();
    }
    //Получение текста ошибки при некорретной почте, но корректным паролем
    public String IncorrectEmail () {
        return driver.findElement(LooksLikeEmailError).getText();
    }
    //Получение текста ошибки пользователь не найден
    public String UserNotFound () {
        return driver.findElement(UserNotFound).getText();
    }
    //Получение текста заголовка страницы восстановления пароля
    public String ResetYourPasswordText () {
        return driver.findElement(ResetPassword).getText();
    }
    //Получение текста заголовка страницы
    public String GetHeadingText () {
        return driver.findElement(HeadingLogIn).getText();
    }

    public String ErrorPassOrLogin () {
        return driver.findElement(IncorrectPassOrEmail).getText();
    }

}
