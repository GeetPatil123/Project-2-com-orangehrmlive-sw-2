package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl = "https://opensource-demo.orangehrmlive.com/ ";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //Find the email field element
        WebElement emailField = driver.findElement(By.name("username"));
        //Type the email address to email field element
        emailField.sendKeys("Admin");
        //Find the password field element and send password on password field
        driver.findElement(By.name("password")).sendKeys("admin123");
        //Find the login button element and click
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        String expectedText = "Dashboard";
        String actualText = driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")).getText();
        Assert.assertEquals("User not login unsuccessfully",expectedText,actualText);
    }


    @After
    public void tearDown() {
        closeBrowser();
    }

}
