import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class MainClass {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Project\\Desktop\\ProjectForGitHub\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.w3schools.com/");


    }
}
