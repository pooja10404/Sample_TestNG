import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class findElemnets_Byid {
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
        driver.get("https://demoqa.com/text-box/");
        driver.manage().window().maximize();
    }
 @Test
    public void findElemnets_Byid(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:/testSelenium/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/text-box/");
        WebElement element = driver.findElement(By.id("submit"));


        if(element != null) {
            System.out.println("Element found by ID");
        }
    }


 @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();
        driver=null;
    }

}
