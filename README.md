# Crypto Transaction Monitoring

A Spring Boot application for monitoring cryptocurrency transactions. This project allows users to manage wallets and track their transaction history by integrating with external cryptocurrency APIs.

## Features

- **Wallet Management**: Create and retrieve wallet information.
- **Transaction Monitoring**: Fetch and store transaction data from external crypto APIs.
- **REST API**: Provides endpoints for wallet operations.
- **Database Integration**: Uses PostgreSQL for data persistence.
- **Messaging**: Integrates with Kafka for event-driven processing.
- **Caching**: Includes caching support for improved performance.

## Technologies Used

- Java 17
- Spring Boot 4.0.5
- Spring Data JPA
- PostgreSQL
- Kafka
- Maven

## Getting Started

### Prerequisites

- Java 17
- Maven
- PostgreSQL
- Docker (optional, for containerized setup)

### Configuration

Set the following environment variables:

- `CRYPTO_EXTERNAL_API_BASE_URL`: Base URL for the external crypto API
- `CRYPTO_EXTERNAL_API_TOKEN`: API token for authentication

### Running the Application

1. Clone the repository.
2. Navigate to the `crypto-transaction-monitoring` directory.
3. Run `mvn spring-boot:run` or use Docker with `docker-compose up`.

### API Endpoints

- `POST /api/wallets`: Create a new wallet
- `GET /api/wallets/{id}`: Get wallet details
- `GET /api/wallets/health`: Health check

## Project Structure

- `src/main/java`: Java source code
- `src/main/resources`: Configuration files
- `src/test`: Test code
- `Dockerfile`: Docker configuration
- `docker-compose.yml`: Multi-container setup