import org.openqa.selenium.By;
import org.testng.annotations.Test;
import java.time.Duration;

public class OrangeHRMPim extends OrangeHRMBrowser {
    @Test()
    public void addEmployee() {
        driver.findElement(By.xpath("(//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'])[2]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div/input")).sendKeys("Eder");
        driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys("1");
    }
}
