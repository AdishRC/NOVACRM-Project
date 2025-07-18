Feature: Verify and validate the dashboard field functionality

  Scenario: Verify and validate the search functionality
    Given User logs in with valid credentials and lands on the dashboard page
    When User validates the search functionality with valid and invalid search terms
    Then The results should be displayed appropriately

  Scenario: Verify and validate the notification functionality
    Given User logs in with valid credentials and lands on the dashboard page
    When User Validate Notification Bell icon notification message count displayed on homepage
    Then User Validate home page Notification Bell icon on click redirection

  Scenario: Verify and validate the "Add a New Lead" functionality
    Given User logs in with valid credentials and lands on the dashboard page
    When The user clicks on the "Add a Person" icon and fills in the mandatory fields
    Then The user click on "Save Lead" button to add new lead successfully

  Scenario: Verify and validate the "Send a text" functionality
    Given User logs in with valid credentials and lands on the dashboard page
    When The user clicks on the Send a text icon
    Then The user enters a name or phone number
    And Writes a message and clicks on the Send Message button to send the message to the user

    Scenario: Verify and validate the "Send an Email" functionality
    Given User logs in with valid credentials and lands on the dashboard page
      When The user clicks on the Send a Email icon
    Then User enter the Recipient name and add the Subject
    And Enter the data in the body and click on the Send Email Now button



  Scenario: Verify and validate the "Make a Call" functionality
    Given User logs in with valid credentials and lands on the dashboard page
    When The user clicks on the Make a Call icon
    Then User enter the name and select the lead and call

  Scenario: Verify and validate the "Pages Redirection" functionality
    Given User logs in with valid credentials and lands on the dashboard page
    When the user clicks on the Home tab
    Then the user should be redirected to the Home page
    When the user clicks on the People tab
    Then the user should be redirected to the People page
    When the user clicks on the Inbox tab
    Then the user should be redirected to the Inbox page
    When the user clicks on the Email Marketing tab
    Then the user should be redirected to the Email Marketing page
    When the user clicks on the Social Media Management tab
    Then the user should be redirected to the Social Media Management page
    When the user clicks on the Tasks tab
    Then the user should be redirected to the Tasks page
    When the user clicks on the Deals tab
    Then the user should be redirected to the Deals page

  Scenario: Verify and validate the "Boxes" functionality
    Given User logs in with valid credentials and lands on the dashboard page
    When User verify the Available Credit functionality
    Then User check Available Credit and View Credit history
    When User verify the New Leads functionality
    Then User check New Leads and View All Leads
    When User verify the Todays Task functionality
    Then User check Todays Task and View All Task
    When User verify the Incomplete Follow Ups functionality
    Then User check Incomplete Follow Ups and View View All Incomplete Follow Ups

  Scenario: Verify and validate the "Home Page Email Marketing" functionality
    Given User logs in with valid credentials and lands on the dashboard page
    When User selects the "Today" option in the filter dropdown
    Then User verifies the emails for today
    When User selects the "Yesterday" option in the filter dropdown
    Then User verifies the emails for yesterday
    When User selects the "Last 5 Days" option in the filter dropdown
    Then User verifies the emails for the last 5 days
    When User selects the "Last 10 Days" option in the filter dropdown
    Then User verifies the emails for the last 10 days
    When User selects the "Last 30 Days" option in the filter dropdown
    Then User verifies the emails for the last 30 days
    And User clicks on the View More to redirect the Email Marketing page

  Scenario: Verify and validate the "Home Tasks" functionality
    Given User logs in with valid credentials and lands on the dashboard page
    When User unchecked the checkbox on tasks page
    Then User click on View More to redirect the Tasks page

  Scenario: Verify and validate the "Automation" functionality
    Given User logs in with valid credentials and lands on the dashboard page
    When User Click on View All link
    Then User navigate to the Automation page

  Scenario: Verify and validate the "Social Media" functionality for all filters
    Given User logs in with valid credentials and lands on the dashboard page
    When the user selects "Facebook" as the social media account type
    Then the user applies all available filters sequentially
    When the user selects "Instagram" as the social media account type
    Then the user applies all available filters sequentially
    And the user clicks on the "View More" link to navigate to the Social Media page

