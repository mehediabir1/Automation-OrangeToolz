package OrangeToolzTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ContactManage extends Base{

    public static void main(String[] args) {
        ChromeOpen();
        GetUrl("http://159.89.38.11/login");
        Login();
        ContactManage();
        NewContact();
//        GroupTag_2001();
//        GroupTag_2002();
//        NumbField_2003();
        NumbField_2004();
//        NumbField_2005();
//        NumbField_2006();
//        EmailField_2007();
//        EmailField_2008();
//        EmailField_2009();
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

        WebElement ele = findByClass("dt-side-nav");
        Actions action = new Actions(driver);
        action.moveToElement(ele).build().perform();
        findByXpath("//*[@id=\"main-sidebar\"]/div[1]/ul/li[4]/a").click();
    }

    public static void NewContact(){
        findByXpath("/html/body/div[2]/div/main/div/div/div[2]/div[2]/div/div[1]/div[2]/a").click(); //Add Contact
    }

    public static void GroupTag_2001(){
        //NewContact();
        findByXpath("//*[@id=\"contact-form\"]/div[1]/div[1]/div/div[2]/div/a/span").click(); //Add Tag
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"group-add-form\"]/div[1]/div[1]/input"));
        findByClass("submit-file").click();

        WebElement elem = driver.findElement(By.xpath("//*[@id=\"group-add-form\"]/div[1]/div[1]/input"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String ActMsg = "Please fill out this field.";
        try{
            String validationMessage = (String)js.executeScript("return arguments[0].validationMessage;", elem);
            if((validationMessage.equals(ActMsg)) == true){
                //System.out.println("true");
                System.out.println("TC_2001 Passed");
                driver.manage().window().minimize();
                driver.manage().window().maximize();
                findByClass("btn-secondary").click();
            }
            else
            {
                System.out.println("TC_2001 Failed");
                NewContact();
            }
        }
        catch (Exception e){
            System.out.println("TC_2001 Failed");
            NewContact();
        }
    }
    public static void GroupTag_2002(){
        driver.manage().window().minimize();
        driver.manage().window().maximize();
        findByXpath("//*[@id=\"contact-form\"]/div[1]/div[1]/div/div[2]/div/a/span").click(); //Add Tag Button
        driver.findElement(By.xpath("//*[@id=\"group-add-form\"]/div[1]/div[1]/input")).sendKeys("100215"); //Tag name
        findByClass("submit-file").click(); //Save Button

        WebElement elem = driver.findElement(By.xpath("//*[@id=\"group-add-form\"]/div[1]/div[1]/input"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String ActMsg = "Please fill out this field.";
        try{
            String validationMessage = (String)js.executeScript("return arguments[0].validationMessage;", elem);
            if((validationMessage.equals(ActMsg)) == true){
                //System.out.println("true");
                System.out.println("TC_2002 Failed");
            }
            else
            {
                //System.out.println("false");
                System.out.println("TC_2002 Passed");
                NewContact();
            }
        }
        catch (Exception e){

        }
    }

    //NUMBER FIELD

    public static void NumbField_2003(){

        findByXpath("//*[@id=\"contact-form\"]/div[2]/div[1]/div/input"); //Number Input
        findByXpath("//*[@id=\"contact-form\"]/button").click();
        try{
            WebElement isDisp = driver.findElement(By.xpath("//*[@id=\"contact-form\"]/div[2]/div[1]/div/span/span"));
            System.out.println("TC_2003 Passed");
        }
        catch (Exception e){
            System.out.println("TC_2003 Failed");
            NewContact();
        }
    }

    public static void NumbField_2004(){

        findByXpath("//*[@id=\"contact-form\"]/div[2]/div[1]/div/input").sendKeys("012345123"); //Number Input
        findByXpath("//*[@id=\"contact-form\"]/button").click();
        try{
            WebElement isDisp = driver.findElement(By.xpath("//*[@id=\"contact-form\"]/div[2]/div[1]/div/span/span"));
            System.out.println("TC_2004 Failed");
        }
        catch (Exception e){
            System.out.println("TC_2004 Passed");
            NewContact();
        }
    }

    public static void NumbField_2005(){
        findByXpath("//*[@id=\"contact-form\"]/div[2]/div[1]/div/input").sendKeys("abcdf"); //Number Input
        findByXpath("//*[@id=\"contact-form\"]/button").click();
        try{
            WebElement isDisp = driver.findElement(By.xpath("//*[@id=\"contact-form\"]/div[2]/div[1]/div/span/span"));
            System.out.println("TC_2005 Passed");
        }
        catch (Exception e){
            System.out.println("TC_2005 Failed");
            NewContact();
        }
    }

    public static void NumbField_2006(){
        findByXpath("//*[@id=\"contact-form\"]/div[2]/div[1]/div/input").sendKeys("-1002151"); //Number Input
        findByXpath("//*[@id=\"contact-form\"]/button").click();
        try{
            WebElement isDisp = driver.findElement(By.xpath("//*[@id=\"contact-form\"]/div[2]/div[1]/div/span/span"));
            System.out.println("TC_2006 Passed");
        }
        catch (Exception e){
            System.out.println("TC_2006 Failed");
            NewContact();
        }
    }

    //EMAIL FIELD

    public static void EmailField_2007(){
        findByXpath("//*[@id=\"contact-form\"]/div[2]/div[1]/div/input").sendKeys("2002151"); //Number Input
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        findByXpath("//*[@id=\"contact-form\"]/div[2]/div[2]/div/input"); //Email Input
        findByXpath("//*[@id=\"contact-form\"]/button").click(); //Save Button
        try{
            WebElement isDisp = driver.findElement(By.xpath("//*[@id=\"contact-form\"]/div[2]/div[1]/div/span/span"));
            System.out.println("TC_2007 Failed");
        }
        catch (Exception e){
            System.out.println("TC_2007 Passed");
            NewContact();
        }
    }

    public static void EmailField_2008(){
        findByXpath("//*[@id=\"contact-form\"]/div[2]/div[1]/div/input").sendKeys("2012151"); //Number Input
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        findByXpath("//*[@id=\"contact-form\"]/div[2]/div[2]/div/input").sendKeys("test@email.com"); //Email Input
        findByXpath("//*[@id=\"contact-form\"]/button").click(); //Save Button
        try{
            WebElement isDisp = driver.findElement(By.xpath("//*[@id=\"contact-form\"]/div[2]/div[1]/div/span/span"));
            System.out.println("TC_2008 Failed");
        }
        catch (Exception e){
            System.out.println("TC_2008 Passed");
            NewContact();
        }
    }

    public static void EmailField_2009(){
        findByXpath("//*[@id=\"contact-form\"]/div[2]/div[1]/div/input").sendKeys("32012151"); //Number Input
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        findByXpath("//*[@id=\"contact-form\"]/div[2]/div[2]/div/input").sendKeys("testmail.com"); //Email Input
        findByXpath("//*[@id=\"contact-form\"]/button").click(); //Save Button
        try{
            WebElement isDisp = driver.findElement(By.xpath("//*[@id=\"contact-form\"]/div[2]/div[1]/div/span/span"));
            System.out.println("TC_2009 Passed");
        }
        catch (Exception e){
            System.out.println("TC_2009 Failed");
            NewContact();
        }
    }
}
