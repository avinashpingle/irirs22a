Feature: इस file में प्रोडक्ट की सारी टेस्ट केसेस है 	

Scenario: Verify search result for polo men
	And मिंत्रा का पेज खुला होना चाहिए
	When user searches for product "t-shirt"
	Then all results should be related to polo

Scenario: Verify if search by popularity yeilds proper results
	And मिंत्रा का पेज खुला होना चाहिए
	When user hovers on men menue
	And user clicks on men t-shirt
	Then user selects popularity filter