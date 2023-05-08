Feature: User Registeration
	I want to check that the user can register in nocommerce webiste
	
Scenario Outline: User Registeration
Given the user is in the home page
When the user clicks on the registeration button
And the user enters "<fname>","<lname>","<email>","<pass>"
Then The user is prompted to the successful registeration page
Examples:
|fname|lname|email|pass| 
|omar|ali|email1@test.com|123456|
|gaber|hassan|email2@test.com|123456|