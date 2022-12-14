import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;
import java.util.function.Function;

public class findElementsByClassName {
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
    @Test(priority = 1)
    public void findElements_ByClassName() {
        try {
            //Get the Web Element corresponding to the field tagname Input
            System.out.println("Starting the test case");
            Thread.sleep(2000);
            List<WebElement> allInputElements = driver.findElements(By.className("button"));
            if(allInputElements.size() != 0)
            {
                Thread.sleep(2000);
                System.out.println(allInputElements.size() + " Elements found by Class Name as input \n");

                for(WebElement inputElement : allInputElements)
                {
                    Thread.sleep(2000);
                    System.out.println(inputElement.getAttribute("placeholder"));
                }
            }

        }catch(Exception e){}
    }

    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();
        driver=null;
    }

}

