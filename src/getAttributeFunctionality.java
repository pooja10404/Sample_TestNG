import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.function.Function;

public class getAttributeFunctionality {
    WebDriver driver;
    //Method to set up the browser and open the website
    @BeforeClass
    public void setUp() {
        File f = new File("tools");

        // Get the absolute path of file f
        String absolute = f.getAbsolutePath();
        System.setProperty("webdriver.chrome.driver", absolute+"//chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
    }
    @Test(priority = 1)
    public void get_Attribute_Functionality() {
        try {
            waitForPageLoad();
            Thread.sleep(2000);
            System.out.println("Starting the test case");
            // identify element with cssSelector
            WebElement userNameField = driver.findElement(By.cssSelector("input[name='username']"));
            userNameField.sendKeys("Admin");
            // identify element with cssSelector
            WebElement passWordField = driver.findElement(By.cssSelector("input[name='password']"));
            passWordField.sendKeys("admin123");
            // identify element with cssSelector
            WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
            loginButton.click();
            // identify element with linkText
            WebElement addEmployeeButton = driver.findElement(By.linkText("Add Employee"));
            addEmployeeButton.click();
            // identify element with cssSelector
            WebElement expectedTitle = driver.findElement(By.cssSelector("input.orangehrm-firstname"));
            // get text of a element in variable
            String expectedText = expectedTitle.getAttribute("name");
            // verify excepted and actual text
            Assert.assertEquals(expectedText, "firstName");
        }catch(Exception e){}
    }
    public void waitForPageLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver driver) {
                System.out.println("Current Window State       : "
                        + String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")));
                return String
                        .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
                        .equals("complete");
            }
        });
    }
    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();
        driver=null;
    }
}
