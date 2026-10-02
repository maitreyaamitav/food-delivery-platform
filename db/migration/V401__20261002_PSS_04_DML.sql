-- Seed payment record for testing
INSERT INTO payment (order_id, amount, status)
VALUES (1, 280.00, 'INITIATED');

INSERT INTO payment_transaction (payment_id, gateway_request, gateway_response, status)
VALUES (
    1,
    '{"sandbox":"request"}',
    '{"sandbox":"response"}',
    'SUCCESS'
);
