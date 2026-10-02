-- Payment transaction audit table
CREATE TABLE payment_transaction (
    id BIGSERIAL PRIMARY KEY,
    payment_id BIGINT NOT NULL,
    gateway_request JSONB,
    gateway_response JSONB,
    status VARCHAR(50) NOT NULL,
    created_at TIMESTAMPTZ DEFAULT NOW(),
    CONSTRAINT fk_transaction_payment FOREIGN KEY (payment_id) REFERENCES payment(id)
);

CREATE INDEX idx_payment_transaction_payment_id ON payment_transaction(payment_id);
