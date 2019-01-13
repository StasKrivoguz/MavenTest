package ru.stqa.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageHelper extends PageBase {

    public LoginPageHelper(WebDriver driver){
        super(driver);
    }
    public void waitUntilPageLoad() {
        waitUntilElementIsLoaded(driver,
                By.xpath("//span[contains(text(),'Cancel')]"),
                20);
    }
    public void enterValueToFieldEmail(String value) {
        WebElement email_field = driver.findElement(By
                .xpath("//input[@formcontrolname='email']"));
        email_field.click();
        email_field.sendKeys(value);
    }

    public void enterValueToFieldPassword(String value) {
        WebElement password_field = driver.findElement(By
                .xpath("//input[@formcontrolname='password']"));
        password_field.click();
        password_field.sendKeys(value);
    }

    public void pressLogInButton() {
        waitUntilElementIsLoaded(driver,
                By.xpath("//span[contains(text(),'Log in')]"),
                20);
        WebElement login_button=driver.findElement(By
                .xpath("//span[contains(text(),'Log in')]"));
        login_button.click();
    }

    public String getAlertText() {
        waitUntilElementIsLoaded(driver,
                By.xpath("//div[@class='alert alert-danger ng-star-inserted']"),
                20);
        WebElement alertText = driver.findElement(By.xpath("//div[@class='alert alert-danger ng-star-inserted']"));
        return alertText.getText();

    }

}
