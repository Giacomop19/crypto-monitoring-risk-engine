-- Create Wallet table
CREATE TABLE wallet (
    id BIGSERIAL PRIMARY KEY
);

-- Create Wallet Assets table
CREATE TABLE wallet_assets (
    wallet_id BIGINT NOT NULL,
    symbol VARCHAR(10) NOT NULL,
    amount DOUBLE PRECISION,

    PRIMARY KEY (wallet_id, symbol),

    CONSTRAINT fk_wallet
        FOREIGN KEY (wallet_id)
        REFERENCES wallet(id)
        ON DELETE CASCADE
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

-- Create index on transaction wallet_id for faster lookups
CREATE INDEX idx_transaction_wallet_id ON transaction(wallet_id);

commit;
