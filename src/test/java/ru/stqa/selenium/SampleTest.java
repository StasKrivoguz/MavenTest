package ru.stqa.selenium;

import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ru.stqa.selenium.pages.HomePageBase;

public class SampleTest extends TestBase {

  private HomePageBase homepage;

  @BeforeMethod
  public void initPageObjects() {
    homepage = PageFactory.initElements(driver, HomePageBase.class);
  }

  @Test
  public void testHomePageHasAHeader() {
    driver.get(baseUrl);
    //Assert.assertFalse("".equals(homepage.header.getText()));
  }
}
