INSERT INTO food_delivery.users (first_name, last_name, email, mobile_no, password_hash, user_type, status)
VALUES 
('John', 'Doe', 'john.doe@example.com', '9876543210', 'password123', 'CUSTOMER', 'ACTIVE'),
('Alice', 'Smith', 'alice.smith@example.com', '9123456780', 'password123', 'RESTAURANT_ADMIN', 'ACTIVE'),
('Bob', 'Delivery', 'bob.delivery@example.com', '9988776655', 'password123', 'DELIVERY_AGENT', 'ACTIVE');

INSERT INTO food_delivery.user_address (user_id, address_line1, city, state, country, postal_code, is_default)
VALUES
(1, '123 Main Street', 'Bengaluru', 'Karnataka', 'India', '560001', true),
(2, '45 MG Road', 'Mumbai', 'Maharashtra', 'India', '400001', true),
(3, '78 Park Lane', 'Delhi', 'Delhi', 'India', '110001', true);