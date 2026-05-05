//! Portfolio event data models for crypto transaction monitoring.
//!
//! This module defines the core data structures used to represent portfolio events
//! and asset holdings in the crypto monitoring and risk engine system.

use serde::{Deserialize, Serialize};
use std::collections::HashMap;

/// Represents a portfolio event containing wallet and asset information.
///
/// A `PortfolioEvent` captures a snapshot of a wallet's state at a specific point in time,
/// including the total portfolio value and the holdings of individual assets.
///
/// # Fields
///
/// * `walletId` - Unique identifier for the wallet associated with this portfolio event
/// * `totalValue` - Total value of all assets in the portfolio (in base currency)
/// * `assets` - HashMap containing asset symbols/names mapped to their quantities held in the wallet
///
/// # Example
///
/// ```
/// use std::collections::HashMap;
/// # use model::PortfolioEvent;
///
/// let mut assets = HashMap::new();
/// assets.insert("BTC".to_string(), 1.5);
/// assets.insert("ETH".to_string(), 25.0);
///
/// let event = PortfolioEvent {
///     walletId: 12345,
///     totalValue: 75000.0,
///     assets,
/// };
/// ```
#[derive(Debug, Serialize, Deserialize)]
pub struct PortfolioEvent {
    /// Unique identifier for the wallet
    pub walletId: i64,

    /// Total portfolio value in base currency (e.g., USD)
    pub totalValue: f64,

    /// Map of asset symbols to their quantities held in the wallet
    pub assets: HashMap<String, f64>,
}