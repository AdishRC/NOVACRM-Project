Feature: Verify and validate the dashboard field functionality

#  Scenario: Verify and validate the search functionality
#
#    Given User logs in with valid credentials and lands on the dashboard page
#    When User validates the search functionality with valid and invalid search terms
#    Then The results should be displayed appropriately

#  Scenario: Verify and validate the notification functionality
#    Given User logs in with valid credentials and lands on the dashboard page
#    When User Validate Notification Bell icon notification message count displayed on homepage
#    Then User Validate home page Notification Bell icon on click redirection


#  Scenario: Verify and validate the "Add a New Lead" functionality
#    Given User logs in with valid credentials and lands on the dashboard page
#    When The user clicks on the "Add a Person" icon and fills in the mandatory fields
#    Then The user click on "Save Lead" button to add new lead successfully



  Scenario: Verify and validate the "Send a text" functionality
    Given User logs in with valid credentials and lands on the dashboard page
    When the user clicks on the "Send a text" icon
    Then the user enters a name or phone number
    And writes a message and clicks on the "Send Message" button to send the message to the user
