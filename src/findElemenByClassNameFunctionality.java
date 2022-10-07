import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

public class findElemenByClassNameFunctionality {

    WebDriver driver;
    //Method to  up the browser and open the website
    @BeforeClass
    public void setUp() {
        File f = new File("tools");

        // Get the absolute path of file f
        String absolute = f.getAbsolutePath();
        System.out.println("absolute=="+absolute);
        System.setProperty("webdriver.chrome.driver", absolute+"//chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.tutorialspoint.com/videotutorials/subscription.php");
        driver.manage().window().maximize();
    }
    @Test(priority = 1)
    public void findElement_By_Class_Name_Functionality() {
        try {
            Thread.sleep(2000);
            // identify element with class
            WebElement search = driver.findElement(By.className("input"));
            search.sendKeys("javaScript");
            Thread.sleep(2000);
            String str = search.getAttribute("value");
            System.out.println("Attribute value is : " + str);
        }catch(Exception e){}
    }

    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();
        driver=null;
    }

}
