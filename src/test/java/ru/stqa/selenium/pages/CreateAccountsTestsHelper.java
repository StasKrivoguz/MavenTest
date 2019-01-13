package ru.stqa.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountsTestsHelper extends PageBase {
  @FindBy(xpath = "//span[contains(text(),'Cancel')]")
  WebElement cancelButton;
@FindBy(xpath = "//input[formcontrolname='email']")
WebElement emailField;
@FindBy(xpath = "//input[formcontrolname='password']")
WebElement passwofdField;
@FindBy(xpath = "//input[formcontrolname='passwordRep']")
WebElement repPasswordField;
@FindBy(xpath = "//span[contains(text(),'Registration')]")
WebElement registrationButton;

public CreateAccountsTestsHelper(WebDriver driver){
    super(driver);
}
public void waitUntilPageLoad(){
    waitUntilElementIsLoaded(driver,cancelButton,40);
}
public void enterValueToFieldEmail(String value){
    setValueToField(emailField,value);
}
public void enterValueToFieldPassword(String value){
    setValueToField(passwofdField,value);
}
public void enterValueToFieldRepPassword(String value){
    setValueToField(repPasswordField,value);
}
public void pressRegistrationButton(){
    waitUntilElementIsLoaded(driver,registrationButton,30);
    registrationButton.click();
}

}
