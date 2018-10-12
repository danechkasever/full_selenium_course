package first;

import net.bytebuddy.utility.RandomString;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ElevenTaskTest {
    private WebDriver driverchrome;
    private WebDriverWait wait;
   /* public ExpectedCondition<Boolean> thereIsWindowOtherThan(Set<String> set) {
        java.lang.Object[] oldwindows = set.toArray();

        java.lang.Object[] newwindows = driverchrome.getWindowHandles().toArray();
        for (int i = 0; i < newwindows.length; i++) {
            for (int j = 0; j < oldwindows.length; j++) {
                if (newwindows[i].toString().equals(oldwindows[j].toString())) {
                    break;
                } else if (j == oldwindows.length - 1) {
                    // return true;
                    return true;
                }
            }
        }

    }*/


    public static String generateString(int count) {
        return RandomString.make(count);
    }

    @Before
    public void setUp() {
        driverchrome = new ChromeDriver();
        driverchrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void one() throws InterruptedException {
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
        driverchrome.findElement(By.cssSelector("div#box-account a[href*=logout]")).click();
        driverchrome.findElement(By.cssSelector("div#box-account-login input[name=email]")).sendKeys(email);
        driverchrome.findElement(By.cssSelector("div#box-account-login input[name=password]")).sendKeys(password);
        driverchrome.findElement(By.cssSelector("div#box-account-login button[type=submit]")).click();
        }

        @After
        public void finish () {
            // driverchrome.quit();
            //  driverchrome = null;
        }
    }
