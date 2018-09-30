package first;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

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

        driverchrome.findElement(By.cssSelector("a[href*=appearance]")).click();
        driverchrome.findElement(By.cssSelector("h1")).isDisplayed();
        driverchrome.findElement(By.id("doc-template")).click();
        driverchrome.findElement(By.cssSelector("h1")).isDisplayed();
        driverchrome.findElement(By.id("doc-logotype")).click();
        driverchrome.findElement(By.cssSelector("h1")).isDisplayed();

       // driverchrome.findElement(By.linkText("Catalog")).click();
        driverchrome.findElement(By.cssSelector("a[href*=catalog]")).click();
        driverchrome.findElement(By.cssSelector("h1")).isDisplayed();
        driverchrome.findElement(By.id("doc-catalog")).click();
        driverchrome.findElement(By.cssSelector("h1")).isDisplayed();
        driverchrome.findElement(By.id("doc-product_groups")).click();
        driverchrome.findElement(By.cssSelector("h1")).isDisplayed();
        driverchrome.findElement(By.id("doc-manufacturers")).click();
        driverchrome.findElement(By.cssSelector("h1")).isDisplayed();
        driverchrome.findElement(By.id("doc-suppliers")).click();
        driverchrome.findElement(By.cssSelector("h1")).isDisplayed();
        driverchrome.findElement(By.id("doc-delivery_statuses")).click();
        driverchrome.findElement(By.cssSelector("h1")).isDisplayed();
        driverchrome.findElement(By.id("doc-sold_out_statuses")).click();
        driverchrome.findElement(By.cssSelector("h1")).isDisplayed();
        driverchrome.findElement(By.id("doc-quantity_units")).click();
        driverchrome.findElement(By.cssSelector("h1")).isDisplayed();
        driverchrome.findElement(By.id("doc-csv")).click();
        driverchrome.findElement(By.cssSelector("h1")).isDisplayed();

        //driverchrome.findElement(By.linkText("Countries")).click();
        driverchrome.findElement(By.cssSelector("a[href*=countries]")).click();
        driverchrome.findElement(By.cssSelector("h1")).isDisplayed();

       // driverchrome.findElement(By.linkText("Currencies")).click();
        driverchrome.findElement(By.cssSelector("a[href*=currencies]")).click();
        driverchrome.findElement(By.cssSelector("h1")).isDisplayed();

        //driverchrome.findElement(By.linkText("Customers")).click();
        driverchrome.findElement(By.cssSelector("a[href*=customers]")).click();
        driverchrome.findElement(By.cssSelector("h1")).isDisplayed();
        driverchrome.findElement(By.id("doc-customers")).click();
        driverchrome.findElement(By.cssSelector("h1")).isDisplayed();
        driverchrome.findElement(By.id("doc-csv")).click();
        driverchrome.findElement(By.cssSelector("h1")).isDisplayed();
        driverchrome.findElement(By.id("doc-newsletter")).click();
        driverchrome.findElement(By.cssSelector("h1")).isDisplayed();

        //driverchrome.findElement(By.linkText("Geo Zones")).click();
        driverchrome.findElement(By.cssSelector("a[href*=zones]")).click();
        driverchrome.findElement(By.cssSelector("h1")).isDisplayed();

        //driverchrome.findElement(By.linkText("Languages")).click();
        driverchrome.findElement(By.cssSelector("a[href*=languages]")).click();
        driverchrome.findElement(By.cssSelector("h1")).isDisplayed();
        driverchrome.findElement(By.id("doc-languages")).click();
        driverchrome.findElement(By.cssSelector("h1")).isDisplayed();
        driverchrome.findElement(By.id("doc-storage_encoding")).click();
        driverchrome.findElement(By.cssSelector("h1")).isDisplayed();

        //driverchrome.findElement(By.linkText("Modules")).click();
        driverchrome.findElement(By.cssSelector("a[href*=modules]")).click();
        driverchrome.findElement(By.cssSelector("h1")).isDisplayed();
        driverchrome.findElement(By.id("doc-jobs")).click();
        driverchrome.findElement(By.cssSelector("h1")).isDisplayed();
        driverchrome.findElement(By.id("doc-customer")).click();
        driverchrome.findElement(By.cssSelector("h1")).isDisplayed();
        driverchrome.findElement(By.id("doc-shipping")).click();
        driverchrome.findElement(By.cssSelector("h1")).isDisplayed();
        driverchrome.findElement(By.id("doc-payment")).click();
        driverchrome.findElement(By.cssSelector("h1")).isDisplayed();
        driverchrome.findElement(By.id("doc-order_total")).click();
        driverchrome.findElement(By.cssSelector("h1")).isDisplayed();
        driverchrome.findElement(By.id("doc-order_success")).click();
        driverchrome.findElement(By.cssSelector("h1")).isDisplayed();
        driverchrome.findElement(By.id("doc-order_action")).click();
        driverchrome.findElement(By.cssSelector("h1")).isDisplayed();

        //driverchrome.findElement(By.linkText("Orders")).click();
        driverchrome.findElement(By.cssSelector("a[href*=orders]")).click();
        driverchrome.findElement(By.cssSelector("h1")).isDisplayed();
        driverchrome.findElement(By.id("doc-orders")).click();
        driverchrome.findElement(By.cssSelector("h1")).isDisplayed();
        driverchrome.findElement(By.id("doc-order_statuses")).click();
        driverchrome.findElement(By.cssSelector("h1")).isDisplayed();

        //driverchrome.findElement(By.linkText("Pages")).click();
        driverchrome.findElement(By.cssSelector("a[href*=pages]")).click();
        driverchrome.findElement(By.cssSelector("h1")).isDisplayed();

        //driverchrome.findElement(By.linkText("Reports")).click();
        driverchrome.findElement(By.cssSelector("a[href*=reports]")).click();
        driverchrome.findElement(By.cssSelector("h1")).isDisplayed();
        driverchrome.findElement(By.id("doc-monthly_sales")).click();
        driverchrome.findElement(By.cssSelector("h1")).isDisplayed();
        driverchrome.findElement(By.id("doc-most_sold_products")).click();
        driverchrome.findElement(By.cssSelector("h1")).isDisplayed();
        driverchrome.findElement(By.id("doc-most_shopping_customers")).click();
        driverchrome.findElement(By.cssSelector("h1")).isDisplayed();

        driverchrome.findElement(By.linkText("Settings")).click();
        //driverchrome.findElement(By.cssSelector("a[href*=settings]")).click();
        driverchrome.findElement(By.cssSelector("h1")).isDisplayed();
        driverchrome.findElement(By.id("doc-store_info")).click();
        driverchrome.findElement(By.cssSelector("h1")).isDisplayed();
        driverchrome.findElement(By.id("doc-defaults")).click();
        driverchrome.findElement(By.cssSelector("h1")).isDisplayed();
        driverchrome.findElement(By.id("doc-general")).click();
        driverchrome.findElement(By.cssSelector("h1")).isDisplayed();
        driverchrome.findElement(By.id("doc-listings")).click();
        driverchrome.findElement(By.cssSelector("h1")).isDisplayed();
        driverchrome.findElement(By.id("doc-images")).click();
        driverchrome.findElement(By.cssSelector("h1")).isDisplayed();
        driverchrome.findElement(By.id("doc-checkout")).click();
        driverchrome.findElement(By.cssSelector("h1")).isDisplayed();
        driverchrome.findElement(By.id("doc-advanced")).click();
        driverchrome.findElement(By.cssSelector("h1")).isDisplayed();
        driverchrome.findElement(By.id("doc-security")).click();
        driverchrome.findElement(By.cssSelector("h1")).isDisplayed();

        //driverchrome.findElement(By.linkText("Slides")).click();
        driverchrome.findElement(By.cssSelector("a[href*=slides]")).click();
        driverchrome.findElement(By.cssSelector("h1")).isDisplayed();

        //driverchrome.findElement(By.linkText("Tax")).click();
        driverchrome.findElement(By.cssSelector("a[href*=tax]")).click();
        driverchrome.findElement(By.cssSelector("h1")).isDisplayed();
        driverchrome.findElement(By.id("doc-tax_classes")).click();
        driverchrome.findElement(By.cssSelector("h1")).isDisplayed();
        driverchrome.findElement(By.id("doc-tax_rates")).click();
        driverchrome.findElement(By.cssSelector("h1")).isDisplayed();

        //driverchrome.findElement(By.linkText("Translations")).click();
        driverchrome.findElement(By.cssSelector("a[href*=translations]")).click();
        driverchrome.findElement(By.cssSelector("h1")).isDisplayed();
        driverchrome.findElement(By.id("doc-search")).click();
        driverchrome.findElement(By.cssSelector("h1")).isDisplayed();
        driverchrome.findElement(By.id("doc-scan")).click();
        driverchrome.findElement(By.cssSelector("h1")).isDisplayed();
        driverchrome.findElement(By.id("doc-csv")).click();
        driverchrome.findElement(By.cssSelector("h1")).isDisplayed();

        //driverchrome.findElement(By.linkText("Users")).click();
        driverchrome.findElement(By.cssSelector("a[href*=users]")).click();
        driverchrome.findElement(By.cssSelector("h1")).isDisplayed();

        //driverchrome.findElement(By.linkText("vQmods")).click();
        driverchrome.findElement(By.cssSelector("a[href*=vqmods]")).click();
        driverchrome.findElement(By.cssSelector("h1")).isDisplayed();
        driverchrome.findElement(By.id("doc-vqmods")).click();
        driverchrome.findElement(By.cssSelector("h1")).isDisplayed();
                //.cssSelector("snap=Appearence")).click();
    }

    @After
    public void finish() {
       driverchrome.quit();
       driverchrome = null;
    }
}
