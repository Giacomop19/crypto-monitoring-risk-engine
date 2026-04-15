# Real-Time Crypto Monitoring, Wallet & Alert System

A multi-component application for real-time monitoring of cryptocurrency wallets and transactions, featuring wallet management and a dedicated alert system built in Rust for risk assessment and notifications.

## Features

- **Real-Time Monitoring**: Continuous tracking of cryptocurrency transactions and wallet activities.
- **Wallet Management**: Create and retrieve wallet information.
- **Alert System**: Rust-based module for risk scoring, analysis, and real-time alerts on crypto activity.
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
- Rust

## Getting Started

### Prerequisites

- Java 17
- Maven
- PostgreSQL
- Docker (optional, for containerized setup)
- Rust (for the alert system component)

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