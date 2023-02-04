package helper;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MethodsHelper {

    public MethodsHelper(WebDriver driver){this.driver = driver;}


    public WebElement elementVisibility(By locator){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void actionsMoveElement(By locator){
        WebElement element = driver.findElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).pause(2000).perform();

    }

    public void сlicker (By locator){
        driver.findElement(locator).click();
    }



    public void enterToTextArea(WebElement element, String text){
        element.clear();
        element.sendKeys(text);
    }

    public void openingCleanBrowser(WebDriver driver){
      driver.manage().deleteAllCookies();
      driver.get("https://otus.ru");
    }

    public void fieldValidation(WebDriver driver, By locator,String expect){
        Assert.assertEquals(expect,driver.findElement(locator).getAttribute("value"));
    }
    public void listValidation(WebDriver driver, By locator, String expect){
        Assert.assertEquals(expect,driver.findElement(locator).getText());
    }


    private WebDriver driver;



}
