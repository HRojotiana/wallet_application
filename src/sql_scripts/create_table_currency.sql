CREATE TABLE IF NOT EXISTS "currency" (
    id varchar(100) PRIMARY KEY,
    currency_code varchar(100) NOT NULL,
    currency_name varchar(100),
    currency_symbol varchar(10),
    exchangeRate varchar(100)
);

INSERT INTO "currency" (id, currency_code, currency_name, currency_symbol, exchangeRate)
VALUES
    ('USD', 'USD', 'US Dollar', '$', '1.00'),
    ('EUR', 'EUR', 'Euro', '€', '0.85'),
    ('GBP', 'GBP', 'British Pound', '£', '0.73');