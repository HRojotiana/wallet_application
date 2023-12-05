CREATE TABLE IF NOT EXISTS "account"(
    id VARCHAR(100) PRIMARY KEY,
    account_name VARCHAR(100),
    account_type VARCHAR(100) CHECK (
        account_type ILIKE 'general' OR
        account_type ILIKE 'cash' OR
        account_type ILIKE 'my account' OR
        account_type ILIKE 'credit card' OR
        account_type ILIKE 'overdraft account' OR
        account_type ILIKE 'savings' OR
        account_type ILIKE 'bonus' OR
        account_type ILIKE 'insurance' OR
        account_type ILIKE 'investment' OR
        account_type ILIKE 'loan' OR
        account_type ILIKE 'mortgage'
    ),
    balance FLOAT,
    currency_id VARCHAR(100) REFERENCES "currency"(id),
    transaction_id VARCHAR(100) REFERENCES "transaction"(id)
);


INSERT INTO "account" (id, account_name, account_type, balance, currency_id, transaction_id)
VALUES
    ('A1', 'Main Account', 'general', 5000.00, 'USD', '101'),
    ('A2', 'Savings Account', 'savings', 10000.00, 'EUR', '102'),
    ('A3', 'Credit Card', 'credit card', -500.00, 'USD', '103');