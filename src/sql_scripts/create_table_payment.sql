CREATE TABLE IF NOT EXISTS "payment"(
    id VARCHAR(100) PRIMARY KEY,
    payment_mode VARCHAR(100) CHECK(payment_mode ILIKE 'cash' OR
                                    payment_mode ILIKE 'debit card' OR
                                    payment_mode ILIKE 'transfer' OR
                                    payment_mode ILIKE 'voucher' OR
                                    payment_mode ILIKE 'mobile payment'),
    payment_status VARCHAR(100) CHECK (payment_status ILIKE 'bank reconciliation done' OR
                                       payment_status ILIKE 'cancelled' OR
                                       payment_status ILIKE 'validated')
    );

    INSERT INTO "payment" (id, payment_mode, payment_status)
    VALUES
        ('1', 'cash', 'bank reconciliation done'),
        ('2', 'debit card', 'validated'),
        ('3', 'transfer', 'cancelled');