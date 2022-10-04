import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.function.Function;


public class Simple_Clicks {
    WebDriver driver;
    //Method to set up the browser and open the website
    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C://Users//pooja//IdeaProjects//Sample_TestNG//tools//chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
    }
    @Test(priority = 2)
    public void click() {
        try {
            waitForPageLoad();
            Thread.sleep(3000);
            //Get the Web Element corresponding to the field Email (Text field) and use sendkeys to pass the email to the field
            System.out.println("Starting the test case");
            driver.findElement(By.cssSelector("input[name='username']")).sendKeys("Admin");
            //Get the Web Element corresponding to the Password Field
            WebElement passWordField = driver.findElement(By.cssSelector("input[name='password']"));
            passWordField.sendKeys("admin123");
            //Get the Web Element corresponding Login button and click it
            WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
            loginButton.click();
            WebElement menu_item= driver.findElement(By.linkText("Admin"));
            menu_item.click();
        }catch(Exception e){}
    }


    public void waitForPageLoad() {
        WebDriverWait wait = new WebDriverWait(driver, 30L);
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
