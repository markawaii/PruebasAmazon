Feature: User Login

  Scenario: Successful Login with correct email and password
    Given I navigate to the url "https://taskhub.cl/"
    When I enter in the username field with id "email" the text "igna.veliz@duocuc.cl"
    And I enter in the password field with id "password" the text "123123123"
    And I click on the Login button with id "login_button"
    Then I should be redirected to the dashboard

  Scenario: Failed Login with correct email but incorrect password
    Given I navigate to the url "https://taskhub.cl/"
    When I enter in the username field with id "email" the text "igna.veliz@duocuc.cl"
    And I enter in the password field with id "password" the text "incorrect_password"
    And I click on the Login button with id "login_button"
    Then an error message is presented "These credentials do not match our records."

  Scenario: Failed Login with incorrect email but correct password
    Given I navigate to the url "https://taskhub.cl/"
    When I enter in the username field with id "email" the text "incorrect_email@example.com"
    And I enter in the password field with id "password" the text "123123123"
    And I click on the Login button with id "login_button"
    Then an error message is presented "These credentials do not match our records."

  Scenario: Failed Login with incorrect email and incorrect password
    Given I navigate to the url "https://taskhub.cl/"
    When I enter in the username field with id "email" the text "incorrect_email@example.com"
    And I enter in the password field with id "password" the text "incorrect_password"
    And I click on the Login button with id "login_button"
    Then an error message is presented "These credentials do not match our records."

  Scenario: Failed Login with empty email field
    Given I navigate to the url "https://taskhub.cl/"
    When I enter in the username field with id "email" the text ""
    And I enter in the password field with id "password" the text "123123123"
    And I click on the Login button with id "login_button"
    Then an error message is presented "The email field is required."

  Scenario: Failed login with both fields empty
    Given I navigate to the url "https://taskhub.cl/"
    When I enter in the username field with id "email" the text ""
    And I enter in the password field with id "password" the text ""
    And I click on the Login button with id "login_button"
    Then an error message is presented "The email field is required."
    And an error message is presented "The password field is required."
    
	Scenario: Failed Login with SQL Injection attempt in email and password fields
    Given I navigate to the url "https://taskhub.cl/"
    When I enter in the username field with id "email" the text "' OR '1'='1"
    And I enter in the password field with id "password" the text "' OR '1'='1"
    And I click on the Login button with id "login_button"
    Then an error message is presented "These credentials do not match our records."
    Then an error message is presented "Invalid input format." 