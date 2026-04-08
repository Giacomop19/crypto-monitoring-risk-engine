-- Create Wallet table
CREATE TABLE wallet (
    id BIGSERIAL PRIMARY KEY,
    address VARCHAR(255) NOT NULL,
    balance DOUBLE PRECISION NOT NULL
);

-- Create Transaction table
CREATE TABLE transaction (
    id BIGSERIAL PRIMARY KEY,
    tx_id VARCHAR(255) NOT NULL,
    amount DOUBLE PRECISION NOT NULL,
    timestamp TIMESTAMP NOT NULL,
    risk_level VARCHAR(255),
    wallet_id BIGINT NOT NULL,
    FOREIGN KEY (wallet_id) REFERENCES wallet(id)
);

-- Create index on wallet address for faster lookups
CREATE INDEX idx_wallet_address ON wallet(address);

-- Create index on transaction wallet_id for faster lookups
CREATE INDEX idx_transaction_wallet_id ON transaction(wallet_id);
