import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.File;
import java.util.List;

import java.util.function.Function;

public class findElements_ByTagName {
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
    public void javascript_click() {
        try {
            Thread.sleep(3000);// Find elements using tag name
            // Find elements using tag name
            List<WebElement> allInputElements = driver.findElements(By.tagName("input"));

            if(allInputElements.size() != 0)
            {
                System.out.println(allInputElements.size() + " Elements found by TagName as input \n");

                for(WebElement inputElement : allInputElements)
                {
                    System.out.println(inputElement.getAttribute("placeholder"));
                }
            }
        }
        catch(Exception e){}
    }


    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();
        driver=null;
    }

}





