package de.mpsmobile.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtils {
   public static void waitForVisibilityOf(WebElement webElement) {
      WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 15);
      wait.until(ExpectedConditions.visibilityOf(webElement));
   }

   public static void waitForInvisibilityOf(WebElement webElement) {
      WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
      wait.until(ExpectedConditions.invisibilityOf(webElement));
   }

   public static void waitForTitleContains(String titleContains) {
      WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
      wait.until(ExpectedConditions.titleContains(titleContains));
   }

   public static void waitForPresenceOfElementLocatedBy(By locator) {
      WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
      wait.until(ExpectedConditions.presenceOfElementLocated(locator));
   }

   public static double convertPrice_StringToDouble(String price) {

      double priceInDouble = Double.parseDouble(price.replace(" € ", ""));
      return priceInDouble;
   }

}
