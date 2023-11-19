INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ( 'Deiner', 'Rafael', 'deralato@gmail.com', '2023-08-17', '');
INSERT INTO clientes ( nombre, apellido, email, create_at, foto) VALUES ('Miguel', 'Savogal', 'miguel@gmail.com', '2023-08-17','');
INSERT INTO clientes ( nombre, apellido, email, create_at, foto) VALUES ('Jesus', 'Rafael', 'deralato@gmail.com', '2023-08-17', '');
INSERT INTO clientes ( nombre, apellido, email, create_at, foto) VALUES ( 'Miguel', 'torres', 'miguel@gmail.com', '2023-08-17', '');
INSERT INTO clientes ( nombre, apellido, email, create_at, foto) VALUES ('Alvaro', 'Gomez', 'deralato@gmail.com', '2023-08-17', '');
INSERT INTO clientes ( nombre, apellido, email, create_at, foto) VALUES ('Antonio', 'Rodriguez', 'miguel@gmail.com', '2023-08-17', '');
INSERT INTO clientes ( nombre, apellido, email, create_at, foto) VALUES ('Fernando', 'Rafael', 'deralato@gmail.com', '2023-08-17', '');
INSERT INTO clientes ( nombre, apellido, email, create_at, foto) VALUES ('Miguel', 'Savogal', 'miguel@gmail.com', '2023-08-17', '');
INSERT INTO clientes ( nombre, apellido, email, create_at, foto) VALUES ('Deiner', 'Rafael', 'deralato@gmail.com', '2023-08-17', '');
INSERT INTO clientes ( nombre, apellido, email, create_at, foto) VALUES ('Miguel', 'Savogal', 'miguel@gmail.com', '2023-08-17', '');
INSERT INTO clientes ( nombre, apellido, email, create_at, foto) VALUES ( 'Deiner', 'Rafael', 'deralato@gmail.com', '2023-08-17', '');
INSERT INTO clientes ( nombre, apellido, email, create_at, foto) VALUES ( 'Miguel', 'Savogal', 'miguel@gmail.com', '2023-08-17', '');
INSERT INTO clientes ( nombre, apellido, email, create_at, foto) VALUES ( 'Deiner', 'Rafael', 'deralato@gmail.com', '2023-08-17', '');
INSERT INTO clientes ( nombre, apellido, email, create_at, foto) VALUES ( 'Miguel', 'Savogal', 'miguel@gmail.com', '2023-08-17', '');
INSERT INTO clientes ( nombre, apellido, email, create_at, foto) VALUES ( 'Deiner', 'Rafael', 'deralato@gmail.com', '2023-08-17', '');
INSERT INTO clientes ( nombre, apellido, email, create_at, foto) VALUES ( 'Miguel', 'Savogal', 'miguel@gmail.com', '2023-08-17', '');
INSERT INTO clientes ( nombre, apellido, email, create_at, foto) VALUES ( 'Deiner', 'Rafael', 'deralato@gmail.com', '2023-08-17', '');
INSERT INTO clientes ( nombre, apellido, email, create_at, foto) VALUES ('Miguel', 'Savogal', 'miguel@gmail.com', '2023-08-17', '');
INSERT INTO clientes ( nombre, apellido, email, create_at, foto) VALUES ('Deiner', 'Rafael', 'deralato@gmail.com', '2023-08-17', '');
INSERT INTO clientes ( nombre, apellido, email, create_at, foto) VALUES ('Miguel', 'Savogal', 'miguel@gmail.com', '2023-08-17', '');
INSERT INTO clientes ( nombre, apellido, email, create_at, foto) VALUES ('Deiner', 'Rafael', 'deralato@gmail.com', '2023-08-17', '');
INSERT INTO clientes ( nombre, apellido, email, create_at, foto) VALUES ( 'Miguel', 'Savogal', 'miguel@gmail.com', '2023-08-17', '');
INSERT INTO clientes ( nombre, apellido, email, create_at, foto) VALUES ( 'Deiner', 'Rafael', 'deralato@gmail.com', '2023-08-17', '');
INSERT INTO clientes ( nombre, apellido, email, create_at, foto) VALUES ( 'Miguel', 'Savogal', 'miguel@gmail.com', '2023-08-17', '');
INSERT INTO clientes ( nombre, apellido, email, create_at, foto) VALUES ('Deiner', 'Rafael', 'deralato@gmail.com', '2023-08-17', '');

INSERT INTO productos ( nombre, precio, create_at) VALUES ('Panasonic Patalla LCD', 259990, NOW());
INSERT INTO productos ( nombre, precio, create_at) VALUES ('Sony camara digital', 259990, NOW());
INSERT INTO productos ( nombre, precio, create_at) VALUES ('Apple iPod', 259990, NOW());
INSERT INTO productos ( nombre, precio, create_at) VALUES ('Sony NoteBook z110', 259990, NOW());
INSERT INTO productos ( nombre, precio, create_at) VALUES ('Hewlett packard Multifuncional F2280', 259990, NOW());
INSERT INTO productos ( nombre, precio, create_at) VALUES ('Bianchi Bicicleta Aro 26', 259990, NOW());
INSERT INTO productos ( nombre, precio, create_at) VALUES ('Mica comoda 5 cajones', 259990, NOW());

/* Creamos algunas facturas */
INSERT INTO facturas (descripcion, observacion, cliente_id, create_at) VALUES('Factura equipos de oficina', null, 1, NOW());
INSERT INTO facturas_item (cantidad, factura_id, producto_id) VALUES(1, 1, 1);
INSERT INTO facturas_item (cantidad, factura_id, producto_id) VALUES(2, 1, 2);
INSERT INTO facturas_item (cantidad, factura_id, producto_id) VALUES(1, 1, 3);
INSERT INTO facturas_item (cantidad, factura_id, producto_id) VALUES(1, 1, 4);

INSERT INTO facturas(descripcion, observacion, cliente_id, create_at) VALUES('Factura Bicicleta', 'Alguna nota importante!', 1, NOW());
INSERT INTO facturas_item (cantidad, factura_id, producto_id) VALUES(3, 2, 6);