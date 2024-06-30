### Pre-requisites
- Java 17

### Build and run
To Build the project and execute tests you need to switch to the project directory and run the next command in you terminal
```shell
./gradlew clean build
```

Then you can run the application:
```shell
./gradlew bootRun
```

### Implementation details
The API documentation should be available on http://localhost:8080/swagger-ui/index.html. There you can try out the API endpoints.
Examples of requests:
```shell
# Sum of two numbers
curl -X 'POST' \
  'http://localhost:8080/api/calculator/add?a=123&b=100' \
  -H 'accept: */*' \
  -d ''
```
```shell
# Division of one number by another
curl -X 'POST' \
  'http://localhost:8080/api/calculator/div?a=123&b=22' \
  -H 'accept: */*' \
  -d ''
```
The application receives two parameters a and b. 
Depending on the endpoint, the application calculates the sum, the subtracting, the multiplying and the dividing of these parameters and returns the result in JSON format:
```shell
{
"result": 5.590909090909091
}
```
When divided by zero it returns Bad Request.

##### Notes
The application has been built and tested on MacOS so the provided instructions are valid for MacOS/Unix-based systems.