package ru.stqa.selenium;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.selenium.pages.EventsUnAutPageHelper;
import ru.stqa.selenium.pages.HomePageHelper;

/**
 * Created by Inka on 16-Dec-18.
 */
public class HomePagesTests extends TestBase{
    HomePageHelper homePage;
    EventsUnAutPageHelper eventsUnAutPage;

    @BeforeMethod
    public void initPage(){
        homePage = PageFactory.initElements(driver,HomePageHelper.class);
        eventsUnAutPage = PageFactory.initElements(driver,EventsUnAutPageHelper.class);
    }

    @Test
    public void openHomePage() throws InterruptedException {
        homePage.waitUntilPageLoad();
        String goToButtonName = homePage.getGoToEventButtonName();

        Assert.assertEquals("Go to Event list",goToButtonName);
    }
    @Test
    public void goToEventsTest() throws InterruptedException {

        homePage.waitUntilPageLoad();
        homePage.pressGoToEventButton();
        eventsUnAutPage.waitUntilPageLoad();
        String header = eventsUnAutPage.getHeader();

        Assert.assertEquals("Find event",header);
    }
}
