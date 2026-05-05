# Crypto Transaction Monitoring System

A distributed, event-driven system for tracking cryptocurrency portfolios and performing real-time risk analysis.


## 🚀 Overview

This project demonstrates a **microservices architecture** using:

- Java (Spring Boot) for API and business logic
- Apache Kafka for event streaming
- Rust for high-performance risk analysis
- Docker for containerized deployment



## ⚙️ Architecture

                        
    ┌───────── ┐      ┌────────── ┐      ┌─────── ┐      ┌────────────────── ┐
    | Client   | ---> | Java API  | ---> | Kafka  | ---> | Rust Risk Engine  |                           
    └──────────┘      └───────────┘      └────────┘      └───────────────────┘

### Flow:

1. User requests portfolio evaluation
2. Java service fetches crypto prices via external API
3. Portfolio value is calculated
4. Event is published to Kafka (`portfolio-events`)
5. Rust service consumes event
6. Risk analysis is performed asynchronously


## ⚙️ Tech Stack

### Backend
- Java (Spring Boot)
- PostgreSQL
- Kafka (event streaming)

### Data Processing
- Rust (rdkafka, tokio)

### Infrastructure
- Docker & Docker Compose

## 📦 Services

### 🟦 Java Service (Portfolio API)
- Calculates portfolio value
- Integrates with external crypto API
- Publishes Kafka events

### 🟥 Rust Service (Risk Engine)
- Consumes Kafka events
- Performs risk analysis (portfolio concentration)
- Logs insights


## 📡 API Documentation

### Wallet APIs:
### 🔹 Create Wallet

**POST** `/api/wallets`

#### Request Body

```json
{
  "assets": {
    "BTC": 0.5,
    "ETH": 2
  }
}
```

### 🔹 Get Wallet by ID

**GET** `/api/wallets/{id}`

#### Path parameter

| Name | Type | Description |
| ---- | ---- | ----------- |
| id   | Long | Wallet ID   |

### Portfolio APIs:
### 🔹 Calculate Portfolio Value

**GET** `/api/wallets/{id}/portfolio`

#### Path parameter

| Name | Type | Description |
| ---- | ---- | ----------- |
| id   | Long | Wallet ID   |

#### Response
```json
{
  "totalValue": 25000,
  "breakdown": {
    "BTC": 20000,
    "ETH": 5000
  }
}
```

### Kafka Event (produced)
#### topic - (`portofolio-events`)
```json
{
  "walletId": 1,
  "totalValue": 25000,
  "assets": {
    "BTC": 20000,
    "ETH": 5000
  }
}
```

### Rust Risk Engine (consumer)
#### example output
```json
📥 Received event: PortfolioEvent { walletId: 1, totalValue: 25000.0, assets: {...} }

⚠️ Risk Analysis:
Total Value: 25000
Max Asset Share: 80.00%

🚨 HIGH RISK: Portfolio too concentrated!
```


## ▶️ Running the Project

1. Clone the repo
2. Configure a (`.env`) file with those properties
CRYPTO_EXTERNAL_API_BASE_URL=https://api.freecryptoapi.com/v1
CRYPTO_EXTERNAL_API_TOKEN=${your_token}
3. Run with docker (`docker-compose up --build`)


## Made by @Giacomo Pumapillo
