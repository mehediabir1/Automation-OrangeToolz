package OrangeToolzTest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class ContactManage extends Base{

    public static void main(String[] args) {
        ChromeOpen();
        GetUrl("http://159.89.38.11/login");
        Login();
    }
    public static void Login(){
        findByClass("form-control").sendKeys("test@orangetoolz.com");
        findById("password-1").sendKeys("8Kh8nTe*^jdk");
        findById("m_login_signin_submit").click();
        findByXpath("//*[@id=\"main-sidebar\"]/div[1]/ul/li[1]").click();

//        WebElement ele = findByClass("dt-side-nav");
//        Actions action = new Actions(driver);
//        action.moveToElement(ele).build().perform();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        driver.navigate().refresh();
        GetUrl("http://159.89.38.11/contact/manage");
        findByXpath("/html/body/div[2]/div/main/div/div/div[2]/div[5]/div[2]/div/div[1]/div/a/div").click();
    }


    public static void NumberField(){

    }
}
