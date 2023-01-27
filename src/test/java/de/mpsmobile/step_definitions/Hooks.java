package de.mpsmobile.step_definitions;

import de.mpsmobile.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
   @After
   public void teardownScenario(Scenario scenario) {
      if (scenario.isFailed()){
         byte [] screenShot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
         scenario.attach(screenShot,"image/png",scenario.getName());
      }
   }

   @AfterAll
         public static void tearDown() {
      Driver.closeDriver();
   }
}
