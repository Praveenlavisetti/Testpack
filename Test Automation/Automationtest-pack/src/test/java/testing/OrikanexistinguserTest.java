package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.junit.Assert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class OrikanexistinguserTest {


    public static void main(String[] args) {

        String username= "betty@orikan.com";
        String password= "Test@135";

        WebDriver driver = new ChromeDriver();
        driver.get("https://orikan-ui-automation-test.azurewebsites.net/");
        driver.manage().window().maximize();

        driver.findElement(By.id("emailAddress")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("confirmPassword")).sendKeys(password);
        driver.findElement(By.xpath("/html/body/app-root/div/div[2]/app-register-wizard/div[3]/button")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("toast-message error active")));

        String toastmsg= driver.findElement(By.className("toast-message error active")).getText();
        String msg="Email address is already registered";
        //error message validation
        Assert.assertEquals(toastmsg, msg);
        System.out.println("TestCase passed");
        driver.quit();
        

    }

}
