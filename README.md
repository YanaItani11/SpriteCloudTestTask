# SpriteCloudTestTask


# Overview
This project contains automated tests for both UI (Selenium) using Java and API (Postman). 
As for Selenium, testNG was used to run the tests as well as store parameters. 
In the tests folder, there is a BaseTest that contains Before method and After method, which helps to setup and quit the driver provider without additional code in each test. 

# UI tests:
  ### 1. Write a full checkout that contains, at least, two items. Validate the final price.
  Assumptions: 
  Since the tax was added upon checkout and was stated separately from the items final price, I calculated the final price of the items in a loop and then added the tax to the final price of the items. 

### 2. Write a test that sorts the items by name Z-A and validate that the sorting is correct.

Assumptions: 
In order to verify items are sorted from Z to A I i used loop, where compareTo function was used in order to see if the next item is alphabetically bigger than the previous one.

### 3. Write a validation for a failed log in.

# Test reports: 
Test reports are available here: build/reports/tests/test

# API tests: 
The following test were implemented: 
Note: All the requests have the following {{baseURL}} implemented: https://reqres.in/api/

### 1. Retrieve a list of users

  Endpoint: users?page=1
  Method: GET
  Validation: 
  - Response status code is 200
  - Verify a list of users is displayed
  - Verify there are 6 users per page


### 2. Perform a successful login

Endpoint: login
Method: POST
Validation: 
- Response status code is 200
- Response has the required field - token

### 3. Perform an update

Endpoint: users/2
Method: PUT
Validation: 
- Response status code is 200
- Update was successful

### 4. Perform a deletion

Endpoint: users/2
Method: DELETE
Validation: 
- Response status code is 204
- Verify user is deleted

### 5. Perform unsuccessful registration

Endpoint: register
Method: POST
Validation: 
- Response status code is 400
- Verify password is missing

### 6. Invalid user is not found

Endpoint: users/23
Method: GET
Validation: 
- Response status code is 404
- Verify user is not found

### 7. Execute a parameterized delayed request (max 3 seconds) and evaluate how long the
request takes

Endpoint: users?delay={{delaySeconds}} parameter 
Method: GET
Validation: 
- Response time is within expected range


# AI and google usage: 
Googled and used chatGPT in order to create github action as it was my first time creating it. 
Used stackoverflow and google to use JS executors in order to get the tax separately from the dollar sign and text as well as the final price. 

As for API automation, I used Postbot to help generate tests, that I adjusted in accordance to my needs. 
