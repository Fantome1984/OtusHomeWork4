package auth;


import profile.helper.MethodsHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Iutils;
import utils.PropertiesReder;

import java.util.Map;


public class Auth{

    public Auth(WebDriver driver){this.driver = driver;}
    private By clickButton = By.xpath("//button[@class ='header3__button-sign-in']");

    Iutils propRider = new PropertiesReder();
    Map<String,String> props = propRider.read();
    String login = props.get("login");
    String password = props.get("password");



    public void fieldFillingsAuth(){
        MethodsHelper methodsHelper = new MethodsHelper(driver);
        methodsHelper.elementVisibility(By.xpath("//form[@action = '/login/']"));
        WebElement authForm = driver.findElement(By.xpath("//form[@action = '/login/']"));
        WebElement emailField = authForm.findElement(By.xpath(".//input[@name = 'email']"));
        WebElement passwordField = authForm.findElement(By.xpath(".//input[@name = 'password']"));
        emailField.sendKeys(login);
        passwordField.sendKeys(password);
        WebElement entrance = authForm.findElement(By.xpath(".//button[@type ='submit']"));
        entrance.click();
    }

    public  void auth()  {
        MethodsHelper methodsHelper = new MethodsHelper(driver);
        methodsHelper.elementVisibility(clickButton);
        driver.findElement(clickButton).click();
        fieldFillingsAuth();
    }
    private WebDriver driver;

}




