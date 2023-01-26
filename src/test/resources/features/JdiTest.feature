Feature: User can submit Metals & Colors form

  Scenario: User can submit Metals & Colors form
    Given User logins on JDI site as User
    And User opens Metals & Colors page by Header menu
    And User fills form Metals & Colors by data
    When User submits form Metals & Colors
    Then Result sections should contains data