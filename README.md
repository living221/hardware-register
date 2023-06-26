# Hardware-register

## Getting Started

### Prerequisites

Ensure you have the following installed on your system:

- Java Development Kit (JDK) 8 or later
- Docker
- PostgreSQL

### Building the Project
Clone the repository:

git clone https://github.com/living221/hardware-register

Change the current directory to the project root:

cd hardware-register

Build the project using Maven:

./mvnw clean install

Run the Docker container for PostgreSQL:

docker-compose up -d

### Running the Application

Run the application using the following command:

`./mvnw spring-boot:run`

The application will start on port 8080. Access the public API at
`http://localhost:8080`.

Swagger open API documentation is available at 
`http://localhost:8080/swagger-ui/index.html`.

test