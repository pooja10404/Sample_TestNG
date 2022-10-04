import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class findElemenByClassNameFunctionality {

    WebDriver driver;
    //Method to set up the browser and open the website
    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C://Users//Pooja//Demo_TestNG_Project//tools//chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.tutorialspoint.com/videotutorials/subscription.php");
        driver.manage().window().maximize();
    }
    @Test(priority = 1)
    public void findElement_By_Class_Name_Functionality() {
        try {

            // identify element with class
            WebElement search = driver.findElement(By.className("input"));
            search.sendKeys("javaScript");
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
