# Bible Search Project

A Spring Boot application for searching and retrieving Bible verses and chapters via RESTful API endpoints. This project provides a backend service for querying Bible text, supporting keyword search, chapter retrieval, and verse lookup with pagination.

## Features
- Search Bible verses by keyword (case-insensitive, paginated)
- Retrieve all verses in a chapter
- Get a specific verse by book, chapter, and verse number
- RESTful API design
- CORS configuration for frontend integration

## Technologies Used
- Java 17+
- Spring Boot
- Spring Data JPA
- Maven

## Getting Started

### Prerequisites
- Java 17 or higher
- Maven

### Setup
1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd bibleSearchProject/bibleSearch
   ```
2. Build the project:
   ```bash
   ./mvnw clean install
   ```
3. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```

The application will start on `http://localhost:8080` by default.

## API Endpoints

### Search Verses by Keyword
```
GET /search?query={keyword}&page={page}&size={size}
```
- Returns paginated verses containing the keyword.
- Example: `/search?query=love&page=0&size=10`

### Get All Verses in a Chapter
```
GET /{bookId}/{chapter}
```
- Returns all verses in the specified book and chapter.
- Example: `/1/3` (Book 1, Chapter 3)

### Get Specific Verse
```
GET /{bookId}/{chapter}/{verse}
```
- Returns the specified verse.
- Example: `/1/3/16` (Book 1, Chapter 3, Verse 16)

## Project Structure
- `controller/` - REST controllers
- `model/` - Entity classes (`Books`, `Verses`)
- `repository/` - Spring Data JPA repositories
- `configuration/` - CORS and other configurations
- `resources/` - Application properties and static files

## Contributing
Pull requests are welcome! For major changes, please open an issue first to discuss what you would like to change.

## License
This project is licensed under the MIT License.

