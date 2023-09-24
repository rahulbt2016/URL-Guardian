# **NetSafe API**

NetSafe API provides services for analyzing URLs using the VirusTotal API. The API retrieves analysis data, processes it, and then sends back a decision based on the malicious or suspicious votes.

### Features

* Score URLs based on malicious and suspicious votes.
* Cache results for faster response times.
* Utilizes Spring's RestTemplate for HTTP communication.

### Configuration-driven API key management.

#### Prerequisites
* Java 8 or higher
* Maven (for dependency management)
* Redis (for caching)
#### Configuration
Configuration settings are located in the ApiConfig class. Ensure to set your VirusTotal API key before running the application.

#### Endpoints
POST /scoreUrl

Accepts a JSON payload containing a URL and returns a decision based on the analysis of the URL.

#### Payload Example:

`{
"intakeUrl": "http://example.com"
}`

#### How to Run

* Clone the repository.
* Navigate to the project root directory.
* Build the project using Maven: mvn clean install
* Run the application: java -jar target/netsafe-api.jar
* The server will start on the default port (usually 8080). 
* Use tools like Postman or CURL to test the endpoint.

#### Dependencies

Spring Boot
Jackson for JSON processing
Redis for caching

#### Developers

1. Rahul Tiwari 
2. Sandeep Das




