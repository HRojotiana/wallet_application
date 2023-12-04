CREATE TABLE IF NOT EXISTS "transaction"(
    id VARCHAR(100) PRIMARY KEY,
    category VARCHAR(100),
    label VARCHAR(100),
    date timestamp,
    payment_id VARCHAR(100) REFERENCES "payment"(id)
);

INSERT INTO "transaction" (id, category, label, date, payment_id)
VALUES
    ('101', 'expense', 'Groceries', '2023-12-01', '1'),
    ('102', 'income', 'Salary', '2023-12-02', '2'),
    ('103', 'expense', 'Rent', '2023-12-03', '3');
