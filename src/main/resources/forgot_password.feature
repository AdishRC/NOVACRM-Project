Feature: Forgot Password Flow

  Scenario: Reset password from email
    Given User is on the Forgot Password page
    When User enters registered email and clicks Get Password
    Then User should receive a reset password email
    And User clicks the reset link and sets a new password
