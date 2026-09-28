-- Orders table
CREATE TABLE orders (
    order_id BIGSERIAL PRIMARY KEY,
    customer_id BIGINT NOT NULL,
    restaurant_id BIGINT NOT NULL,
    total_amount NUMERIC(12,2) NOT NULL,
    status VARCHAR(30) NOT NULL,
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ,
    CONSTRAINT fk_customer FOREIGN KEY (customer_id) REFERENCES users(user_id),
    CONSTRAINT fk_restaurant FOREIGN KEY (restaurant_id) REFERENCES restaurant(restaurant_id)
);

-- Order items
CREATE TABLE order_items (
    order_item_id BIGSERIAL PRIMARY KEY,
    order_id BIGINT NOT NULL,
    menu_item_id BIGINT NOT NULL,
    name VARCHAR(255) NOT NULL,
    price NUMERIC(12,2) NOT NULL,
    CONSTRAINT fk_order FOREIGN KEY (order_id) REFERENCES orders(order_id),
    CONSTRAINT fk_menu_item FOREIGN KEY (menu_item_id) REFERENCES menu_item(menu_item_id)
);

-- Order status history
CREATE TABLE order_status_history (
    history_id BIGSERIAL PRIMARY KEY,
    order_id BIGINT NOT NULL,
    old_status VARCHAR(30),
    new_status VARCHAR(30) NOT NULL,
    changed_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    CONSTRAINT fk_order_history FOREIGN KEY (order_id) REFERENCES orders(order_id)
);

-- Event outbox (for reliable event publication)
CREATE TABLE event_outbox (
    event_id BIGSERIAL PRIMARY KEY,
    aggregate_type VARCHAR(50) NOT NULL,
    aggregate_id BIGINT NOT NULL,
    event_type VARCHAR(50) NOT NULL,
    payload JSONB NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'PENDING',
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);
