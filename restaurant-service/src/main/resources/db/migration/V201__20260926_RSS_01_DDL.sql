-- Restaurant master
CREATE TABLE restaurant (
    restaurant_id BIGSERIAL PRIMARY KEY,
    restaurant_code VARCHAR(50) UNIQUE NOT NULL,
    name VARCHAR(255) NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'ACTIVE',
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ
);

-- Restaurant address
CREATE TABLE restaurant_address (
    address_id BIGSERIAL PRIMARY KEY,
    restaurant_id BIGINT NOT NULL,
    street VARCHAR(255),
    city VARCHAR(100),
    state VARCHAR(100),
    postal_code VARCHAR(20),
    country VARCHAR(100),
    CONSTRAINT fk_restaurant FOREIGN KEY (restaurant_id) REFERENCES restaurant(restaurant_id)
);

-- Category
CREATE TABLE category (
    category_id BIGSERIAL PRIMARY KEY,
    category_name VARCHAR(100) UNIQUE NOT NULL
);

-- Menu item
CREATE TABLE menu_item (
    menu_item_id BIGSERIAL PRIMARY KEY,
    restaurant_id BIGINT NOT NULL,
    category_id BIGINT NOT NULL,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    price NUMERIC(12,2) NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'AVAILABLE',
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    CONSTRAINT fk_restaurant_menu FOREIGN KEY (restaurant_id) REFERENCES restaurant(restaurant_id),
    CONSTRAINT fk_category FOREIGN KEY (category_id) REFERENCES category(category_id)
);
