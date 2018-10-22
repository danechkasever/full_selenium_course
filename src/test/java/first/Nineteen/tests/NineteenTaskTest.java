package first.Nineteen.tests;

import org.junit.Test;

public class NineteenTaskTest extends TestBase {
    @Test
    public void  nineteen() throws InterruptedException {;
        app.regitrateUser();
        app.addGoodsInCart(3);
        app.openCart();
        app.deleteGoodsFromCart();
    }
}
