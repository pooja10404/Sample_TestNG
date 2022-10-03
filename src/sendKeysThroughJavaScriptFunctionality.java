import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

public class sendKeysThroughJavaScriptFunctionality {

    WebDriver driver;
    //Method to set up the browser and open the website
    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C://Users//Pooja//jar files//chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
    }
    @Test(priority = 1)
    public void Send_Key_Java_Script() {
        try {
            waitForPageLoad();
            Thread.sleep(3000);
            //Get the Web Element corresponding to the field Email (Text field) and use sendkeys through JavascriptExecutor to pass the email to the field
            System.out.println("Starting the test case");
            JavascriptExecutor jse = ((JavascriptExecutor)driver);
            WebElement email =  driver.findElement(By.cssSelector("input[name='username']"));
            jse.executeScript("arguments[0].value='Admin';", email);
            //Get the Web Element corresponding to the Password Field
            WebElement passWordField = driver.findElement(By.cssSelector("input[name='password']"));
            jse.executeScript("arguments[0].value='admin123';", passWordField);
            //Get the Web Element corresponding Login button and click it
            WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
            loginButton.click();
//            Thread.sleep(3000);
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
