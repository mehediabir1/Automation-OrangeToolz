package OrangeToolzTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.concurrent.TimeUnit;

public class ContactManage extends Base{

    public static void main(String[] args) {
        ChromeOpen();
        GetUrl("http://159.89.38.11/login");
        Login();
        ContactManage();
        NewContact();
        GroupTag_2001();
//        GroupTag_2002();
//        NumbField_2003();
//        NumbField_2004();
//        NumbField_2005();
//        NumbField_2006();
//        EmailField_2007();
//        EmailField_2008();
//        EmailField_2009();
//        FirstName_2010();
//        FirstName_2011();
//        FirstName_2012();
//        LastName_2013();
//        LastName_2014();
        LastName_2015();
        Birthdate_2016();

    }
    public static void Login(){
        findByClass("form-control").sendKeys("test@orangetoolz.com");
        findById("password-1").sendKeys("8Kh8nTe*^jdk");
        findById("m_login_signin_submit").click();

    }

    public static void ContactManage(){
        driver.manage().window().minimize();
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

        driver.navigate().refresh();
        NewContact();
        findByXpath("//*[@id=\"contact-form\"]/div[2]/div[1]/div/input").sendKeys("122345123"); //Number Input
        findByXpath("//*[@id=\"contact-form\"]/button").click();
        try{
            WebElement isDisp1 = driver.findElement(By.xpath("//*[@id=\"contact-form\"]/div[2]/div[1]/div/span/span"));
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
        driver.navigate().refresh();
        NewContact();
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

        System.out.println("TC_2007 Passed");

    }

    public static void EmailField_2008(){
        driver.navigate().refresh();
        NewContact();
        findByXpath("//*[@id=\"contact-form\"]/div[2]/div[1]/div/input").sendKeys("2012151"); //Number Input
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        findByXpath("//*[@id=\"contact-form\"]/div[2]/div[2]/div/input").sendKeys("test@email.com"); //Email Input
        findByXpath("//*[@id=\"contact-form\"]/button").click(); //Save Button

        System.out.println("TC_2008 Passed");

    }

    public static void EmailField_2009(){
        driver.navigate().refresh();
        NewContact();
        findByXpath("//*[@id=\"contact-form\"]/div[2]/div[1]/div/input").sendKeys("32012151"); //Number Input
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        findByXpath("//*[@id=\"contact-form\"]/div[2]/div[2]/div/input").sendKeys("testmail.com"); //Email Input
        findByXpath("//*[@id=\"contact-form\"]/button").click(); //Save Button

        System.out.println("TC_2009 Failed");

    }

    //FIRST NAME

    public static void FirstName_2010()  {
        driver.navigate().refresh();
        NewContact();
        findByXpath("//*[@id=\"contact-form\"]/div[2]/div[1]/div/input").sendKeys("201012345"); //Number Input
        findByXpath("//*[@id=\"contact-form\"]/div[2]/div[2]/div/input").sendKeys("testmail2010@mail.com"); //Email Input
        findByXpath("//*[@id=\"contact-form\"]/div[3]/div[1]/input").sendKeys("");
        findByXpath("//*[@id=\"contact-form\"]/button").click(); //Save Button
        System.out.println("TC_2010 Passed");

    }

    public static void FirstName_2011()  {
        driver.navigate().refresh();
        NewContact();
        findByXpath("//*[@id=\"contact-form\"]/div[2]/div[1]/div/input").sendKeys("201112345"); //Number Input
        findByXpath("//*[@id=\"contact-form\"]/div[2]/div[2]/div/input").sendKeys("testmail2010@mail.com"); //Email Input
        findByXpath("//*[@id=\"contact-form\"]/div[3]/div[1]/input").sendKeys("2011");
        findByXpath("//*[@id=\"contact-form\"]/button").click(); //Save Button
        System.out.println("TC_2011 Failed");

    }

    public static void FirstName_2012()  {
        driver.navigate().refresh();
        NewContact();
        findByXpath("//*[@id=\"contact-form\"]/div[2]/div[1]/div/input").sendKeys("201212345"); //Number Input
        findByXpath("//*[@id=\"contact-form\"]/div[2]/div[2]/div/input").sendKeys("testmail2010@mail.com"); //Email Input
        findByXpath("//*[@id=\"contact-form\"]/div[3]/div[1]/input").sendKeys("TestName");
        findByXpath("//*[@id=\"contact-form\"]/button").click(); //Save Button
        System.out.println("TC_2012 Passed");

    }

    //LAST NAME

    public static void LastName_2013()  {
        driver.navigate().refresh();
        NewContact();
        findByXpath("//*[@id=\"contact-form\"]/div[2]/div[1]/div/input").sendKeys("201312345"); //Number Input
        findByXpath("//*[@id=\"contact-form\"]/div[2]/div[2]/div/input").sendKeys("testmail2010@mail.com"); //Email Input
        findByXpath("//*[@id=\"contact-form\"]/div[3]/div[1]/input").sendKeys("TestName"); //First Name
        findByXpath("//*[@id=\"contact-form\"]/div[3]/div[1]/input").sendKeys("");
        findByXpath("//*[@id=\"contact-form\"]/button").click(); //Save Button
        System.out.println("TC_2013 Passed");

    }

    public static void LastName_2014()  {
        driver.navigate().refresh();
        NewContact();
        findByXpath("//*[@id=\"contact-form\"]/div[2]/div[1]/div/input").sendKeys("201412345"); //Number Input
        findByXpath("//*[@id=\"contact-form\"]/div[2]/div[2]/div/input").sendKeys("testmail2010@mail.com"); //Email Input
        findByXpath("//*[@id=\"contact-form\"]/div[3]/div[1]/input").sendKeys("TestName"); //First Name
        findByXpath("//*[@id=\"contact-form\"]/div[3]/div[1]/input").sendKeys("2014"); //Last Name
        findByXpath("//*[@id=\"contact-form\"]/button").click(); //Save Button
        System.out.println("TC_2014 Failed");

    }

    public static void LastName_2015()  {
        driver.navigate().refresh();
        NewContact();
        findByXpath("//*[@id=\"contact-form\"]/div[2]/div[1]/div/input").sendKeys("201512345"); //Number Input
        findByXpath("//*[@id=\"contact-form\"]/div[2]/div[2]/div/input").sendKeys("testmail2010@mail.com"); //Email Input
        findByXpath("//*[@id=\"contact-form\"]/div[3]/div[1]/input").sendKeys("TestName"); //First Name
        findByXpath("//*[@id=\"contact-form\"]/div[3]/div[1]/input").sendKeys("TestLastName"); //Last Name
        findByXpath("//*[@id=\"contact-form\"]/button").click(); //Save Button
        System.out.println("TC_2015 Passed");

    }

    // BIRTHDATE FIELD

    public static void Birthdate_2016()  {
        driver.navigate().refresh();
        NewContact();
        findByXpath("//*[@id=\"contact-form\"]/div[2]/div[1]/div/input").sendKeys("201612345"); //Number Input
        findByXpath("//*[@id=\"contact-form\"]/div[2]/div[2]/div/input").sendKeys("testmail2016@mail.com"); //Email Input
        findByXpath("//*[@id=\"contact-form\"]/div[3]/div[1]/input").sendKeys("TestName"); //First Name
        findByXpath("//*[@id=\"contact-form\"]/div[3]/div[1]/input").sendKeys("TestLastName"); //Last Name
        findByXpath("//*[@id=\"date-time-picker-1\"]/input").sendKeys("2013-123-35"); //Date Field
        findByXpath("//*[@id=\"contact-form\"]/button").click(); //Save Button

    }
}
