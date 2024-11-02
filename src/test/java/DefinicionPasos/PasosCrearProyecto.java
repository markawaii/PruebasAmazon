package DefinicionPasos;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PasosCrearProyecto {

    static WebDriver driver;
    static WebDriverWait wait;

    @Before
    public void setUp() throws Exception {
        driver = Configuracion.configure();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @After
    public void tearDown() throws Exception {
        if (driver != null)
            driver.quit();
    }

    @Given("Create a new project")
    public void i_navigate_to_the_url() {

    }


    @And("I click on the Login button new project with selector {string}")
    public void iClickOnTheLoginButtonNewProjectWithSelector(String selector) {
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selector)));
        System.out.println("Haciendo clic en el botón de nuevo proyecto");
        loginButton.click();
    }

    @Then("I should be redirected to the new project frame {string}")
    public void iShouldBeRedirectedToTheNewProjectFrame(String arg0) {
        try {
            boolean redirected = wait.until(ExpectedConditions.urlToBe("https://taskhub.cl/proyecto/create"));
            if (redirected) {
                System.out.println("Redireccionado correctamente. Prueba PASADA.");
            } else {
                System.out.println("No redireccionado a cliente. Prueba FALLIDA.");
            }
        } catch (Exception e) {
            System.out.println("Error. Prueba FALLIDA.");
        }
    }

    @And("I enter in the project name field with name {string} the text {string}")
    public void iEnterInTheProjectNameFieldWithNameTheText(String k, String v) {
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(k)));
        System.out.println("Ingresando texto en el campo: " + k + ", valor: "+ v);
        passwordField.clear();
        passwordField.sendKeys(v);
    }

    @And("I enter in the client field with selector {string}")
    public void iEnterInTheClientFieldWithSelector(String arg0) {
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(arg0)));
        System.out.println("Ingresando texto en el campo: " + arg0);
        passwordField.click();
    }

    @And("I enter in the client-value field with selector {string}")
    public void iEnterInTheClientValueFieldWithSelector(String selector) {
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selector)));
        System.out.println("Haciendo clic en el botón de nuevo proyecto");
        loginButton.click();
    }

    @And("I enter in the project manager field with selector {string}")
    public void iEnterInTheProjectManagerFieldWithSelector(String arg0) {
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(arg0)));
        System.out.println("Ingresando texto en el campo: " + arg0);
        passwordField.click();
    }

    @And("I enter in the project manager value field with selector {string}")
    public void iEnterInTheProjectManagerValueFieldWithSelector(String selector) {
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selector)));
        System.out.println("Haciendo clic en el botón de nuevo proyecto");
        loginButton.click();
    }

    @And("I enter in the project type field with selector {string}")
    public void iEnterInTheProjectTypeFieldWithSelector(String selector) {
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selector)));
        System.out.println("Haciendo clic en el botón de nuevo proyecto");
        loginButton.click();
    }

    @And("I enter in the project type value field with selector {string}")
    public void iEnterInTheProjectTypeValueFieldWithSelector(String selector) {
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selector)));
        System.out.println("Haciendo clic en el botón de nuevo proyecto");
        loginButton.click();
    }

    @And("I enter in the startdate field with selector {string}")
    public void iEnterInTheStartdateFieldWithSelector(String selector) {
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selector)));
        System.out.println("Haciendo clic en el botón de nuevo proyecto");
        loginButton.click();
    }

    @And("I enter in the enddate field with selector {string}")
    public void iEnterInTheEnddateFieldWithSelector(String selector) {
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selector)));
        System.out.println("Haciendo clic en el botón de nuevo proyecto");
        loginButton.click();
    }

    @And("I enter in the date field with selector {string}")
    public void iEnterInTheDateFieldWithSelector(String selector) {
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selector)));
        System.out.println("Haciendo clic en el botón de nuevo proyecto");
        loginButton.click();
    }

    @And("I click on save {string}")
    public void iClickOnSave(String selector) {
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selector)));
        System.out.println("Haciendo clic en el botón de nuevo proyecto");
        loginButton.click();
    }

    @And("I click on new phase {string}")
    public void iClickOnNewPhase(String selector) {
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selector)));
        System.out.println("Haciendo clic en el botón de nuevo proyecto");
        loginButton.click();
    }

    @And("I enter in the phase name field with id {string} the text {string}")
    public void iEnterInThePhaseNameFieldWithIdTheText(String k, String v) {
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(k)));
        System.out.println("Ingresando texto en el campo: " + k + ", valor: "+ v);
        passwordField.clear();
        passwordField.sendKeys(v);
    }

    @And("I enter in the phase hour field with id {string} the text {string}")
    public void iEnterInThePhaseHourFieldWithIdTheText(String k, String v) {
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(k)));
        System.out.println("Ingresando texto en el campo: " + k + ", valor: "+ v);
        passwordField.clear();
        passwordField.sendKeys(v);
    }

    @And("I click on the Nueva fase button on the new project with selector {string}")
    public void iClickOnTheNuevaFaseButtonOnTheNewProjectWithSelector(String selector) {
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selector)));
        System.out.println("Haciendo clic en el botón de nuevo proyecto");
        loginButton.click();
    }

    @And("I click on the delete fase button on the new project with selector {string}")
    public void iClickOnTheDeleteFaseButtonOnTheNewProjectWithSelector(String selector) {
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selector)));
        System.out.println("Haciendo clic en el botón de nuevo proyecto");
        loginButton.click();
    }

    @And("I enter in the project status with selector {string}")
    public void iEnterInTheProjectStatusWithSelector(String selector) {
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selector)));
        System.out.println("Haciendo clic en el botón de nuevo proyecto");
        loginButton.click();
    }

    @And("I click on the next month with selector {string}")
    public void iClickOnTheNextMonthWithSelector(String selector) {
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selector)));
        System.out.println("Haciendo clic en el botón de nuevo proyecto");
        loginButton.click();
    }
}
