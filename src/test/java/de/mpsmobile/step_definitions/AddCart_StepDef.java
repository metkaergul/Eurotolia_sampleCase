package de.mpsmobile.step_definitions;

import de.mpsmobile.pages.*;
import de.mpsmobile.utilities.BrowserUtils;
import de.mpsmobile.utilities.ConfigurationReader;
import de.mpsmobile.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AddCart_StepDef {
   HomePage homePage = new HomePage();
   LoginPage loginPage = new LoginPage();
   SearchResultsPage searchResultsPage=new SearchResultsPage();
   ProductDetailsPage productDetailsPage= new ProductDetailsPage();
   ShoppingCartPage shoppingCartPage=new ShoppingCartPage();
   static String searchResultsPage_productPrice;
   static String productDetailsPage_productItemNo;
   static String productDetailsPage_productTitle;

   @Given("user is on the HomePage")
   public void user_is_on_the_home_page() {
      Driver.getDriver().get(ConfigurationReader.getProperty("url"));
   }

   @When("user enters valid email and password")
   public void user_enters_valid_email_and_password() {
      loginPage.usernameOrEmailField.sendKeys(ConfigurationReader.getProperty("userEmail"));
      loginPage.passwordField.sendKeys(ConfigurationReader.getProperty("userPassword"));
   }

   @When("user clicks Login button")
   public void user_clicks_login_button() {
      loginPage.loginButton.click();
   }

   @Then("verify user succesfully logs in")
   public void verify_user_succesfully_logs_in() {
      BrowserUtils.waitForTitleContains("Whole");
      homePage.myAccountDropDown.click();

      //it verifies that user is logged in because signOut button doesn't appear at first
      Assert.assertTrue(homePage.signOutButton.isDisplayed());
   }


   @When("user searches {string} on the homePage")
   public void user_searches_product_on_the_homePage(String productName) {
      homePage.searchField.sendKeys(productName);
      homePage.searchButton.click();
   }


   @Then("verify Product item number is {int}")
   public void verfiy_product_item_number_is(Integer expectedItemNo) {
      Integer actualItemNo = Integer.parseInt(searchResultsPage.searchResult_ProductItemNo.getText());
      Assert.assertEquals(expectedItemNo,actualItemNo);
   }

   @When("user clicks login button under myAccount dropdown")
   public void userClicksLoginButtonUnderMyAccountDropdown() {
      homePage.myAccountDropDown.click();
      homePage.loginPageLink.click();

   }

   @Then("verify user sees only {int} item")
   public void verifyUserSeesOnlyItem(int numberOfItem) {
   Assert.assertEquals(numberOfItem,searchResultsPage.searchResult_allProductsAtFirstPage.size());
   }

   @When("user navigates from searchResultsPage to productDetailsPage by clicking on product")
   public void userNavigatesFromSearchResultsPageToProductDetailsPageByClickingOnProduct() {
      searchResultsPage_productPrice=searchResultsPage.searchResult_ProductPrice.getText();
      searchResultsPage.searchResult_ProductTitle.click();
   }

   @Then("verify productPrice matches in both searchResultsPage and productDetailsPage")
   public void verifyProductPriceInProductDetailsPageMatchesWithProductPriceInSearchResultsPage() {
     String expectedPrice= searchResultsPage_productPrice;
     String actualPrice= productDetailsPage.productPrice.getText();

     //while we are on the productDetailsPage, we store productItemNo since we'll need for future assertions
     productDetailsPage_productItemNo=productDetailsPage.productItemNo.getText();

      //while we are on the productDetailsPage,we store productTitle since we'll need for future assertions
     productDetailsPage_productTitle=productDetailsPage.productTitle.getText();
     Assert.assertEquals(expectedPrice,actualPrice);

   }

   @When("user click Add to Cart button")
   public void userClickAddToCartButton() {
      productDetailsPage.addToCartButton.click();
   }

   @Then("verify user see successfully added message")
   public void verifyUserSeeSuccssfullyAddedMessage() {
      Assert.assertTrue(productDetailsPage.succsefullyAddedMessage.isDisplayed());
   }

   @And("verify cart Badge is displayed")
   public void verifyUserSeeCartBadgeIsDisplayed() {
      BrowserUtils.waitForVisibilityOf(homePage.cartBadge);
      Assert.assertTrue(homePage.cartBadge.isDisplayed());
   }

   @When("user navigates to shopping cart page")
   public void userNavigatesToShoppingCartPage() {
      homePage.cartSmallIcon.click();
      homePage.viewCartButton.click();
   }

   @Then("verify product with same info is displayed")
   public void verifyProductWithSameInfoIsDisplayed() {
      BrowserUtils.waitForTitleContains("Shopping Cart");

      //while navigating from productDetailsPage to shoppingCartPage;verified that product title remained same in shopping cart
      Assert.assertEquals(productDetailsPage_productTitle,shoppingCartPage.productTitle.getText());

      //while navigating from productDetailsPage to shoppingCartPage;verified that itemNo still exists same in the shopping cart
      Assert.assertTrue(shoppingCartPage.productItemNo_Combined.getText().contains(productDetailsPage_productItemNo));
   }

   @And("verify total product amount is {string}")
   public void verifyTotalProductAmountIs(String productTotalAmount) {
   BrowserUtils.waitForTitleContains("Shopping Cart");

   //verified that total amount is equal to the expected amount
   Assert.assertEquals(productTotalAmount,shoppingCartPage.productTotalAmount.getText());
   }
}
