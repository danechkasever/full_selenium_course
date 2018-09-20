package first;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.annotation.Target;

public class MyFirstTest {
    private WebDriver driver;
    private WebDriverWait wait;
    @Before
    public  void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 15);
    }

    @Test
        public void loginCorrect() throws InterruptedException {
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("remember_me")).click();
        driver.findElement(By.name("login")).click();
        Thread.sleep(6000);
        driver.findElement(By.className("fa-sign-out")).click();
        driver.findElement(By.name("username")).isEnabled();

    }

    @Test
    public void loginIncorrect()  {
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin1");
        driver.findElement(By.name("login")).click();


    }

    @After
    public void finish() {
      driver.quit();
      driver = null;
    }

}
