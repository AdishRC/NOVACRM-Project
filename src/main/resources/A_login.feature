Feature: User Login

  Scenario: Successful Login
    Given User is on login page
    When User enters valid credentials
    Then User clicks on login button
    And Verify login success outcome
    And User Logout from the system

  Scenario Outline: Unsuccessful Login
    Given User is on login page
    When User enters username "<username>" and password "<password>"
    Then User clicks on login button
    And Verify login failed outcome

    Examples:
      | username                   | password  |
      | adish@mmnovatech.com       | Test@1234 |
      | softwaretest1449@gmail.com | Adish@7890|

  Scenario: Forgot Password Flow
    When the user clicks on the "Forgot Password" link
    Then the user is redirected to the Forgot Password page
    And the user enters the email address
    And the user clicks the "Get Your Password" button
    And the user clicks the "Back to Login" button

