-- Seed data for Order Service
-- Script: V301__20260928_OSS_01_DML.sql

-- Insert a sample order (customer_id=1, restaurant_id=1 must exist from User/Restaurant seeds)
INSERT INTO orders (customer_id, restaurant_id, total_amount, status, created_at)
VALUES 
(1, 1, 280.00, 'CREATED', CURRENT_TIMESTAMP);

-- Insert order items (menu_item_id=1 and 2 must exist from Restaurant seeds)
INSERT INTO order_items (order_id, menu_item_id, name, price)
VALUES
(1, 1, 'Paneer Butter Masala', 250.00),
(1, 2, 'Masala Chai', 30.00);

-- Insert order status history
INSERT INTO order_status_history (order_id, old_status, new_status, changed_at)
VALUES
(1, NULL, 'CREATED', CURRENT_TIMESTAMP);

-- Insert into event_outbox (simulating ORDER_CREATED event)
INSERT INTO event_outbox (aggregate_type, aggregate_id, event_type, payload, status, created_at)
VALUES
('Order', 1, 'ORDER_CREATED', 
 '{"orderId":1,"customerId":1,"restaurantId":1,"amount":280.00}', 
 'PENDING', CURRENT_TIMESTAMP);
