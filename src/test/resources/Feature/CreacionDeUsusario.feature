Feature: New User creation

  Scenario: New User creation
    Given I navigate to the url "https://taskhub.cl/"
    When I enter in the username field with id "email" the text "igna.veliz@duocuc.cl"
    And I enter in the password field with id "password" the text "123123123"
    And I click on the Login button with id "login_button"
    And I navigate to the url "https://taskhub.cl/cliente/create"
    And I enter in the name field with id "name" the text "NewClient"
    And I enter in the nombre_corto field with id "nombre_corto" the text "NewClient Company"
    And I enter in the email field with id "email" the text "newclient@newclient.com"
    And I enter in the run_empresa field with id "run_empresa" the text "70.000.000-1"
    Then I should create a new client with button css-selector "body > div.wrapper > div > main > div > div > div.row > div:nth-child(1) > div > div > form > div.d-flex.justify-content-between > button"

  Scenario: Search Registered User
    Given I navigate to the url "https://taskhub.cl/"
    When I enter in the username field with id "email" the text "igna.veliz@duocuc.cl"
    And I enter in the password field with id "password" the text "123123123"
    And I click on the Login button with id "login_button"
    And I navigate to the url "https://taskhub.cl/cliente"
    And I hit the user-view button with selector "#tablaClientes > tbody > tr:nth-child(1) > td:nth-child(7) > a.btn.btn-success.fa-solid.fa-eye"
    Then I should search for a Client redirected to url "https://taskhub.cl/cliente/show/1"