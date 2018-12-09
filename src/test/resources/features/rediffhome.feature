#Feature: As a visitor I want to register in the rediff site so that I can log onto the sit
#
#  Background:
#    Given User is on the rediff site home page
#
#  Scenario Outline: As a visitor I want to register in the rediff site so that I can log onto the site
#    Given the user registers with the "<FullName>","<Email_Id>","<Password>","<RetypePassword>","<DateOfBirth>","<Gender>","<ILiveIn>","<City>"
#    Then the user is successfully registered in the rediff site
#
#    Examples:
#      | FullName | Email_Id                 | Password     | RetypePassword | DateOfBirth | Gender | ILiveIn        | City   |
#      | domee    | poornimav23@yahoo.co.in  | ravaIdli@23  | ravaIdli@23    | 15/01/1990  | M      | United Kingdom | London |


#  Scenario: When the user does not enter mandatory fields then the application throws a error message
#    Given the user is on the rediff site home page
#    And the user enters the "<Email_Id>","<Password>","<RetypePassword>","<DateOfBirth>","<Gender>","<ILiveIn>"
#    And the user enters the verificationcode
#    Then the application throw a error message
#
#
#  Scenario: When the user special characters in the name field then the application throws a error message
#    Given the user is on the rediff site home page
#    And the user enters the special characters in "<FullName>",<Email_Id>","<Password>","<RetypePassword>","<DateOfBirth>","<Gender>","<ILiveIn>"
#    And the user enters the verificationcode
#    Then the application throw a error message
#
#
#  Scenario: When the user numbers in the name field then the application throws a error message
#    Given the user is on the rediff site home page
#    And the user enters the numbers in "<FullName>",<Email_Id>","<Password>","<RetypePassword>","<DateOfBirth>","<Gender>","<ILiveIn>"
#    And the user enters the verificationcode
#    Then the application throw a error messag
