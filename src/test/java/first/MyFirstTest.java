package first;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class MyFirstTest {
    private WebDriver driverchrome;
    private WebDriver driverfirefox;
    private WebDriver driverie;
    private WebDriverWait wait;
    @Before
    public  void setUp() {
       // driverchrome = new ChromeDriver();
     //   wait = new WebDriverWait(driverchrome, 15);
       // driverfirefox = new FirefoxDriver();
       // driverie = new InternetExplorerDriver();
    }

    @Test
        public void loginCorrect() throws InterruptedException {
        driverchrome = new ChromeDriver();
        driverchrome.get("http://localhost/litecart/admin/");
        driverchrome.findElement(By.name("username")).sendKeys("admin");
        driverchrome.findElement(By.name("password")).sendKeys("admin");
        driverchrome.findElement(By.name("remember_me")).click();
        driverchrome.findElement(By.name("login")).click();
        Thread.sleep(6000);
        driverchrome.findElement(By.className("fa-sign-out")).click();
        driverchrome.findElement(By.name("username")).isEnabled();

    }

    @Test
    public void loginIncorrect()  {
        driverchrome.get("http://localhost/litecart/admin/");
        driverchrome.findElement(By.name("username")).sendKeys("admin");
        driverchrome.findElement(By.name("password")).sendKeys("admin1");
        driverchrome.findElement(By.name("login")).click();
    }

    @Test
    public void loginFF() throws InterruptedException {
        driverfirefox = new FirefoxDriver();
        driverfirefox.get("http://localhost/litecart/admin/");
        driverfirefox.findElement(By.name("username")).sendKeys("admin");
        driverfirefox.findElement(By.name("password")).sendKeys("admin");
        driverfirefox.findElement(By.name("remember_me")).click();
        driverfirefox.findElement(By.name("login")).click();
        Thread.sleep(6000);
        driverfirefox.findElement(By.className("fa-sign-out")).click();
        driverfirefox.findElement(By.name("username")).isEnabled();
    }

    @Test
    public void loginIE() throws InterruptedException {
        driverie = new InternetExplorerDriver();
        driverie.get("http://localhost/litecart/admin/");
        driverie.findElement(By.name("username")).sendKeys("admin");
        driverie.findElement(By.name("password")).sendKeys("admin");
        driverie.findElement(By.name("remember_me")).click();
        driverie.findElement(By.name("login")).click();
        Thread.sleep(6000);
        driverie.findElement(By.className("fa-sign-out")).click();
        driverie.findElement(By.name("username")).isEnabled();
    }

    @Test
    public void loginFFold() throws InterruptedException {
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary(new FirefoxBinary(new File("c:\\Program Files\\Firefox Nightly\\firefox.exe")));
        WebDriver driver = new FirefoxDriver(options);
        driver.get("http://localhost/litecart/admin/");
    }

    @After
    public void finish() {
      driverchrome.quit();
      driverchrome = null;
    }

}
