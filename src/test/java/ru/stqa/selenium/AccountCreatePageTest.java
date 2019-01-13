package ru.stqa.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.selenium.pages.CreateAccountsTestsHelper;
import ru.stqa.selenium.pages.HomePageHelper;
import ru.stqa.selenium.pages.MenuPageHelper;
import ru.stqa.selenium.pages.ProfilePageHelper;

import static ru.stqa.selenium.pages.PageBase.latinDigitString;


public class AccountCreatePageTest extends TestBase{
    HomePageHelper homePage;
    CreateAccountsTestsHelper accountCreatePage;
    ProfilePageHelper profilePage;
    MenuPageHelper menuPage;

    @BeforeMethod
    public void initPage(){
        homePage = PageFactory.initElements(driver, HomePageHelper.class);
        accountCreatePage = PageFactory.initElements(driver, CreateAccountsTestsHelper.class);
        profilePage = PageFactory.initElements(driver, ProfilePageHelper.class);
        menuPage = PageFactory.initElements(driver, MenuPageHelper.class);
    }

    @Test
    public void createNewAccount(){
        String email = latinDigitString(8)+"gmail.com";
        homePage.waitUntilPageLoad();
        homePage.pressCreateAccountButton();
        accountCreatePage.waitUntilPageLoad();
        accountCreatePage.enterValueToFieldEmail(email);
        accountCreatePage.enterValueToFieldPassword("example");
        accountCreatePage.enterValueToFieldRepPassword("example");
        accountCreatePage.pressRegistrationButton();
        profilePage.waitUntilPageLoad();
        profilePage.menuButtonClick();
        menuPage.waitUntilPageLoad();
        menuPage.pressLogOutButton();
        homePage.waitUntilPageLoad();
        Assert.assertEquals(homePage.getHeader(),"Shabbat in the family circle");
    }

}
