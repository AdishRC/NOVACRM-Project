Feature: User Login

  Scenario: Successful Login
    Given User is on login page
    When User enters username "adish@mmnovatech.com" and password "Adish@7890"
    Then User clicks on login button
    And Verify login success outcome


  Scenario Outline: Unsuccessful Login
    Given User is on login page
    When User enters username "<username>" and password "<password>"
    Then User clicks on login button
    And Verify login failed outcome

    Examples:
      | username                   | password  |
      | adish@mmnovatech.com       | Test@1234 |
      | softwaretest1449@gmail.com | Adish@7890|
