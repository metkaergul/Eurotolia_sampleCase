package de.mpsmobile.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
   @FindBy(xpath = "//button[@data-tooltip='My Account']")
   public WebElement myAccountDropDown;

   @FindBy(linkText = "Log In")
   public WebElement loginPageLink;

   @FindBy(linkText = "Sign Out")
   public WebElement signOutButton;

   @FindBy(id = "autocomplete")
   public WebElement searchField;

 @FindBy(id = "searchButton")
   public WebElement searchButton;

@FindBy(xpath = "//span[@class='tt-badge-cart']")
   public WebElement cartBadge;

@FindBy(id = "cart-widget-layout")
   public WebElement cartSmallIcon;

@FindBy(linkText = "VIEW CART")
   public WebElement viewCartButton;


}
