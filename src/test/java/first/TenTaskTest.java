package first;

import org.apache.http.util.Asserts;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TenTaskTest {
    private WebDriver driverchrome;
    private WebDriverWait wait;

    private boolean comparing(String P1, String P2){
        if (P1.equals( P2)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean red (String r, String g, String b){
        if (r.equals(g) && g.equals(b)) {
            return true;
        } else {
            return  false;
        }
    }

    private boolean font(String font1, String font2){
        if (Float.parseFloat(font1)<Float.parseFloat(font2)) {
           return true;
        }else{
            return false;
        }
    }

    private void testMetod(){
        driverchrome.get("http://localhost/litecart/");
        List<WebElement> elements = driverchrome.findElements(By.cssSelector("div #box-campaigns li"));
        WebElement good = elements.get(0);
        String name = good.findElement(By.cssSelector(".name")).getAttribute("textContent");
        //String manufacturer = good.findElement(By.cssSelector(".manufacturer")).getAttribute("textContent");
        WebElement priceElement = good.findElement(By.cssSelector(".price-wrapper s.regular-price"));
        WebElement saleElement = good.findElement(By.cssSelector(".price-wrapper strong.campaign-price"));
        String price = priceElement.getAttribute("textContent");
        String sale = saleElement.getAttribute("textContent");
        String pricecolor = priceElement.getCssValue("color");
        String salecolor = saleElement.getCssValue("color");
        //String pattern = "\\s+|,\\s*";
        String pattern ="\\s*(,|!|\\(|\\)|\\.|\\()\\s*";
        String[] pricecolors = pricecolor.split(pattern);
        String[] salecolors = salecolor.split(pattern);


        Asserts.check(red(pricecolors[1], pricecolors[2], pricecolors[3]), "No red!");



        // boolean font;
        Asserts.check(comparing(salecolors[2], salecolors[3]), "No grey!");

        String patternsize ="\\s*(,|px)\\s*";
        String pricesizefont = priceElement.getCssValue("font-size");
        String salesizefont = saleElement.getCssValue("font-size");
        System.out.println(pricesizefont);
        String[] pricesizefontsplit = pricesizefont.split(patternsize);
        String[] pricesalefontsplit = salesizefont.split(patternsize);

        Asserts.check(font(pricesizefontsplit[0],pricesalefontsplit[0]), "sale more small then price");

        System.out.println(pricesizefontsplit[0]);
        //for (int i = 0; i < pricesizefontsplit.length; i++) {
        //   System.out.println(pricesizefontsplit[i]);
        // }

        /*String textdecoration = good.findElement(By.cssSelector(".price-wrapper s.regular-price")).getCssValue("text-decoration");
        boolean td;
        if (textdecoration.contains("line-through")){
            td=true;
        }else{
            td=false;
        }
        Asserts.check(td, "price no line-through");
        System.out.println(textdecoration);
        String fontweight = good.findElement(By.cssSelector(".price-wrapper strong.campaign-price")).getCssValue("strongnn");
        boolean fw;
        if (fontweight.contains("bold")){
            fw=true;
        }else{
            fw=false;
        }
        Asserts.check(fw, "sale no bold");*/
        good.click();
        String namegood = driverchrome.findElement(By.cssSelector("h1.title")).getAttribute("textContent");

        Asserts.check(comparing(name, namegood), "names different");
        WebElement pricegoodElement = driverchrome.findElement(By.cssSelector("s.regular-price"));
        WebElement salegoodElement = driverchrome.findElement(By.cssSelector("strong.campaign-price"));
        String pricegood = pricegoodElement.getAttribute("textContent");
        String salegood =salegoodElement.getAttribute("textContent");
        Asserts.check(comparing(price, pricegood), "prices different");
        Asserts.check(comparing(sale, salegood), "sales different");
        String pricegoodcolor = pricegoodElement.getCssValue("color");
        String salegoodcolor = salegoodElement.getCssValue("color");
        String[] pricegoodcolors = pricegoodcolor.split(pattern);
        String[] salegoodcolors = pricegoodcolor.split(pattern);


        Asserts.check(red(pricegoodcolors[1], pricegoodcolors[2], pricegoodcolors[3]), "No red!");
        Asserts.check(comparing(salegoodcolors[2], salegoodcolors[3]), "No grey!");

        String pricesizegoodfont = pricegoodElement.getCssValue("font-size");
        String salesizegoodfont = salegoodElement.getCssValue("font-size");
        String[] pricesizefontgoodsplit = pricesizegoodfont.split(patternsize);
        String[] pricesalefontgoodsplit = salesizegoodfont.split(patternsize);
        Asserts.check(font(pricesizefontgoodsplit[0],pricesalefontgoodsplit[0]), "sale more small then price");
    }

    public String convertToRelative(String home) {
        return new File(home).getAbsolutePath();
    }



    @Before
    public  void setUp() {

    }
    @Test
    public void  tenTestChrome111(){
        System.out.println("Abs path: " + convertToRelative("rrr.txt"));
        driverchrome.get("http://localhost/litecart/");

    }

    @Test
    public void  tenTestChrome(){
        driverchrome = new ChromeDriver();
        driverchrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        testMetod();

    }
    @Test
    public void  tenTestIE(){
        driverchrome = new InternetExplorerDriver();
        driverchrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        testMetod();

    }

    @Test
    public void tenTestFF()  {
        driverchrome = new FirefoxDriver();
        driverchrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        testMetod();
    }

    @After
    public void finish() {
       //driverchrome.quit();
      // driverchrome = null;
    }
}
