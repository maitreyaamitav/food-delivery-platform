CREATE TABLE food_delivery.users (
    user_id BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100),
    email VARCHAR(255) NOT NULL UNIQUE,
    mobile_no VARCHAR(20) UNIQUE,
    password_hash VARCHAR(500) NOT NULL,
    user_type VARCHAR(30) NOT NULL CHECK (user_type IN ('CUSTOMER','RESTAURANT_ADMIN','DELIVERY_AGENT','SYSTEM_ADMIN')),
    status VARCHAR(20) NOT NULL DEFAULT 'ACTIVE' CHECK (status IN ('ACTIVE','INACTIVE','BLOCKED')),
    created_timestamp TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE food_delivery.user_address (
    address_id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL REFERENCES food_delivery.users(user_id),
    address_line1 VARCHAR(500) NOT NULL,
    city VARCHAR(100) NOT NULL,
    state VARCHAR(100) NOT NULL,
    country VARCHAR(100) NOT NULL DEFAULT 'India',
    postal_code VARCHAR(20) NOT NULL,
    is_default BOOLEAN NOT NULL DEFAULT FALSE
);