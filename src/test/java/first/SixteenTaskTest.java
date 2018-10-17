package first;

import jdk.nashorn.internal.parser.JSONParser;
import net.bytebuddy.asm.Advice;
import org.apache.http.util.Asserts;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

//@RunWith(Paralli

public class SixteenTaskTest {
    public static final String USERNAME = "daryashumakova1";
    public static final String AUTOMATE_KEY = "nYcZxNaN28sizMsA4x4N";
   // public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
    public static final String URL = "http://10.0.0.197:4443/wd/hub";
    private WebDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browserName", "chrome");
        //caps.setCapability("version", "69");
        // caps.setCapability("realMobile", "true");
        caps.setCapability("platforn", "WIN10");

        driver = new RemoteWebDriver(new URL(URL), caps);
    }

    @Test
    public  void test1() throws Exception {
        driver.get("http://www.google.com");
        WebElement element = driver.findElement(By.name("q"));

        element.sendKeys("BrowserStack");
        element.submit();



    }

    @Test
    public  void test12() throws Exception {
        //driver.get("http://www.yan.com");

        driver.get("http://www.yandex.ru");
        driver.findElement(By.cssSelector("input.input__control")).sendKeys("ХРЮ");
        driver.findElement(By.cssSelector("div.home-arrow__search button[class*=button_theme_websearch]")).click();



    }



    @After
    public  void finish() {
        System.out.println(driver.getTitle());
        driver.quit();
    }
}


