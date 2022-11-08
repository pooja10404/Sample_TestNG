import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.util.function.Function;

public class java_script_click {
    WebDriver driver;
    //Method to set up the browser and open the website
    @BeforeClass
    public void setUp() {
        File f = new File("tools");

        // Get the absolute path of file f
        String absolute = f.getAbsolutePath();
        System.out.println("absolute=="+absolute);
        System.setProperty("webdriver.chrome.driver", absolute+"//chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
    }
    @Test
    public void javascript_click() {
        try {
            Thread.sleep(2000);
            //Get the Web Element corresponding to the field Email (Text field) and use sendkeys to pass the email to the field
            System.out.println("Starting the test case");
            driver.findElement(By.cssSelector("input[name='username']")).sendKeys("Admin");
            //Get the Web Element corresponding to the Password Field
            WebElement passWordField = driver.findElement(By.cssSelector("input[name='password']"));
            passWordField.sendKeys("admin123");
            //Get the Web Element corresponding Login button and click it
            WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
            loginButton.click();
            Thread.sleep(2000);
            //JAVAscript CLick
            WebElement menu_item3=driver.findElement(By.linkText("Leave"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            Thread.sleep(2000);
            js.executeScript("arguments[0].click();", menu_item3);
            Thread.sleep(2000);
        }catch(Exception e){}
    }


    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();
        driver=null;
    }

}
