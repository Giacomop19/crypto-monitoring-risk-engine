//! Crypto Transaction Monitoring Risk Engine
//!
//! This is the main entry point for the Rust-based risk engine component of the crypto monitoring system.
//! It consumes portfolio events from a Kafka broker and performs real-time risk analysis, specifically
//! detecting portfolio concentration risks.
//!
//! # Overview
//!
//! The engine:
//! - Connects to a Kafka broker and subscribes to the `portfolio-events` topic
//! - Deserializes incoming JSON messages into `PortfolioEvent` structures
//! - Analyzes each portfolio for concentration risk (single asset dominance)
//! - Alerts when a portfolio is found to be too concentrated (>70% in a single asset)
//!
//! # Architecture
//!
//! The system uses:
//! - **Kafka** for message streaming and event consumption
//! - **Tokio** for async runtime
//! - **serde_json** for JSON deserialization
//! - **rdkafka** for Kafka client integration

mod model;

use rdkafka::consumer::{Consumer, StreamConsumer};
use rdkafka::config::ClientConfig;
use rdkafka::message::Message;
use tokio;
use crate::model::PortfolioEvent;

/// Main entry point for the risk engine.
///
/// Initializes a Kafka consumer, subscribes to portfolio events, and runs an infinite loop
/// to process incoming events and perform risk analysis. This function uses Tokio for async
/// execution and will continue running indefinitely until the process is terminated.
///
/// # Kafka Configuration
///
/// - **Bootstrap Servers**: `kafka:9092` (Docker internal network address)
/// - **Consumer Group**: `risk-engine-group`
/// - **Topic**: `portfolio-events`
/// - **Auto Offset Reset**: Reads from earliest available message on startup
///
/// # Message Processing
///
/// For each received message:
/// 1. Extract payload bytes and convert to UTF-8 string
/// 2. Deserialize JSON into a `PortfolioEvent` struct
/// 3. Pass the event to `process_risk` for analysis
/// 4. Handle and log any deserialization errors
#[tokio::main]
async fn main() {

    let consumer: StreamConsumer = ClientConfig::new()
        .set("bootstrap.servers", "kafka:9092")
        .set("group.id", "risk-engine-group")
        .set("auto.offset.reset", "earliest")
        .create()
        .expect("Failed to create consumer");

    consumer.subscribe(&["portfolio-events"])
        .expect("Failed to subscribe");

    println!("🦀 Rust Risk Engine started...");

    loop {
        match consumer.recv().await {
            Err(e) => eprintln!("Kafka error: {}", e),
            Ok(msg) => {
                if let Some(payload) = msg.payload() {
                    
                    let json = std::str::from_utf8(payload).unwrap();

                    match serde_json::from_str::<PortfolioEvent>(json) {
                        Ok(event) => {
                            println!("📥 Received event: {:?}", event);

                            process_risk(event);
                        }
                        Err(e) => {
                            eprintln!("❌ Failed to deserialize: {}", e);
                        }
                    }
                }
            }
        }
    }
}

/// Analyzes a portfolio event for concentration risk.
///
/// This function calculates portfolio concentration by finding the largest single asset position
/// as a percentage of the total portfolio value. High concentration (>70%) indicates excessive
/// risk exposure to a single asset and triggers an alert.
///
/// # Risk Metrics
///
/// - **Concentration Ratio**: Calculated as `max_asset_value / total_portfolio_value`
/// - **Risk Threshold**: 70% concentration is considered high risk
///
/// # Arguments
///
/// * `event` - A `PortfolioEvent` containing wallet ID, total value, and asset holdings
///
/// # Output
///
/// Prints risk analysis details including:
/// - Total portfolio value
/// - Maximum asset concentration percentage
/// - Risk level alert if concentration exceeds threshold
///
/// # Example Risk Levels
///
/// - Concentration ≤ 70%: Acceptable risk
/// - Concentration > 70%: HIGH RISK alert issued
fn process_risk(event: PortfolioEvent) {
    let mut max_asset = 0.0;

    for (_, value) in &event.assets {
        if *value > max_asset {
            max_asset = *value;
        }
    }

    let concentration = max_asset / event.totalValue;

    println!("⚠️ Risk Analysis:");
    println!("Total Value: {}", event.totalValue);
    println!("Max Asset Share: {:.2}%", concentration * 100.0);

    if concentration > 0.7 {
        println!("🚨 HIGH RISK: Portfolio too concentrated!");
    }
}