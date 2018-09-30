package first;

import org.apache.http.util.Asserts;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SevenTaskTest {
    private WebDriver driverchrome;
    private WebDriverWait wait;

    @Before
    public  void setUp() {
         driverchrome = new ChromeDriver();
        driverchrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
          //wait = new WebDriverWait(driverchrome, 15);
        // driverfirefox = new FirefoxDriver();
        // driverie = new InternetExplorerDriver();
    }

    @Test
    public void  one() throws InterruptedException {

        driverchrome.get("http://localhost/litecart/admin/");
        driverchrome.findElement(By.cssSelector("div#box-login input[name=username]")).sendKeys("admin");
        driverchrome.findElement(By.cssSelector("div#box-login input[name=password]")).sendKeys("admin");
        driverchrome.findElement(By.name("remember_me")).click();
        driverchrome.findElement(By.cssSelector("button[name=login]")).click();


       Integer size1 = driverchrome.findElements(By.cssSelector("div li#app-")).size();

       for (int i = 0; i < size1; i++) {
            List <WebElement> firstlevel = driverchrome.findElements(By.cssSelector("div li#app-"));
            WebElement firstlevelelement = firstlevel.get(i);
            firstlevelelement.click();
            driverchrome.findElement(By.cssSelector("h1")).isDisplayed();
            firstlevel = driverchrome.findElements(By.cssSelector("div li#app-"));
            firstlevelelement = firstlevel.get(i);
            Integer size2  = firstlevelelement.findElements(By.cssSelector("div li#app- li a")).size();
            if (size2 > 0){
                for (int j = 0; j < size2; j++) {
                    firstlevel = driverchrome.findElements(By.cssSelector("div li#app-"));
                    firstlevelelement = firstlevel.get(i);
                    List <WebElement> secondlevel = firstlevelelement.findElements(By.cssSelector("div li#app- li a"));
                    WebElement secondlevelelement = secondlevel.get(j);
                    secondlevelelement.click();
                    driverchrome.findElement(By.cssSelector("h1")).isDisplayed();
                }
            }


        }



    }

    @After
    public void finish() {
    //   driverchrome.quit();
    //   driverchrome = null;
    }
}
