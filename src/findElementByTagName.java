import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class findElementByTagName {
    WebDriver driver;
    //Method to set up the browser and open the website
    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C://Users//Pooja//Demo_TestNG_Project//tools//chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
    }
    @Test(priority = 2)
    public void find_Element_ByName() {
        try {
            //Get the Web Element corresponding to the field Email (Text field) and use sendkeys to pass the email to the field
            System.out.println("Starting the test case");
            // identify element with find element by name
            driver.findElement(By.name("username")).sendKeys("Admin");
            // identify element with find element by name
            WebElement passWordField = driver.findElement(By.name("password"));
            passWordField.sendKeys("admin123");
            //Get the Web Element corresponding Login button and click it
            WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
            Thread.sleep(2000);
            loginButton.click();
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
