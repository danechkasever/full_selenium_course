package first.Nineteen.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import net.bytebuddy.utility.RandomString;

public class RegistrationPage extends Page{
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }
    public static String generateString(int count) {
        return RandomString.make(count);
    }

    public void registrate() {
        driver.get("http://localhost/litecart/");
        driver.findElement(By.cssSelector("div.content td a")).click();
        String firstname = generateString(10);
        String lastname = generateString(10);
        String adress = generateString(10);
        String postcode = "12345";
        String city = generateString(10);
        String phone = "12345234";
        String password = generateString(8);
        String email = generateString(10) + "@gmail.com";
        driver.findElement(By.cssSelector("[name=firstname]")).sendKeys(firstname);
        driver.findElement(By.cssSelector("[name=lastname]")).sendKeys(lastname);
        driver.findElement(By.cssSelector("[name=address1]")).sendKeys(adress);
        driver.findElement(By.cssSelector("[name=postcode]")).sendKeys(postcode);
        driver.findElement(By.cssSelector("[name=city]")).sendKeys(city);
        Select select = new Select(driver.findElement(By.name("country_code")));
        select.selectByValue("US");
        driver.findElement(By.cssSelector("[name=email]")).sendKeys(email);
        driver.findElement(By.cssSelector("[name=phone]")).sendKeys(phone);
        driver.findElement(By.cssSelector("[name=password]")).sendKeys(password);
        driver.findElement(By.cssSelector("[name=confirmed_password]")).sendKeys(password);
        driver.findElement(By.cssSelector("button[type=submit]")).click();

    }

}
