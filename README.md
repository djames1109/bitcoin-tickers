#Challenge #1: Bitcoin Tickers

## Usage

### Prerequisites

- A Java development environment (Recommended IDE: IntelliJ IDEA)
- git
- Apache Maven

### Getting Started

- Clone the project.
- Build by using `mvn clean package`
- Run the application by using command `java -jar target/bitcoin-tickers.jar`
- or `mvn clean spring-boot:run` to directly run the application without building.

### Endpoints

*GetLowestSellingPrice*
- **Method**: GET
- **Endpoint**: /bitcoin/lowest-selling-price

Example:

`curl http://localhost:8080/bitcoin/lowest-selling-price`

response: `{"name":"Bitcoin","sellPrice":44455.41}`
