CREATE TABLE IF NOT EXISTS "currency" (
    id varchar(100) PRIMARY KEY,
    currency_code varchar(100) NOT NULL,
    currency_name varchar(100),
    currency_symbol varchar(10),
    exchangerate varchar(100)
);

INSERT INTO "currency" (id, curINSERT INTO "account" (id, account_name, account_type, balance, currency_id, transaction_id)
VALUES
    ('A1', 'Main Account', 'general', 5000.00, 'USD', '101'),
    ('A2', 'Savings Account', 'savings', 10000.00, 'EUR', '102'),
    ('A3', 'Credit Card', 'credit card', -500.00, 'USD', '103');rency_code, currency_name, currency_symbol, exchangeRate)
VALUES
    ('USD', 'USD', 'US Dollar', '$', '1.00'),
    ('EUR', 'EUR', 'Euro', '€', '0.85'),
    ('GBP', 'GBP', 'British Pound', '£', '0.73');