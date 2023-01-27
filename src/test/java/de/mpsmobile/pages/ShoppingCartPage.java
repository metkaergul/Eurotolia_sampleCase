package de.mpsmobile.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage{
   @FindBy(xpath = "//th[.='Total amount']/following-sibling::td")
   public WebElement productTotalAmount;

   @FindBy(xpath = "//h2")
   public WebElement productTitle;

   @FindBy(xpath = "//ul[@class='tt-list-description']/li[1]")
   public WebElement productItemNo_Combined;


}
