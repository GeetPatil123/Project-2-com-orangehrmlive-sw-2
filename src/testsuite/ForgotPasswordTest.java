package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class ForgotPasswordTest extends BaseTest {

    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before // JUnit Annotation which will run before every method
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test // JUnit Annotation which will allow executing this method
    public void userShouldNavigateToForgotPasswordPageSuccessfully() {
        driver.findElement(By.xpath("//p[@class = 'oxd-text oxd-text--p orangehrm-login-forgot-header']")).click(); // Find Forgot Password Link and click on it
        String expectedMessage = "Reset Password"; // Expected message given from requirement
        String actualMessage = driver.findElement(By.xpath("//h6[@class ='oxd-text oxd-text--h6 orangehrm-forgot-password-title']")).getText();// Finding Reset Password text element and getting the text
        Assert.assertEquals("User was not navigated to the page",actualMessage,expectedMessage);
    }
    @After // JUnit Annotation which will run after every method
    public void tearDown() {
        closeBrowser();
    }
}
