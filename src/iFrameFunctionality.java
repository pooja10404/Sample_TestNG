import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class iFrameFunctionality {

    WebDriver driver;
    //Method to set up the browser and open the website
    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C://Users//Pooja//Demo_TestNG_Project//tools//chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://demo.guru99.com/test/guru99home/");
        driver.manage().window().maximize();
    }
    @Test(priority = 1)
    public void iframe_Functionality() {
           driver.switchTo().frame("a077aa5e"); //switching the frame by ID
           System.out.println("********We are switch to the iframe*******");
           //Clicks the img
           driver.findElement(By.xpath("html/body/a/img")).click();
           System.out.println("*********We are done***************");
        }

    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();
        driver=null;
    }

}
