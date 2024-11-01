package DefinicionPasos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.Map;

public class PasosCrearProyecto {

    static WebDriver driver;
    static String pathDriver = "./src/test/resources/chrome/chromedriver.exe";
    static String driverType = "webdriver.chrome.driver";
    static WebDriverWait wait;

    @Before
    public void setUp() {
        System.setProperty(driverType, pathDriver);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    @When("I enter in the username field with id {string} the text {string}")
    public void i_enter_in_the_username_field_with_id_the_text(String fieldId, String username) {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(fieldId)));
        emailField.clear();
        emailField.sendKeys(username);
        System.out.println("Correo electrónico ingresado: " + username);
    }

    @When("I enter in the password field with id {string} the text {string}")
    public void i_enter_in_the_password_field_with_id_the_text(String fieldId, String password) {
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(fieldId)));
        passwordField.clear();
        passwordField.sendKeys(password);
        System.out.println("Contraseña ingresada.");
    }

    @When("I click on the Login button with id {string}")
    public void i_click_on_the_login_button_with_id(String buttonId) {
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id(buttonId)));
        loginButton.click();
        System.out.println("Hizo clic en el botón de inicio de sesión.");
    }

    @When("I click on the button with text {string}")
    public void i_click_on_the_button_with_text(String buttonText) {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='" + buttonText + "']")));
        button.click();
        System.out.println("Hizo clic en el botón con texto: " + buttonText);
    }

    @When("I fill in the project form with:")
    public void i_fill_in_the_project_form_with(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> fields = dataTable.asMap(String.class, String.class);

        fillInputField("nombre", fields.get("nombre"));
        selectOptionByVisibleText("cliente_id", fields.get("cliente_id"));
        selectOptionByVisibleText("jefe_proyecto_id", fields.get("jefe_proyecto_id"));
        selectOptionByVisibleText("tipo_proyecto_id", fields.get("tipo_proyecto_id"));
        fillInputField("daterange", fields.get("daterange"));
    }

    private void fillInputField(String fieldName, String value) {
        WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(fieldName)));
        field.clear();
        field.sendKeys(value);
        System.out.println("Campo " + fieldName + " ingresado con valor: " + value);
    }

    private void selectOptionByVisibleText(String selectName, String visibleText) {
        WebElement selectElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(selectName)));
        new Select(selectElement).selectByVisibleText(visibleText);
        System.out.println("Seleccionado en " + selectName + ": " + visibleText);
    }

    @When("I add a phase with:")
    public void i_add_a_phase_with(io.cucumber.datatable.DataTable dataTable) {
        WebElement agregarFaseButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("agregarNuevaFase")));
        agregarFaseButton.click();
        System.out.println("Hizo clic en 'Agregar Nueva Fase'.");

        int index = driver.findElements(By.cssSelector(".fase")).size() - 1;
        Map<String, String> fields = dataTable.asMap(String.class, String.class);

        fillInputField("fases[" + index + "][nombre_fase]", fields.get("nombre_fase"));
        fillInputField("fases[" + index + "][hora_asignada]", fields.get("hora_asignada"));
        setCheckbox("fases[" + index + "][checkbox_reporte]", fields.get("checkbox_reporte"));
        setCheckbox("fases[" + index + "][checkbox_bono]", fields.get("checkbox_bono"));
    }

    private void setCheckbox(String checkboxName, String value) {
        WebElement checkbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(checkboxName)));
        boolean shouldBeChecked = value.equalsIgnoreCase("checked");
        if (checkbox.isSelected() != shouldBeChecked) {
            checkbox.click();
        }
        System.out.println("Checkbox '" + checkboxName + "' configurado a " + (shouldBeChecked ? "seleccionado" : "no seleccionado") + ".");
    }

    @When("I click on the Save button")
    public void i_click_on_the_save_button() {
        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Guardar')]")));
        saveButton.click();
        System.out.println("Hizo clic en el botón Guardar.");
    }

    @Then("I should see the message {string}")
    public void i_should_see_the_message(String expectedMessage) {
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'" + expectedMessage + "')]")));
        String actualMessage = messageElement.getText();
        if (actualMessage.contains(expectedMessage)) {
            System.out.println("Prueba PASADA: Mensaje mostrado - " + actualMessage);
        } else {
            System.out.println("Prueba FALLIDA: Mensaje esperado no mostrado.");
        }
    }
}
