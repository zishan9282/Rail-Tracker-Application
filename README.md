# Rail Tracker Application

A RESTful Spring Boot application for managing and searching train schedules. This application provides comprehensive APIs for train management, station information, and schedule tracking with search capabilities by station code or name.

## Features

- **Train Management**: Add and retrieve train information
- **Schedule Management**: Complete train schedule tracking with arrival and departure times
- **Station Management**: Manage station details with codes and names
- **Advanced Search**: Search trains by station code or station name
- **API Documentation**: Interactive Swagger UI for API exploration
- **Exception Handling**: Global exception handling for better error management
- **Database Integration**: JPA/Hibernate integration with relational database

## Tech Stack

- **Framework**: Spring Boot 3.x
- **Language**: Java 17+
- **Database**: JPA/Hibernate (H2/MySQL/PostgreSQL compatible)
- **API Documentation**: Swagger/OpenAPI 3.0
- **Build Tool**: Maven/Gradle
- **Additional Libraries**: 
  - Lombok (for boilerplate code reduction)
  - Spring Data JPA
  - Spring Web

## Prerequisites

- Java 17 or higher
- Maven 3.6+ or Gradle 7+
- MySQL/PostgreSQL (or use embedded H2 for development)
- Git

## Installation

### 1. Clone the Repository

```bash
git clone https://github.com/zishan9282/Rail-Tracker-Application.git
cd Rail-Tracker-Application
```

### 2. Configure Database

Update `application.properties` or `application.yml`:

```properties
# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/rail_tracker
spring.datasource.username=your_username
spring.datasource.password=your_password

# JPA Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# Server Port
server.port=8085
```

### 3. Build the Project

Using Maven:
```bash
mvn clean install
```

Using Gradle:
```bash
gradle build
```

### 4. Run the Application

Using Maven:
```bash
mvn spring-boot:run
```

Using Gradle:
```bash
gradle bootRun
```

Or run the JAR file:
```bash
java -jar target/TrainApplication-0.0.1-SNAPSHOT.jar
```

### 5. Access Swagger UI

Once the application is running, access the interactive API documentation:
```
http://localhost:8085/swagger-ui.html
```

## Project Structure

```
com.genie.TrainApplication/
│
├── controller/
│   ├── TrainController.java           # Train CRUD operations
│   └── TrainSearchController.java     # Train search operations
│
├── entity/
│   ├── Train.java                     # Train entity
│   ├── Station.java                   # Station entity
│   └── TrainSchedule.java             # Train schedule entity
│
├── repository/
│   ├── TrainRepository.java           # Train data access
│   ├── StationRepository.java         # Station data access
│   └── TrainScheduleRepository.java   # Schedule data access
│
├── service/
│   ├── TrainService.java              # Train business logic
│   └── TrainSearchService.java        # Search business logic
│
├── exception/
│   ├── TrainAlreadyExistsException.java
│   └── GlobalExceptionHandler.java    # Centralized exception handling
│
└── TrainApplication.java              # Main application class
```

## API Endpoints

### Train APIs

#### Get All Trains
```http
GET /trains
```
Response: List of all trains

#### Add New Train
```http
POST /trains
Content-Type: application/json

{
  "trainName": "Rajdhani Express",
  "trainNumber": "12301"
}
```

### Train Search APIs

#### Search by Station Code
```http
GET /search/by-code?sourceCode=NDLS&destinationCode=BCT
```
Parameters:
- `sourceCode`: Source station code (e.g., NDLS for New Delhi)
- `destinationCode`: Destination station code (e.g., BCT for Mumbai Central)

#### Search by Station Name
```http
GET /search/by-name?sourceName=New Delhi&destinationName=Mumbai Central
```
Parameters:
- `sourceName`: Source station name
- `destinationName`: Destination station name

## Data Models

### Train
```json
{
  "id": 1,
  "trainName": "Rajdhani Express",
  "trainNumber": "12301"
}
```

### Station
```json
{
  "id": 1,
  "stationName": "New Delhi",
  "stationCode": "NDLS"
}
```

### TrainSchedule
```json
{
  "id": 1,
  "arrivalTime": "10:30",
  "departureTime": "10:45",
  "train": {
    "id": 1,
    "trainName": "Rajdhani Express",
    "trainNumber": "12301"
  },
  "source": {
    "id": 1,
    "stationName": "New Delhi",
    "stationCode": "NDLS"
  },
  "destination": {
    "id": 2,
    "stationName": "Mumbai Central",
    "stationCode": "BCT"
  }
}
```

## Exception Handling

The application includes comprehensive exception handling:

- **TrainAlreadyExistsException**: Thrown when attempting to add a duplicate train
- **GlobalExceptionHandler**: Centralized exception handling with meaningful error responses

Error Response Format:
```json
{
  "timestamp": "2025-01-12T10:30:00",
  "status": 409,
  "error": "Conflict",
  "message": "Train Already Exists"
}
```

## Database Schema

### Tables

**Train**
- `id` (Primary Key)
- `train_name` (NOT NULL)
- `train_number` (NOT NULL, UNIQUE)

**Station**
- `id` (Primary Key)
- `station_name` (NOT NULL)
- `station_code` (NOT NULL, UNIQUE)

**TrainSchedule**
- `id` (Primary Key)
- `arrival_time` (NOT NULL)
- `departure_time` (NOT NULL)
- `train_id` (Foreign Key → Train)
- `source_id` (Foreign Key → Station)
- `destination_id` (Foreign Key → Station)

## Development

### Running Tests

```bash
mvn test
```

## Configuration Options

| Property | Description | Default |
|----------|-------------|---------|
| `server.port` | Application port | 8085 |
| `spring.jpa.hibernate.ddl-auto` | DDL mode | update |
| `spring.jpa.show-sql` | Show SQL queries | true |

## Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

### Coding Standards

- Follow Java naming conventions
- Use Lombok annotations to reduce boilerplate
- Write meaningful commit messages
- Add Javadoc comments for public methods
- Include unit tests for new features

## Future Enhancements

- [ ] Add authentication and authorization (Spring Security)
- [ ] Implement pagination for train listings
- [ ] Add train status tracking (on-time, delayed, cancelled)
- [ ] Implement seat availability checking
- [ ] Add ticket booking functionality
- [ ] Real-time train tracking integration
- [ ] Email/SMS notifications for schedule changes
- [ ] Advanced filtering (by train type, class, etc.)
- [ ] Generate PDF reports for schedules
- [ ] Multi-language support

## Troubleshooting

### Common Issues

**Issue**: Application fails to start
- Check if the port 8085 is already in use
- Verify database connection settings
- Ensure Java 17+ is installed

**Issue**: Database connection error
- Verify database credentials in `application.properties`
- Ensure database server is running
- Check if database schema exists

**Issue**: Swagger UI not accessible
- Verify the application is running
- Check if Swagger dependencies are included
- Access the correct URL: `http://localhost:8085/swagger-ui.html`


## Author

**Zishan**
- GitHub: [@zishan9282](https://github.com/zishan9282)

## Contact

For questions or support, please:
- Open an issue on GitHub
- Contact the maintainer

## Acknowledgments

- Spring Boot team for the excellent framework
- Swagger/OpenAPI for API documentation tools
- Lombok project for reducing boilerplate code

---

**Built with ❤️ using Spring Boot**
