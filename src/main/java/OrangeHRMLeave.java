import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.time.Duration;

public class OrangeHRMLeave extends OrangeHRMBrowser{
    @Test (dependsOnMethods = "LunchTheWebSait")
    public void employeeSearch(){
        driver.findElement(By.xpath("//a[@class='oxd-main-menu-item active']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.xpath("//div[@class='oxd-autocomplete-text-input oxd-autocomplete-text-input--active']")).sendKeys("Admin");
        driver.findElement(By.xpath("(//span[@class='oxd-switch-input oxd-switch-input--active --label-right'])[1]")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        boolean visibility=driver.findElement(By.linkText("//span[text()='Invalid']")).isDisplayed();
        System.out.println(visibility);
    }
}
