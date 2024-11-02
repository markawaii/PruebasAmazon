package DefinicionPasos;

import java.time.Duration;

import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PasosCreacionUsuario {

	static WebDriver driver;
    static WebDriverWait wait;

    @Before
    public void setUp() throws Exception {
        driver = Configuracion.configure();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        if (driver != null)
            driver.quit();
    }

	@When("I enter in the name field with id {string} the text {string}")
	public void i_enter_in_the_name_field_with_id_the_text(String k, String v) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(k)));
        System.out.println("Ingresando texto en el campo: " + k + ", valor: "+ k);
        element.clear();
        element.sendKeys(v);
	}
	

	@When("I enter in the nombre_corto field with id {string} the text {string}")
	public void i_enter_in_the_nombre_corto_field_with_id_the_text(String k, String v) {
		WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(k)));
		System.out.println("Ingresando texto en el campo: " + k + ", valor: "+ k);
        passwordField.clear();
        passwordField.sendKeys(v);
	}
	
	@When("I enter in the email field with id {string} the text {string}")
	public void i_enter_in_the_email_field_with_id_the_text(String k, String v) {
		WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(k)));
        System.out.println("Ingresando texto en el campo: " + k + ", valor: "+ k);
        passwordField.clear();
        passwordField.sendKeys(v);
	}
	
	@When("I enter in the run_empresa field with id {string} the text {string}")
	public void i_enter_in_the_run_empresa_field_with_id_the_text(String k, String v) {
		WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(k)));
        System.out.println("Ingresando texto en el campo: " + k + ", valor: "+ k);
        passwordField.clear();
        passwordField.sendKeys(v);
	}

    @Then("I should create a new client with button css-selector {string}")
    public void iShouldCreateANewClientWithButtonCssSelector(String k) {
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(k)));
        System.out.println("Haciendo clic en el botón de Guardar");
        loginButton.click();

        // Esperar hasta que la URL cambie o aparezca un elemento único del dashboard
        try {
            boolean redirected = wait.until(ExpectedConditions.urlContains("/cliente"));
            if (redirected) {
                System.out.println("Guadado cliente exitoso. Prueba PASADA.");
            } else {
                System.out.println("No se guardo cliente. Prueba FALLIDA.");
            }
        } catch (Exception e) {
            System.out.println("Error guardando cliente. Prueba FALLIDA.");
        }
	}

    @And("I hit the user-view button with selector {string}")
    public void iHitTheUserActionsButtonWithSelector(String arg0) {
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(arg0)));
        System.out.println("Haciendo clic en el botón de acciones de usuario");
        loginButton.click();
    }

    @Then("I should search for a Client redirected to url {string}")
    public void iShouldSearchForAClientRedirectedToUrl(String arg0) {
        // Esperar hasta que la URL cambie o aparezca un elemento único del dashboard
        try {
            boolean redirected = wait.until(ExpectedConditions.urlContains(arg0));
            if (redirected) {
                System.out.println("Redireccionado correctamente. Prueba PASADA.");
            } else {
                System.out.println("No redireccionado a cliente. Prueba FALLIDA.");
            }
        } catch (Exception e) {
            System.out.println("Error. Prueba FALLIDA.");
        }
    }

    @And("I click on the button with text {string}")
    public void iClickOnTheButtonWithText(String arg0) {

    }
}
