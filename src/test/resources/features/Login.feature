Feature: Verify Login functionality
  Scenario: Verify user login with valid login details
    Given User on login screen
    When user enters valid email id and password
    And tap on sign in button
    Then User must redirect to My Account page


    Scenario Outline: Verify when user do login with invalid login details
      Given User on login screen
      When user enters valid <Email_id> id and <Password>
      And tap on sign in button
      Then User must see error <error_message>
      Examples:
        | Email_id  | Password | error_message |
        |           |          | An email address required. |
        |           |          | Password is required.      |
        | abcd@as.com | xyz@12345  | Authentication failed.     |
