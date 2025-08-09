-- =========================
-- USUARIOS
-- =========================
INSERT INTO usuario (cedula, nombre, apellido, apellido2, correo, clave, telefono, direccion, rol)
VALUES
  ('123456', 'Carlos', 'Caicedo', 'Rodriguez', 'carlos.caicedo@example.com', '$2b$12$hash_carlos', '3001234567', 'Calle 10 #5-20', 'cliente'),
  ('123654', 'Pedro', 'Perez', 'Garcia',       'pedro.perez@example.com',   '$2b$12$hash_pedro',  '3009876543', 'Carrera 15 #45-10', 'cliente'),
  ('987654', 'Maria', 'Gonzalez', 'Lopez',     'maria.gonzalez@example.com','$2b$12$hash_maria',  '3012223344', 'Av. Siempre Viva 123', 'cliente'),
  ('456789', 'Ana',   'Martinez', 'Ruiz',      'ana.martinez@example.com',  '$2b$12$hash_ana',    '3025556677', 'Diagonal 30 #12-34', 'cliente');

-- =========================
-- RESTAURANTES
-- =========================
INSERT INTO restaurante (ID_restaurante, nombre_res, descripcion_res, zona)
VALUES
  (101, 'La Pasta Feliz',     'Comida italiana casera', 'Norte'),
  (102, 'Sushi House',        'Sushi y ramen',          'Centro'),
  (103, 'Arepas Doña Ana',    'Platos típicos',         'Sur'),
  (104, 'Burger Bros',        'Hamburguesas artesanales','Oeste');

-- =========================
-- PLATOS
-- =========================
INSERT INTO plato (ID_plato, nombre_plato, precio, ID_restaurante_en_plato)
VALUES
  (201, 'Spaghetti Bolognese',    28000.00, 101),
  (202, 'Lasaña de Carne',        32000.00, 101),
  (203, 'Roll California',        25000.00, 102),
  (204, 'Ramen Clásico',          30000.00, 102),
  (205, 'Arepa Rellena',          10000.00, 103),
  (206, 'Empanadas (6 unidades)', 12000.00, 103),
  (207, 'Hamburguesa Clásica',    18000.00, 104),
  (208, 'Papas Fritas',            8000.00, 104);

-- =========================
-- PEDIDOS
-- Nota: tu tabla tiene 'cantidad' a nivel de pedido; aquí dejamos un valor acorde al pedido.
-- =========================
INSERT INTO pedido (ID_pedido, cantidad, fecha_pedido, fecha_entrega, ID_usuario_en_pedido)
VALUES
  (10001, 2, DATE '2025-07-25', DATE '2025-07-25', '123456'),
  (10002, 3, DATE '2025-07-26', DATE '2025-07-26', '123654'),
  (10003, 1, DATE '2025-07-27', DATE '2025-07-27', '987654'),
  (10004, 2, DATE '2025-07-28', DATE '2025-07-28', '456789');

-- =========================
-- FACTURAS
-- (Los totales corresponden a los detalle_factura de abajo)
-- =========================
INSERT INTO factura (ID_factura, ID_usuario_en_factura, fecha_factura, total)
VALUES
  (40001, '123456', DATE '2025-07-25', 36000.00),
  (40002, '123654', DATE '2025-07-26', 80000.00),
  (40003, '987654', DATE '2025-07-27', 30000.00),
  (40004, '456789', DATE '2025-07-28', 48000.00);

-- =========================
-- DETALLE DE FACTURA
-- (subtotal = cantidad * precio del plato en el momento de facturar)
-- =========================
-- Factura 40001: 201 x1 (28,000) + 208 x1 (8,000) = 36,000
INSERT INTO detalle_factura (ID_factura_en_detalle, ID_plato_en_detalle, cantidad, subtotal)
VALUES
  (40001, 201, 1, 28000.00),
  (40001, 208, 1,  8000.00);

-- Factura 40002: 203 x2 (25,000) + 204 x1 (30,000) = 80,000
INSERT INTO detalle_factura (ID_factura_en_detalle, ID_plato_en_detalle, cantidad, subtotal)
VALUES
  (40002, 203, 2, 50000.00),
  (40002, 204, 1, 30000.00);

-- Factura 40003: 205 x3 (10,000) = 30,000
INSERT INTO detalle_factura (ID_factura_en_detalle, ID_plato_en_detalle, cantidad, subtotal)
VALUES
  (40003, 205, 3, 30000.00);

-- Factura 40004: 207 x2 (18,000) + 206 x1 (12,000) = 48,000
INSERT INTO detalle_factura (ID_factura_en_detalle, ID_plato_en_detalle, cantidad, subtotal)
VALUES
  (40004, 207, 2, 36000.00),
  (40004, 206, 1, 12000.00);

-- =========================
-- ENTREGAS
-- =========================
INSERT INTO entrega (ID_entrega, ID_pedido_en_entrega, direccion_entrega, repartidor, fecha_entrega, estado)
VALUES
  (50001, 10001, 'Calle 10 #5-20',        'Juan Pérez',  DATE '2025-07-25', 'entregado'),
  (50002, 10002, 'Carrera 15 #45-10',     'Luisa Gómez', DATE '2025-07-26', 'entregado'),
  (50003, 10003, 'Av. Siempre Viva 123',  'Carlos Ruiz', DATE '2025-07-27', 'en camino'),
  (50004, 10004, 'Diagonal 30 #12-34',    'Marta Díaz',  DATE '2025-07-28', 'pendiente');
