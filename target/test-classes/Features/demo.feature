Feature: Visit iFrame page and verify no of images
	
	Scenario: Navigate to iFrame page and verify no of images
		
		Given I go to home page
		When  click on iFrame link
		And Shift control to newly opened tab
		Then verify the no of images