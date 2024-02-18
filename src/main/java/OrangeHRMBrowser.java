import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;

public class OrangeHRMBrowser {
    static WebDriver driver;

    @Parameters("browserName")
    @BeforeSuite
    public void Browser(String browserName) {
        switch (browserName) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "ff":
                driver = new FirefoxDriver();
                break;
            case "safary":
                driver = new SafariDriver();
                break;
            default:
                System.out.println("The Browser doesn't exist");
        }
        driver.manage().window().maximize();
    }

    @Parameters("url")
    @Test(priority = 1)
    public void LunchTheWebSait(String url) {
        driver.get(url);
       //String expected = driver.getCurrentUrl();
       //String actual = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
       //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
       //Assert.assertEquals(expected, actual, "The URL are not the same");
    }
    @Parameters({"Username","Password"})
    @Test(priority = 2)
    public void VerifyLogIn(String Username, String Password) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.name("username")).sendKeys(Username);
        driver.findElement(By.name("password")).sendKeys(Password);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}