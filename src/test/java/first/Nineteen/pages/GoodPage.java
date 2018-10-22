package first.Nineteen.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GoodPage extends Page {
    public GoodPage(WebDriver driver) {
        super(driver);
    }

    public WebElement IsQuantityElement() {
        return driver.findElement(By.cssSelector("span.quantity"));
    }

    public Integer IsQuantity() {
        return Integer.parseInt(IsQuantityElement().getAttribute("textContent"));
    }

    public GoodPage addToCart(Integer qs) {
        driver.findElement(By.cssSelector("button[name=add_cart_product]")).click();
        wait.until(ExpectedConditions.attributeToBe(IsQuantityElement(), "textContent", qs.toString()));
        return this;
    }

    public void printQuantity(){
        System.out.println(IsQuantityElement().getAttribute("textContent"));
    }

    public void goToList(){
         driver.findElement(By.cssSelector("div#logotype-wrapper")).click();
    }


}
