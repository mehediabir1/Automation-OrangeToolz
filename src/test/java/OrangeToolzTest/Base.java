package OrangeToolzTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Base {
    public static WebDriver driver;
    public static void main(String[] args) {

    }
    public static void ChromeOpen(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    public static void ChromeClose(){
        driver.quit();
    }

    public static void GetUrl(String URL){
        driver.get(URL);
    }

    public static WebElement findById(String Locator){
        return driver.findElement(By.id(Locator));
    }

    public static WebElement findByClass(String Locator){
        return driver.findElement(By.className(Locator));
    }

    public static WebElement findByCSS(String Locator){
        return driver.findElement(By.cssSelector(Locator));
    }

    public static WebElement findByXpath(String Locator){
        return driver.findElement(By.xpath(Locator));
    }

    public static WebElement findByName(String Locator){
        return driver.findElement(By.name(Locator));
    }
}
