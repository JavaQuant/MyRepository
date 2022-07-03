import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
    WebDriver driver;

    public SignUpPage (WebDriver driver) {
        this.driver = driver;
    }

    private By HeadingSignUp = By.xpath("//div [@class = \"LoginModal_modal_inner__zNxJo \"]//h1 [text() = \"Sign up\"]"); //Заголовок регистрации
    private By FieldEmail = By.xpath("//input [@id = \"modalusername\"]"); //Поле почты
    private By FieldPassword = By.xpath("//input [@id = \"new-password\"]"); //Поле пароля
    private By SignUpForFreeButton = By.xpath("//span [text() = \"Sign up for free\"]/parent::button"); //Кнопка регистрации
    private By SignUpButton = By.xpath("//span [text() = \" Sign up\"]"); //Кнопка SignUp
    private By EnterEmailError = By.xpath("//span [text() = \"Please enter an email\"]"); //Введите почту
    private By IncorrectEmailError = By.xpath("//span [text() = \"Looks like you forgot something\"]"); //Некорректная почта
    private By IncorrectPasswordMin8 = By.xpath("//li [text() = \"8 characters minimum\"]"); //Минимальная длина пароля 8 сим
    private By IncorrectPasswordSymbols = By.xpath("//li [text() = \"One special character\"]"); //Пароль должен содержать символы
    private By IncorrectPasswordLowerCase = By.xpath("//li [text() = \"One lowercase character\"]"); //Пароль должен содержать буквы нижнего регистра
    private By IncorrectPasswordUpperCase = By.xpath("//li [text() = \"One uppercase character\"]"); //Пароль должен сожержать буквы верхнего регистра
    private By IncorrectPasswordOneNumber = By.xpath("//li [text() = \"One number\"]"); //Пароль должен содержать хотя-бы одну цифру
    private By FirstNameField = By.xpath("//input [@id = \"modal_first_name\"]"); //Поле ввода имени
    private By LastNameField = By.xpath("//input [@id = \"modal_last_name\"]"); //Поле ввода фамилии
    private By Continue = By.xpath("//span [text() = \"Continue\"]"); //Кнопка продолжить
    private By EnterName = By.xpath("//span [text() = \"Add a name that only contains letters - and no special characters.\"]"); //Ошибка при не заполненной форме имени
    private By EnterLastName = By.xpath("//span [text() = \"Add a name that only contains letters - and no special characters.\"]"); //Ошибка при не заполненной форме фамилии
    private By PleaseVerifyEmail = By.xpath("//h1 [text() = \"Please verify email\"]"); //Заголовок успешной регистрации
    private By HeaderNameLastName = By.xpath("//h1 [text() = \"What is your name?\"]"); //Заголовок страницы с вводом имени и фамилии
    private By LogInClick = By.xpath("//span [text() = \" Log in\"]"); //Кнопка войти

    //Кнопка регистрации
    public SignUpPage SignUpClick() {
        driver.findElement(SignUpButton).click();
        return this;
    }

    //Клик по форме ввода почты
    public SignUpPage ClickFieldEmail (String email) {
        driver.findElement(FieldEmail).sendKeys(email);
        return this;
    }
    //Клик по форме ввода пароля
    public SignUpPage ClickFieldPassword (String password) {
        driver.findElement(FieldPassword).sendKeys(password);
        return this;
    }
    //Клик по формам ввода почты и пароля и кнопки регистрации
    public SignUpPage FieldEmailAndPassword (String email, String password) {
        this.ClickFieldEmail(email);
        this.ClickFieldPassword(password);
        driver.findElement(SignUpForFreeButton).click();
        return this;
    }
    //Клик по формама ввода имени и фамилии и кнопки завершения регистрации
    public SignUpPage ClickNameField (String name, String lastName) {
        driver.findElement(FirstNameField).sendKeys(name);
        driver.findElement(LastNameField).sendKeys(lastName);
        driver.findElement(Continue).click();
        return this;
    }
    //Клик по кнопке войти
    public LoginPage ClickLogin () {
        driver.findElement(LogInClick).click();
        return new LoginPage(driver);
    }
    //Получение текста заголовка страницы регистрации
    public String GetHeadingText () {
        return driver.findElement(HeadingSignUp).getText();
    }
    //Получение текста ошибки при не заполненной форме почты
    public String GetEmailErrorText () {
        return driver.findElement(EnterEmailError).getText();
    }
    //Получение текста ошибки при вводе некорректной почты
    public String GetIncorrectEmailErrorText () {
        return driver.findElement(IncorrectEmailError).getText();
    }
    //Получение текста ошибки при вводе пароля недостаточной длины
    public String GetMinLengthPasswordErrorText () {
        return driver.findElement(IncorrectPasswordMin8).getText();
    }
    //Получение текста ошибки при вводе пароля без символов
    public String GetPasswordSymbolsErrorText () {
        return driver.findElement(IncorrectPasswordSymbols).getText();
    }
    //Получение текста ошибки при вводе пароля не содержащего букв нижнего регистра
    public String GetIncorrectPasswordLowerCaseErrorText () {
        return driver.findElement(IncorrectPasswordLowerCase).getText();
    }
    //Получение текста ошибки при вводе пароля не содержащих букв верхнего регистра
    public String GetIncorrectPasswordUpperCaseErrorText () {
        return driver.findElement(IncorrectPasswordUpperCase).getText();
    }
    //Получение текста ошибки при вводе пароля не содержащих ни одной цифры
    public String GetIncorrectPasswordOneNumberErrorText () {
        return driver.findElement(IncorrectPasswordOneNumber).getText();
    }
    //Получение текста заголовка успешной регистрации
    public String GetSuccessRegistration () {
        return driver.findElement(PleaseVerifyEmail).getText();
    }


}
