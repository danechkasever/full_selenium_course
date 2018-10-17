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

public class SeventeenTaskTest {
    private WebDriver driverchrome;
    private WebDriverWait wait;


    @Before
    public void setUp() {
        driverchrome = new ChromeDriver();
        driverchrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public Boolean IsElementExists(WebElement WL, String locator) {
        try {
            WL.findElement(By.cssSelector(locator));
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {

            return false;
        }
    }

    @Test
    public void test() {


        driverchrome.get("http://localhost/litecart/admin/");
        driverchrome.findElement(By.cssSelector("div#box-login input[name=username]")).sendKeys("admin");
        driverchrome.findElement(By.cssSelector("div#box-login input[name=password]")).sendKeys("admin");
        driverchrome.findElement(By.name("remember_me")).click();
        driverchrome.findElement(By.cssSelector("button[name=login]")).click();

        driverchrome.findElement(By.cssSelector("div li#app- a[href*=catalog]")).click();

        List<WebElement> listgoods = driverchrome.findElements(By.cssSelector("table.dataTable tr"));
        Integer size = driverchrome.findElements(By.cssSelector("table.dataTable tr")).size();
        Boolean T;
        System.out.println("size" + size);
        for (int i = 2; i < size - 1; i++) {
            listgoods = driverchrome.findElements(By.cssSelector("table.dataTable tr"));
            T = IsElementExists(listgoods.get(i), "i[class*=fa-folder]");

            if (T == true) {
                listgoods.get(i).findElements(By.cssSelector("td a[href*=category]")).get(0).click();
                size = driverchrome.findElements(By.cssSelector("table.dataTable tr")).size() - 1;
                System.out.println("size" + size);

            } else {
                listgoods.get(i).findElement(By.cssSelector("i[class*=fa-pencil]")).click();
                driverchrome.findElement(By.cssSelector("button[name=cancel]")).click();
                Asserts.check(driverchrome.manage().logs().get("browser").getAll().isEmpty(), "Some logs");
            }
            System.out.println(i);
        }
    }

    @After
    public void finish() {
        driverchrome.quit();
        driverchrome = null;
    }
}
