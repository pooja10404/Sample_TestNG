import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class findElemenByidFunctionality {

    WebDriver driver;
    //Method to set up the browser and open the website
    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C://Users//Pooja//jar files//chromedriver.exe");
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
