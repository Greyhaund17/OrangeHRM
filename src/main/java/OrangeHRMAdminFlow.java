import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

public class OrangeHRMAdminFlow extends OrangeHRMBrowser {
    @Test(dependsOnMethods = "VerifyLogIn")
    public void adminField() {
        driver.findElement(By.xpath("(//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'])[1]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys("Admin");
        driver.findElement(By.xpath("(//div[@class='oxd-select-text--after'])[1]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")).sendKeys("Ravi Arole");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        driver.findElement(By.xpath("(//button[@type='button'])[4]")).submit();
    }

    @Test(dependsOnMethods = "adminField")
    public void allCheckMarks() {
        List<WebElement> allCheckMark = driver.findElements(By.xpath("//i[@class='oxd-icon bi-check oxd-checkbox-input-icon']"));
        for (WebElement check : allCheckMark) {
            check.click();
        }
    }
}
