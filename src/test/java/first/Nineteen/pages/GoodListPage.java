package first.Nineteen.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoodListPage extends Page {

    public GoodListPage(WebDriver driver) {
        super(driver);
    }



    public void selectFirstGood() {
        driver.findElements(By.cssSelector("div#box-most-popular ul.listing-wrapper li")).get(0).click();
    }

    public  void goToCart() {
        driver.findElement(By.cssSelector("div#cart-wrapper .link")).click();
    }

}




