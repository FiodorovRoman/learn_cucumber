package org.example;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(strict = true, plugin = {"pretty"}, features = "classpath:org/example/smoothie")
public class RunCucumberTest {

}
