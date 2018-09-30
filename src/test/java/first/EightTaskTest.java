package first;

import jdk.nashorn.internal.AssertsEnabled;
import org.apache.http.util.Asserts;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class EightTaskTest {
    private WebDriver driverchrome;
    private WebDriverWait wait;

    @Before
    public  void setUp() {
        driverchrome = new ChromeDriver();
        driverchrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void  eight(){
        driverchrome.get("http://localhost/litecart/");
        List<WebElement> elements = driverchrome.findElements(By.cssSelector("div#box-most-popular .listing-wrapper li"));
        for (int i = 0; i < elements.size(); i++) {
            Integer count = elements.get(i).findElements(By.cssSelector("div.sticker")).size();
            Asserts.check(count==1, "More then one sticker!");

        }
    }

    @After
    public void finish() {
        driverchrome.quit();
        driverchrome = null;
    }
}
