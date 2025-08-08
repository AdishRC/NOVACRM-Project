Feature: Manage and verify People module functionality

  Scenario: Verify new lead added successfully
    Given the user is on the Dashboard page
    When the user clicks on the "People" tab in the top menu
    When the user clicks on the "Add a Person" icon
    Then the "Add New Lead" modal should appear, the user fills in the required fields, and clicks the "Save Lead" button

  Scenario: Verify Batch Text Functionality
    Given the user is on the Dashboard page
    When the user clicks on the "People" tab in the top menu
    Then  the user select lead and click on Batch Text icon on bottom
    When the user send text with Use Template
    Then the user back from the batch text page
    When the user send text with Create Text Template

  Scenario: Verify Send Mail Functionality
    Given the user is on the Dashboard page
    When the user clicks on the "People" tab in the top menu
    Then the user select lead and click on Send Mail icon on bottom
    When the user send mail from Use Template
    Then the user back from the Email Marketing page
    When the user Send Mail from NOVA AI

  Scenario: Verify Tags Functionality
    Given the user is on the Dashboard page
    When the user clicks on the "People" tab in the top menu
    Then the user select lead and click on Tags icon on bottom
    Then the user create the tag and add new tag
    When the user select and remove the tag

  Scenario: Verify More Actions Functionality
    Given the user is on the Dashboard page
    When the user clicks on the "People" tab in the top menu
    Then the user selects a lead and clicks the "More Actions" icon at the bottom
    When the user selects "Update Stage" and performs the update
    And the user selects "Update Source" and perform the update
    And the user selects "Assign Agent" and assigns an agent

  Scenario: Verify Custom Filter Functionality
    Given the user is on the Dashboard page
    When the user clicks on the "People" tab in the top menu
    Then the user performs the First Name filter
    When the user performs the Last Name filter
    Then the user performs the Email filter
    When the user performs the Phone filter
    Then the user performs the Stages filter
    When the user performs the Tags filter
    Then the user performs the Source filter
    When the user performs the Lead Type filter
    When the user performs the Last Communication filter

  Scenario: Verify Custom Filter Created Functionality
    Given the user is on the Dashboard page
    When the user clicks on the "People" tab in the top menu
    Then the user performs the Created filter

  Scenario: Verify Import People Functionality
    Given the user is on the Dashboard page
    When the user clicks on the "People" tab in the top menu
    And the user clicks on the "Import People" button and uploads a valid file
    And the user fills in all mandatory fields and clicks the "Next" button
    And the user selects or adds tags
    Then the user clicks the "Submit" button and the lead is imported successfully
    Then the user check the CSV Status

  Scenario: Verify Add and Edit Lead Details Functionality
    Given the user is on the Dashboard page
    When the user clicks on the "People" tab in the top menu
    Then the user selects a lead from the list
    And the user performs a call to the lead
    When the user sends a text message to the lead
    Then the user sends an email to the lead
    When the user add the lead details