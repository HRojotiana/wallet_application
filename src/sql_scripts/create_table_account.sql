CREATE TABLE IF NOT EXISTS "account"(
    id VARCHAR(100) PRIMARY KEY,
    account_name VARCHAR(100),
    account_type VARCHAR(100) CHECK (account_type ILIKE 'general' OR
                                     account_type ILIKE 'cahs' OR
                                     account_type ILIKE 'my account' OR
                                     account_type ILIKE 'credit card' OR
                                     account_type ILIKE 'overdraft account' OR
                                     account_type ILIKE 'savings' OR
                                     account_type ILIKE 'bonus' OR
                                     account_type ILIKE 'insurance' OR
                                     account_type ILIKE 'investment' OR
                                     account_type ILIKE 'loan' OR
                                     account_type ILIKE 'mortgage'),
    balance FLOAT,
    currency_id VARCHAR(100) REFERENCES "currency"(id),
    transaction_id VARCHAR(100) REFERENCES "transaction"(id)
);