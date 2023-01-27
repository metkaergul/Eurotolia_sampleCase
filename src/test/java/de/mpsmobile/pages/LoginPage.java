package de.mpsmobile.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

   @FindBy(xpath = "//input[@name='email']")
   public WebElement usernameOrEmailField;

   @FindBy(xpath = "//input[@name='password']")
   public WebElement passwordField;

   @FindBy(xpath = "//button[text()='LOGIN']")
   public WebElement loginButton;
}
