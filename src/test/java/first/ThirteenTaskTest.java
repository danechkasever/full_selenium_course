package first;

import net.bytebuddy.utility.RandomString;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class ThirteenTaskTest {
    private WebDriver driverchrome;
    private WebDriverWait wait;
    private java.net.Proxy proxy;

    public static String generateString(int count) {
        return RandomString.make(count);
    }

    public void regestration(){
        driverchrome.get("http://localhost/litecart/");
        driverchrome.findElement(By.cssSelector("div.content td a")).click();
        String firstname = generateString(10);
        String lastname = generateString(10);
        String adress = generateString(10);
        String postcode = "12345";
        String city = generateString(10);
        String phone = "12345234";
        String password = generateString(8);
        String email = generateString(10) + "@gmail.com";
        driverchrome.findElement(By.cssSelector("[name=firstname]")).sendKeys(firstname);
        driverchrome.findElement(By.cssSelector("[name=lastname]")).sendKeys(lastname);
        driverchrome.findElement(By.cssSelector("[name=address1]")).sendKeys(adress);
        driverchrome.findElement(By.cssSelector("[name=postcode]")).sendKeys(postcode);
        driverchrome.findElement(By.cssSelector("[name=city]")).sendKeys(city);
        Select select = new Select(driverchrome.findElement(By.name("country_code")));
        select.selectByValue("US");
        driverchrome.findElement(By.cssSelector("[name=email]")).sendKeys(email);
        driverchrome.findElement(By.cssSelector("[name=phone]")).sendKeys(phone);
        driverchrome.findElement(By.cssSelector("[name=password]")).sendKeys(password);
        driverchrome.findElement(By.cssSelector("[name=confirmed_password]")).sendKeys(password);
        driverchrome.findElement(By.cssSelector("button[type=submit]")).click();
    }
    @Before
    public  void setUp() {
       // Proxy proxy = new Proxy();
        //proxy.setHttpProxy("localhost:8888");
       // DesiredCapabilities caps = new DesiredCapabilities();
       // caps.setCapability("proxy", proxy);
       // driverchrome = new ChromeDriver(caps);
        driverchrome = new ChromeDriver();
       wait = new WebDriverWait(driverchrome,12);
    }
    @Test
    public void  thirteen() throws InterruptedException {driverchrome.get("http://localhost/litecart/");
        regestration();
        Integer qs=0;
        while (qs<3) {
            List<WebElement> listproducts = driverchrome.findElements(By.cssSelector("div#box-most-popular ul.listing-wrapper li"));
            listproducts.get(0).click();

            WebElement quantity = driverchrome.findElement(By.cssSelector("span.quantity"));

            Integer q = Integer.parseInt(quantity.getAttribute("textContent"));
            driverchrome.findElement(By.cssSelector("button[name=add_cart_product]")).click();
            qs = (q + 1);

            wait.until(ExpectedConditions.attributeToBe(quantity, "textContent", qs.toString()));
            quantity = driverchrome.findElement(By.cssSelector("span.quantity"));
            System.out.println(quantity.getAttribute("textContent"));
            driverchrome.findElement(By.cssSelector("div#logotype-wrapper")).click();
        }
        driverchrome.findElement(By.cssSelector("div#cart-wrapper .link")).click();
        Integer count = driverchrome.findElements(By.cssSelector("div.viewport li")).size();
        while (count>0) {
            List<WebElement> els = driverchrome.findElements(By.cssSelector("div.viewport li"));
            WebElement rem = els.get(0).findElement(By.cssSelector("button[name=remove_cart_item]"));
            wait.until((ExpectedConditions.elementToBeClickable(rem)));
            rem.click();
            List<WebElement> list = driverchrome.findElements(By.cssSelector("ul.shortcuts li"));
            if (list.size()>0) {wait.until(ExpectedConditions.stalenessOf(list.get(count-1)));}else
            {wait.until(ExpectedConditions.stalenessOf(els.get(count-1)));}
            count = driverchrome.findElements(By.cssSelector("div.viewport li")).size();
            System.out.println(count);
        }

    }

    @After
    public void finish() {
        driverchrome.quit();
       driverchrome = null;

    }
}
