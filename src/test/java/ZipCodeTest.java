import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ZipCodeTest {

    @Test
    public void test() {
        WebDriver browser=new ChromeDriver();
        browser.get("https://www.sharelane.com/cgi-bin/register.py");
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        browser.get("https://www.sharelane.com/cgi-bin/register.py");
        browser.findElement(By.name("zip_code")).sendKeys("1234");
        browser.findElement(By.cssSelector("[value=Continue]")).click();
        String errorMassage= browser.findElement(By.className("error_message")).getText();
        Assert.assertEquals(errorMassage,"Oops, error on page. ZIP code should have 5 digits");
        browser.quit();

    }
}
