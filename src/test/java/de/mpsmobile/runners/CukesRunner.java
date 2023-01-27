package de.mpsmobile.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/cucumber-report.html",
                "rerun:target/rerun.txt",
    },
        features = "src/test/resources/features",
        glue = "de/mpsmobile/step_definitions",
        dryRun = false,
        tags = ""

)
public class CukesRunner {
}


