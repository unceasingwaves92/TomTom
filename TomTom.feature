Feature: TomTom Developer

Scenario Outline: Register admin key

And set the Content type
When place the post request as <FilePath>
Then verify the status code as 200
And verify the Content type as json

Examples:
|FilePath|
|./data/register.json|


Scenario Outline: Add new project using the registered admin key

And set the Content type registered admin key
When place the post request with admin key <FilePath>
Then verify the status code as 201
And verify the Content type as json

Examples:
|FilePath|
|./data/newproject.json|


Scenario: List projects and confirm the new project is available
 
And set the Content type
When place the get request without body
Then verify the status code as 200
And verify the Content type as json
And verify the response
	
Scenario Outline: Regenerate admin key

And set the Content type
And regenerate admin key <FilePath>
Then verify the status code as 200
And verify the Content type as json

Examples:
|FilePath|
|./data/regeneratekey.json|

Scenario Outline: Add new fence using the regenerated admin key

And set the Content type regenerate admin key
When place the post request with regenerate key <FilePath>
Then verify the status code as 201
And verify the Content type as json

Examples:
|FilePath|
|./data/tomtom2.json|


Scenario: Get fences transitions and check for the fence that is newly created

And set the Content type
When place the get fence transitions without body
Then verify the status code as 200
And verify the Content type as json
And verify the response of transitions

