Feature: This feature describes different parameterizations available in cucumber


#Scenario: How to parameterize numeric values

#	Given I have two numbers 15 and 63
#	When I add them
#	Then Print the result
	
#Scenario: How to parameterize floating numbers
#	Given I have two float numbers 3.23 and 5.1
#	Then Display numbers
	
#Scenario: How to parameterize string
#	Given I have a fruite "banana"
#	Then Display its "yellow"
	
Scenario: How to parameterize list
	Given I have following <states>
		|Maharashtra   |36| MH |
		|Gujrat        |33| GJ |
		|West Bengal   |23| WB |
		|Tamil Nadu    |38| TN |
		|Andhra Pradesh|26| AP |
		|Telangana     |31|	TL |
		|Chattisgarh   |23| CH |


Scenario Outline: How to perform data driven testing
	Given I have <row_num>
	When I add them
	Then print if their addition is prime
	
Examples:
	|row_num|
	|1|
	|2|
	|3|
	|4|
	|5|
	|6|
	|7|
	|8|
	|9|
	|10|
	
