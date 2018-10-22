package first.Nineteen.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CartPage extends Page {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> IsCartGoodElements() {
        return driver.findElements(By.cssSelector("div.viewport li"));
    }

    public Integer IsCartGoodSize() {
        return IsCartGoodElements().size();
    }

    public List<WebElement> IsCartGoodListBottomElements() {
        return driver.findElements(By.cssSelector("ul.shortcuts li"));
    }

    public WebElement removeButton(){
       return driver.findElements(By.cssSelector("div.viewport li")).get(0).findElement(By.cssSelector("button[name=remove_cart_item]"));

    }

    public void waitCountInList(List<WebElement> list, Integer count){
        wait.until(ExpectedConditions.stalenessOf(list.get(count-1)));
    }

    public void waitLastElementInList(List<WebElement> list, Integer count){
        wait.until(ExpectedConditions.stalenessOf(list.get(count-1)));
    }

    public Integer deleteGoodFromCart(Integer count) {
            List<WebElement> els = IsCartGoodElements();
            WebElement rem = removeButton();
            wait.until((ExpectedConditions.elementToBeClickable(rem)));
            rem.click();
            List<WebElement> list = IsCartGoodListBottomElements() ;
            if (list.size()>0) {waitCountInList(list, count);}else
            {waitLastElementInList(els, count);}
            count = IsCartGoodSize();
            System.out.println(count);
            return count;


    }



}

