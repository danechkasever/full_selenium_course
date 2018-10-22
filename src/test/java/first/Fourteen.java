package first;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.Object;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Fourteen {
    private WebDriver driverchrome;
    private WebDriverWait wait;



    @Before
    public  void setUp() {
        driverchrome = new ChromeDriver();
        wait = new WebDriverWait(driverchrome,12);
    }

    @Test
    public void  fourteen() throws InterruptedException {
        driverchrome.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        driverchrome.findElement(By.cssSelector("div#box-login input[name=username]")).sendKeys("admin");
        driverchrome.findElement(By.cssSelector("div#box-login input[name=password]")).sendKeys("admin");
        driverchrome.findElement(By.name("remember_me")).click();
        driverchrome.findElement(By.cssSelector("button[name=login]")).click();
        String oldWindows = driverchrome.getWindowHandle();
        System.out.println(oldWindows);
        driverchrome.findElement(By.cssSelector("a.button[href*=edit]")).click();
        String idnewwindow;
        Integer count= driverchrome.findElements(By.cssSelector("a i[class*=fa-external-link]")).size();
        for (int i = 0; i < count; i++) {
            driverchrome.findElements(By.cssSelector("a i[class*=fa-external-link]")).get(i).click();
            java.lang.Object[] setwindows = driverchrome.getWindowHandles().toArray();
            for (int j = 0; j < setwindows.length; j++) {
                if (setwindows[j].toString().equals(oldWindows.toString()) == false) {
                    idnewwindow = setwindows[j].toString();
                    driverchrome.switchTo().window(idnewwindow);
                    System.out.println("new window" + idnewwindow);
                    break;
                }
            }
            if (i!=3) {
                wait.until(ExpectedConditions.visibilityOf(driverchrome.findElement(By.cssSelector("a.mw-wiki-logo"))));} else
            {
                wait.until(ExpectedConditions.visibilityOf(driverchrome.findElement(By.cssSelector("img.default-logo"))));
            }



            driverchrome.close();
           driverchrome.switchTo().window(oldWindows);
        }

    }


    @After
    public void finish() {
       driverchrome.quit();
      driverchrome = null;

    }

}
