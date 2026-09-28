-- Seed data for Restaurant Service
-- Script: V201__20260928_RSS_01_DML.sql

-- Insert Restaurants
INSERT INTO restaurant (restaurant_code, name, status, created_at)
VALUES 
('RST001', 'Testaurant', 'ACTIVE', NOW()),
('RST002', 'Spice Hub', 'ACTIVE', NOW());

-- Insert Restaurant Addresses
INSERT INTO restaurant_address (restaurant_id, street, city, state, postal_code, country)
VALUES
(1, '123 Main Street', 'Bengaluru', 'Karnataka', '560001', 'India'),
(2, '45 Market Road', 'Mumbai', 'Maharashtra', '400001', 'India');

-- Insert Categories
INSERT INTO category (category_name)
VALUES
('Main Course'),
('Beverages'),
('Desserts');

-- Insert Menu Items
INSERT INTO menu_item (restaurant_id, category_id, name, description, price, status, created_at)
VALUES
(1, 1, 'Paneer Butter Masala', 'Rich tomato gravy with paneer cubes', 250.00, 'AVAILABLE', NOW()),
(1, 2, 'Masala Chai', 'Traditional spiced tea', 30.00, 'AVAILABLE', NOW()),
(2, 1, 'Chicken Biryani', 'Fragrant rice with marinated chicken', 320.00, 'AVAILABLE', NOW()),
(2, 3, 'Gulab Jamun', 'Sweet milk-solid dumplings in syrup', 80.00, 'AVAILABLE', NOW());


