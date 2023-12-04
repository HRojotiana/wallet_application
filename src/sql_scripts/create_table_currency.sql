CREATE TABLE IF NOT EXISTS "currency" (
    id varchar(100) PRIMARY KEY,
    currency_code varchar(100) NOT NULL,
    currency_name varchar(100),
    currencySymbol varchar(10),
    exchangeRate varchar(100)
);