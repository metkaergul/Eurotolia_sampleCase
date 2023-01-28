Feature: user should be able to search a product and add in the shopping cart

    Scenario: user succesfully logins with valid credentials
        Given user is on the HomePage
        When user clicks login button under myAccount dropdown
        And user enters valid email and password
        And user clicks Login button
        Then verify user succesfully logs in

    Scenario: user can search a product
        When user searches "iPhone 14 lcd" on the homePage
        Then verify user sees only 1 item
        And verify Product item number is 18855

    Scenario: product prices on searchResultsPage and on productDetailsPage succesfully matches
        When user navigates from searchResultsPage to productDetailsPage by clicking on product
        Then verify productPrice matches in both searchResultsPage and productDetailsPage

    Scenario: user should successfully add product to shopping cart
        When user click Add to Cart button
        Then verify user see successfully added message
        And verify cart Badge is displayed

    Scenario: product should successfully be added in shopping cart page
        When user navigates to shopping cart page
        Then verify product with same info is displayed
        And verify total product amount is "291.55 €"

