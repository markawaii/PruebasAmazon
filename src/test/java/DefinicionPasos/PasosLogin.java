package DefinicionPasos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PasosLogin {

    static WebDriver driver;
    static String pathDriver = "./src/test/resources/chrome/chromedriver.exe";
    static String driverType = "webdriver.chrome.driver";
    static WebDriverWait wait;

    @Before
    public void setUp() throws Exception {
        System.setProperty(driverType, pathDriver);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        if (driver != null) {
            // Espera de 5 segundos para observar el resultado de la prueba
            TimeUnit.SECONDS.sleep(5);
            driver.quit();
        }
    }

    @Given("I navigate to the url {string}")
    public void i_navigate_to_the_url(String url) {
        driver.get(url);
        System.out.println("Navegando a la URL: " + url);
    }

    @When("I enter in the username field with id {string} the text {string}")
    public void i_enter_in_the_username_field_with_id_the_text(String fieldId, String text) {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(fieldId)));
        System.out.println("Ingresando texto en el campo usuario: " + text);
        emailField.clear();
        emailField.sendKeys(text);
    }

    @When("I enter in the password field with id {string} the text {string}")
    public void i_enter_in_the_password_field_with_id_the_text(String fieldId, String text) {
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(fieldId)));
        System.out.println("Ingresando texto en el campo contraseña: " + text);
        passwordField.clear();
        passwordField.sendKeys(text);
    }

    @When("I click on the Login button with id {string}")
    public void i_click_on_the_login_button_with_id(String buttonId) {
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id(buttonId)));
        System.out.println("Haciendo clic en el botón de Login");
        loginButton.click();
    }

    @Then("I should be redirected to the url {string}")
    public void i_should_be_redirected_to_the_url(String expectedUrl) {
        try {
            boolean redirected = wait.until(ExpectedConditions.urlToBe(expectedUrl));
            if (redirected) {
                System.out.println("Redirigido exitosamente a: " + expectedUrl + ". Prueba PASADA.");
            } else {
                System.out.println("No redirigido a la URL esperada. Prueba FALLIDA.");
            }
        } catch (Exception e) {
            System.out.println("Error al verificar la redirección a la URL esperada. Prueba FALLIDA.");
        }
    }

    @Then("I should remain on the url {string}")
    public void i_should_remain_on_the_url(String expectedUrl) {
        try {
            boolean onSameUrl = wait.until(ExpectedConditions.urlToBe(expectedUrl));
            if (onSameUrl) {
                System.out.println("Permaneció en la URL: " + expectedUrl + ". Prueba PASADA.");
            } else {
                System.out.println("No se mantuvo en la URL esperada. Prueba FALLIDA.");
            }
        } catch (Exception e) {
            System.out.println("Error al verificar la permanencia en la URL esperada. Prueba FALLIDA.");
        }
    }

    @Then("an error message is presented {string}")
    public void an_error_message_is_presented(String expectedMessage) {
        try {
            WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'" + expectedMessage + "')]")));
            String actualMessage = errorElement.getText();
            System.out.println("Mensaje de error presentado: " + actualMessage);
            if (actualMessage.contains(expectedMessage)) {
                System.out.println("Prueba PASADA");
            } else {
                System.out.println("Prueba FALLIDA");
            }
        } catch (Exception e) {
            System.out.println("Mensaje de error no encontrado. Prueba FALLIDA.");
        }
    }

    @Then("error messages are presented:")
    public void error_messages_are_presented(DataTable dataTable) {
        List<String> expectedMessages = dataTable.asList(String.class);
        boolean allMessagesFound = true;

        for (String expectedMessage : expectedMessages) {
            try {
                WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'" + expectedMessage + "')]")));
                String actualMessage = errorElement.getText();
                System.out.println("Mensaje de error encontrado: " + actualMessage);
            } catch (Exception e) {
                System.out.println("Mensaje de error no encontrado: " + expectedMessage);
                allMessagesFound = false;
            }
        }

        if (allMessagesFound) {
            System.out.println("Todos los mensajes de error fueron encontrados. Prueba PASADA.");
        } else {
            System.out.println("Algunos mensajes de error no fueron encontrados. Prueba FALLIDA.");
        }
    }
}
