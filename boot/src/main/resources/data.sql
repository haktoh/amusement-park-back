 -- Este fichero se ejecuta automáticamente al arrancar la aplicación
-- Fíjate que usamos los nombres de las columnas de la BBDD (snake_case)

-- Insertamos un usuario de prueba para testear la lógica de email duplicado
INSERT INTO users (dni, name, surname, age, email, password, email_verified_at)
VALUES
('12345678A', 'Usuario', 'Existente', 30, 'user@example.com', 'una_clave_dummy_encriptada', NOW());

-- (Opcional) Puedes añadir datos a otras tablas también
INSERT INTO attractions (name, min_height, max_height, length)
VALUES
('Montaña Rusa', 120, 190, 800),
('Rueda de la Fortuna', 80, 200, 100);

INSERT INTO roles (name)
VALUES ('ROLE_ADMIN'), ('ROLE_USER');