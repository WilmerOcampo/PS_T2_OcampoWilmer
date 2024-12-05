@Test
Feature: Obtener posts

  Scenario Outline: Obtener post con parámetro de id
    Given Post con id "<id>"
    When Enviar solicitud del post
    Then Debería retornar el status code 200
    And Validar post con JSON schema
    And Validar el id del post sea "<id>"
    Examples:
      | id     |
      | 181170 |

  Scenario Outline: Obtener post con parámetro de user_id
    Given Post con user_id "<user_id>"
    When Enviar solicitud del post
    Then Debería retornar el status code 200
    And Validar post con JSON schema
    And Validar el user_id del post sea "<user_id>"
    Examples:
      | user_id |
      | 7568346 |

  Scenario: Obtener post sin parámetro
    Given Post sin parámetros
    When Enviar solicitud del post
    Then Debería retornar el status code 200
    And Validar post con JSON schema

  Scenario Outline: Obtener post con parámetro de title
    Given Post con title "<title>"
    When Enviar solicitud del post
    Then Debería retornar el status code 200
    And Validar post con JSON schema
    And Validar el title del post sea "<title>"
    Examples:
      | title                                                |
      | Voro crapula cometes crustulum ancilla venio tenetur.|

  Scenario Outline: Obtener post con parametro de body
    Given Post con body "<body>"
    When Enviar solicitud del post
    Then Debería retornar el status code 200
    And Validar post con JSON schema
    And Validar el body del post contenga "<body>"
    Examples:
      | body                                                  |
      | Temeritas curvo auctor.                               |
