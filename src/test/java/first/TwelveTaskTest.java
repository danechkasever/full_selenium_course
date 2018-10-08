package first;

import net.bytebuddy.utility.RandomString;
import org.apache.http.util.Asserts;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.security.timestamp.Timestamper;

import java.io.File;
import java.sql.Time;
import java.time.Period;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TwelveTaskTest {
    private WebDriver driverchrome;
    private WebDriverWait wait;

    public static String generateString(int count) {
        return RandomString.make(count);
    }
    public String convertToRelative(String home) {
        return new File(home).getAbsolutePath();
    }

    @Before
    public  void setUp() {
        driverchrome = new ChromeDriver();
        driverchrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void  twelve() throws InterruptedException {
        driverchrome.get("http://localhost/litecart/admin/");
        driverchrome.findElement(By.cssSelector("div#box-login input[name=username]")).sendKeys("admin");
        driverchrome.findElement(By.cssSelector("div#box-login input[name=password]")).sendKeys("admin");
        driverchrome.findElement(By.name("remember_me")).click();
        driverchrome.findElement(By.cssSelector("button[name=login]")).click();

        driverchrome.findElement(By.cssSelector("div li#app- a[href*=catalog]")).click();
        driverchrome.findElement(By.cssSelector("a.button[href*=edit_product]")).click();
        driverchrome.findElements(By.cssSelector("input[data-type=toggle]")).get(0).click();
        String name = generateString(10);
        String code = generateString(10);
        String keywords = generateString(5);
        String short_description = generateString(10);
        String description = generateString(30);
        String head_title = generateString(10);
        String meta_description = generateString(10);

        driverchrome.findElement(By.cssSelector("input[name*=name]")).sendKeys(name);
        driverchrome.findElement(By.cssSelector("input[name=code]")).sendKeys(code);
        WebElement check = driverchrome.findElements(By.cssSelector("div.input-wrapper tbody")).get(1);
        check.findElements(By.cssSelector("input[type=checkbox]")).get(0).click();
        driverchrome.findElement(By.cssSelector("input[name=quantity]")).clear();
        driverchrome.findElement(By.cssSelector("input[name=quantity]")).sendKeys(Keys.HOME + "2,00");
        driverchrome.findElement(By.cssSelector("input[name*=new_images]")).sendKeys(convertToRelative("jj.jpg"));
        driverchrome.findElement(By.cssSelector("a[href*=tab-information]")).click();
        Select select1 = new Select(driverchrome.findElement(By.cssSelector("select[name=manufacturer_id]")));
        select1.selectByValue("1");
        driverchrome.findElement(By.cssSelector("input[name=keywords]")).sendKeys(keywords);
        driverchrome.findElement(By.cssSelector("input[name*=short_description]")).sendKeys(short_description);
        driverchrome.findElement(By.cssSelector("div.trumbowyg-editor")).sendKeys(description);
        driverchrome.findElement(By.cssSelector("input[name*=head_title]")).sendKeys(head_title);
        driverchrome.findElement(By.cssSelector("input[name*=meta_description]")).sendKeys(meta_description);
        driverchrome.findElement(By.cssSelector("a[href*=tab-prices]")).click();
        driverchrome.findElement(By.cssSelector("input[name=purchase_price]")).clear();
        driverchrome.findElement(By.cssSelector("input[name=purchase_price]")).sendKeys(Keys.HOME + "134,00");
        Select select2 = new Select(driverchrome.findElement(By.cssSelector("select[name=purchase_price_currency_code]")));
        select2.selectByValue("USD");
        driverchrome.findElement(By.cssSelector("button[name=save]")).click();
        List<WebElement> listgoods = driverchrome.findElements(By.cssSelector("table.dataTable tr"));
        for (int i = 0; i < listgoods.size(); i++) {
          String namegood = listgoods.get(i).getText();
            if (namegood.equals(name)) {
                listgoods.get(i).findElement(By.cssSelector("i[class*=fa-pencil]")).click();
                break;
            }

        }
        String codetext = driverchrome.findElement(By.cssSelector("input[name=code]")).getAttribute("value");
        System.out.println(codetext);
        System.out.println(code);
        boolean t;
        if (codetext.equals(code)){
            t=true;
        }else{
            t=false;
        }
        Asserts.check(t, "false!");



    }

    @After
    public void finish() {
      driverchrome.quit();
       driverchrome = null;
    }
}
