package first;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.annotation.Target;

public class MyFirstTest {
    private WebDriver driver;
    private WebDriverWait wait;
    @Before
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 15);
    }

    @Test
    public void firstTest() {
        driver.get("https://www.yandex.ru/");

    }

    @After
    public  void finish() {
        driver.quit();
        driver = null;
    }

}
