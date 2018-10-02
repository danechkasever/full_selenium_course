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

public class NineTaskTest {
    private WebDriver driverchrome;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        driverchrome = new ChromeDriver();
        driverchrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void one() throws InterruptedException {

        driverchrome.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        driverchrome.findElement(By.cssSelector("div#box-login input[name=username]")).sendKeys("admin");
        driverchrome.findElement(By.cssSelector("div#box-login input[name=password]")).sendKeys("admin");
        driverchrome.findElement(By.name("remember_me")).click();
        driverchrome.findElement(By.cssSelector("button[name=login]")).click();

        Integer size1 = driverchrome.findElements(By.cssSelector(".row")).size();
        String name1 = "";

        for (int i = 0; i < size1; i++) {
            List<WebElement> row = driverchrome.findElements(By.cssSelector(".row"));
            WebElement element = row.get(i);
            WebElement column = element.findElements(By.cssSelector(".row td")).get(4);
            Integer zones = Integer.parseInt(element.findElements(By.cssSelector(".row td")).get(5).getAttribute("textContent"));
            String name2 = column.getAttribute("textContent");
            boolean comparing;
            if (name1.compareTo(name2) > 0) {
                comparing = false;
            } else {
                comparing = true;
            }
            Asserts.check(comparing, "wrong sorting");
            if (zones > 0) {
                column.findElement(By.cssSelector("a")).click();
                Integer size2 = driverchrome.findElements(By.cssSelector("#table-zones input[name*=name]")).size();
                String name3 = "";
                for (int j = 0; j < size2 - 1; j++) {
                    List<WebElement> row1 = driverchrome.findElements(By.cssSelector("#table-zones input[name*=name]"));
                    WebElement element1 = row1.get(j);
                    String name4 = element1.getAttribute("value");
                    boolean comparing1;
                    if (name3.compareTo(name4) > 0) {
                        comparing1 = false;
                    } else {
                        comparing1 = true;
                    }
                    Asserts.check(comparing1, "wrong sorting");
                }
                List<WebElement> firstlevel = driverchrome.findElements(By.cssSelector("div li#app-"));
                firstlevel.get(2).click();

            }


        }
        
    }

    @Test
    public void two() throws InterruptedException {

        driverchrome.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
        driverchrome.findElement(By.cssSelector("div#box-login input[name=username]")).sendKeys("admin");
        driverchrome.findElement(By.cssSelector("div#box-login input[name=password]")).sendKeys("admin");
        driverchrome.findElement(By.name("remember_me")).click();
        driverchrome.findElement(By.cssSelector("button[name=login]")).click();

        Integer size1 = driverchrome.findElements(By.cssSelector(".dataTable tr.row")).size();

        for (int i = 0; i < size1; i++) {
            List<WebElement> firstlevel = driverchrome.findElements(By.cssSelector(".dataTable tr.row"));
            WebElement firstlevelelement = firstlevel.get(i);
            firstlevelelement.findElements(By.cssSelector(".row td")).get(2).findElement(By.cssSelector("a")).click();

            Integer size2 = driverchrome.findElements(By.cssSelector("#table-zones select[name*=zone_code]")).size();
            String name3 = "";
            for (int j = 0; j < size2 - 1; j++) {
                List<WebElement> row1 = driverchrome.findElements(By.cssSelector("#table-zones select[name*=zone_code]"));
                WebElement element1 = row1.get(j);
                String name4 = element1.getAttribute("value");
                boolean comparing1;
                if (name3.compareTo(name4) > 0) {
                    comparing1 = false;
                } else {
                    comparing1 = true;
                }
                Asserts.check(comparing1, "wrong sorting");
            }
            List<WebElement> firstlevel2 = driverchrome.findElements(By.cssSelector("div li#app-"));
            firstlevel2.get(5).click();
        }
    }

    @After
    public void finish() {
        driverchrome.quit();
        driverchrome = null;
    }
}
