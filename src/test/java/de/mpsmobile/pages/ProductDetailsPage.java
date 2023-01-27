package de.mpsmobile.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends BasePage{

   @FindBy(xpath = "//td[.='Your Price:']/following-sibling::td")
   public WebElement productPrice;

   @FindBy(xpath = "//td[.='Item No.:']/following-sibling::td")
   public WebElement productItemNo;

@FindBy(xpath = "//h1[@class='tt-title']")
   public WebElement productTitle;

   @FindBy(partialLinkText = "Add to Cart")
   public WebElement addToCartButton;

@FindBy(xpath = "//div[@class='toast toast-success']")
   public WebElement succsefullyAddedMessage;


}
