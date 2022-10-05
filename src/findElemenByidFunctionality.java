import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

public class findElemenByidFunctionality {

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
        driver.get("http://demo.guru99.com/test/ajax.html");
        driver.manage().window().maximize();
    }
    @Test(priority = 1)
    public void findelement_By_id_Functionality() {
        try {

            //Get the Web Element corresponding to the field Email (Text field) and use sendkeys to pass the email to the field
            System.out.println("Starting the test case");
            // Find the radio button for “No” using its ID and click on it
            driver.findElement(By.id("no")).click();
            //Click on Check Button
            driver.findElement(By.id("buttoncheck")).click();
        }catch(Exception e){}
    }

    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();
        driver=null;
    }

}
