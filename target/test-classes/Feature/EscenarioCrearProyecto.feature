Feature: Project Management

  Scenario: Create a new project
    Given I navigate to the url "https://taskhub.cl/"
    When I enter in the username field with id "email" the text "igna.veliz@duocuc.cl"
    And I enter in the password field with id "password" the text "123123123"
    And I click on the Login button with id "login_button"
    And I navigate to the url "https://taskhub.cl/proyecto"
    And I click on the button with text "Nuevo Proyecto"
    And I fill in the project form with:
      | field             | value                   |
      | nombre            | "Nuevo Proyecto"        |
      | cliente_id        | "Cliente ABC"           |
      | jefe_proyecto_id  | "Juan Pérez"            |
      | tipo_proyecto_id  | "Desarrollo Web"        |
      | daterange         | "01/11/2023 - 30/11/2023" |
    And I add a phase with:
      | field            | value         |
      | nombre_fase      | "Análisis"    |
      | hora_asignada    | "40"          |
      | checkbox_reporte | "checked"     |
      | checkbox_bono    | "unchecked"   |
    And I click on the Save button
    Then I should see the message "Proyecto creado exitosamente."
