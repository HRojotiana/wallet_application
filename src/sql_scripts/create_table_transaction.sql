CREATE TABLE IF NOT EXISTS "transaction"(
    id VARCHAR(100) PRIMARY KEY,
    category VARCHAR(100),
    label VARCHAR(100),
    date timestamp,
    payment_id VARCHAR(100) REFERENCES "payment"(id)
);