package Ejecutador;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = {"src/test/resources/Feature/EscenarioLogin.feature", "src/test/resources/Feature/CreacionDeUsusario.feature"},
    glue = {"DefinicionPasos"}
)
public class Runner {
}