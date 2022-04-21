package OrangeToolzTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class ContactManage extends Base{

    public static void main(String[] args) {
        ChromeOpen();
        GetUrl("http://159.89.38.11/login");
        Login();
        ContactManage();
        GroupTag_2001();
    }
    public static void Login(){
        findByClass("form-control").sendKeys("test@orangetoolz.com");
        findById("password-1").sendKeys("8Kh8nTe*^jdk");
        findById("m_login_signin_submit").click();

    }

    public static void ContactManage(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().minimize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        System.out.println("working");

        WebElement ele = findByClass("dt-side-nav");
        Actions action = new Actions(driver);
        action.moveToElement(ele).build().perform();

        findByXpath("//*[@id=\"main-sidebar\"]/div[1]/ul/li[4]/a").click();
    }


    public static void GroupTag_2001(){

        findByXpath("/html/body/div[2]/div/main/div/div/div[2]/div[2]/div/div[1]/div[2]/a").click(); //Add Contact
        findByXpath("//*[@id=\"contact-form\"]/div[1]/div[1]/div/div[2]/div/a/span").click(); //Add Tag
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        findByClass("submit-file").click();

        WebElement elem = driver.findElement(By.xpath("//*[@id=\"group-add-form\"]/div[1]/div[1]/input"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String validationMessage = (String)js.executeScript("return arguments[0].validationMessage;", elem);
        System.out.println(validationMessage);

    }
}
