package de.mpsmobile.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage{

   @FindBy(className = "tt-product")
   public List<WebElement> searchResult_allProductsAtFirstPage;

   @FindBy(xpath = "//th[.='Item No.']/following-sibling::td")
   public WebElement searchResult_ProductItemNo;

   @FindBy(xpath = "//th[.='Price']/following-sibling::td")
   public WebElement searchResult_ProductPrice;

   @FindBy(xpath = "//div[@class='tt-product product-parent options-js thumbprod-center tt-small']//h2/a")
   public WebElement searchResult_ProductTitle;



}
