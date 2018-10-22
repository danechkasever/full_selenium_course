package first.Nineteen.app;

import first.Nineteen.pages.CartPage;
import first.Nineteen.pages.GoodListPage;
import first.Nineteen.pages.GoodPage;
import first.Nineteen.pages.RegistrationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Application {
    private WebDriver cromedriver;

    private GoodPage good;
    private GoodListPage goodlist;
    private CartPage cart;
    private RegistrationPage registration;

    public Application() {
        cromedriver = new ChromeDriver();
        good = new GoodPage(cromedriver);
        goodlist = new GoodListPage(cromedriver);
        cart = new CartPage(cromedriver);
        registration = new RegistrationPage(cromedriver);
    }

    public void quit() {
        cromedriver.quit();
    }

    public void regitrateUser(){
        registration.registrate();
    }

    public void addGoodsInCart(Integer goodCount) {
        Integer qs=0;
        while (qs<goodCount){
            goodlist.selectFirstGood();
            Integer q = good.IsQuantity();
            qs = q+1;
            good.addToCart(qs);
            good.printQuantity();
            good.goToList();
        }

    }

    public void openCart(){
        goodlist.goToCart();
    }

    public Integer countGoodsInCart() {
       return cart.IsCartGoodSize();
    }

    public void deleteGoodsFromCart(){
        Integer count = cart.IsCartGoodSize();

        while (count>0) {
            count = cart.deleteGoodFromCart(count);

        }

    }


}

