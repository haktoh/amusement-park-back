# DDL de la BBDD  
CREATE TABLE roles (
id BIGSERIAL PRIMARY KEY,
name VARCHAR(255),
created_at TIMESTAMP,
updated_at TIMESTAMP
);

CREATE TABLE users (
id BIGSERIAL PRIMARY KEY,
dni VARCHAR(255),
name VARCHAR(255),
surname VARCHAR(255),
age INTEGER,
cp INTEGER,
mobile INTEGER,
email VARCHAR(255),
email_verified_at TIMESTAMP,
password VARCHAR(255),
remember_token VARCHAR(100),
created_at TIMESTAMP,
updated_at TIMESTAMP,
deleted_at TIMESTAMP
);

CREATE TABLE attractions (
id BIGSERIAL PRIMARY KEY,
name VARCHAR(255),
min_height INTEGER,
max_height INTEGER,
length INTEGER,
created_at TIMESTAMP,
updated_at TIMESTAMP
);

CREATE TABLE ticket_type (
id BIGSERIAL PRIMARY KEY,
name VARCHAR(255),
price NUMERIC(8, 2), -- Usamos NUMERIC para valores monetarios
description TEXT,
created_at TIMESTAMP,
updated_at TIMESTAMP
);

-- Tablas con dependencias
CREATE TABLE role_user (
id BIGSERIAL PRIMARY KEY,
user_id BIGINT,
role_id BIGINT,
created_at TIMESTAMP,
updated_at TIMESTAMP,

    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (role_id) REFERENCES roles(id)
);

CREATE TABLE employees (
id BIGSERIAL PRIMARY KEY,
user_id BIGINT UNIQUE, -- UNIQUE por la cardinalidad 1:1 en el diagrama
attraction_id BIGINT,
created_at TIMESTAMP,
updated_at TIMESTAMP,

    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (attraction_id) REFERENCES attractions(id)
);

CREATE TABLE tickets (
id BIGSERIAL PRIMARY KEY,
date DATE,
customer BIGINT,
ticket_type BIGINT,
price NUMERIC(8, 2), -- Usamos NUMERIC para valores monetarios
validated BOOLEAN,   -- TINYINT(1) se traduce a BOOLEAN
created_at TIMESTAMP,
updated_at TIMESTAMP,

    FOREIGN KEY (customer) REFERENCES users(id),
    FOREIGN KEY (ticket_type) REFERENCES ticket_type(id)
);

-- Tablas con dependencias de segundo nivel
CREATE TABLE payrolls (
id BIGSERIAL PRIMARY KEY,
date DATE,
salary NUMERIC(8, 2), -- Usamos NUMERIC para valores monetarios
employee_id BIGINT,
created_at TIMESTAMP,
updated_at TIMESTAMP,

    FOREIGN KEY (employee_id) REFERENCES employees(id)
);

CREATE TABLE tickets_data (
id BIGSERIAL PRIMARY KEY,
name VARCHAR(255),
surname VARCHAR(255),
age INTEGER,
ticket BIGINT,
created_at TIMESTAMP,
updated_at TIMESTAMP,

    FOREIGN KEY (ticket) REFERENCES tickets(id)
);

-- Creación de Índices para las Foreign Keys (mejora el rendimiento)
-- El diagrama menciona "Indexes" en todas las tablas;
-- las PK ya se indexan automáticamente.
CREATE INDEX idx_role_user_user_id ON role_user(user_id);
CREATE INDEX idx_role_user_role_id ON role_user(role_id);

CREATE INDEX idx_employees_attraction_id ON employees(attraction_id);
-- idx_employees_user_id ya está cubierto por la restricción UNIQUE

CREATE INDEX idx_payrolls_employee_id ON payrolls(employee_id);

CREATE INDEX idx_tickets_customer ON tickets(customer);
CREATE INDEX idx_tickets_ticket_type ON tickets(ticket_type);

CREATE INDEX idx_tickets_data_ticket ON tickets_data(ticket);