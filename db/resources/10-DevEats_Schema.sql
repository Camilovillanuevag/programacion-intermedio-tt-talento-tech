
create table usuario (
    cedula varchar(20),
    nombre varchar(70),
    apellido varchar(50),
    apellido2 varchar(50),
    correo varchar(200),
    clave varchar(200),
    telefono varchar(15),
    direccion varchar(200),
    rol varchar(10),
    PRIMARY KEY (cedula)
);

create table restaurante (
  ID_restaurante numeric(3),
  nombre_res varchar(100),
  descripcion_res varchar(500),
  zona varchar(200),
  PRIMARY KEY (ID_restaurante)
);

create table plato (
  ID_plato numeric(3),
  nombre_plato varchar(100),
  precio numeric(9,2),
  ID_restaurante_en_plato numeric(3),
  PRIMARY KEY (ID_plato),
  CONSTRAINT FK_ID_restaurante_en_plato FOREIGN KEY (ID_restaurante_en_plato) REFERENCES restaurante (ID_restaurante)
);

create table pedido (
  ID_pedido numeric(5),
  cantidad numeric(1),
  fecha_pedido date,
  fecha_entrega date,
  ID_usuario_en_pedido varchar(20),
  PRIMARY KEY (ID_pedido),
  CONSTRAINT FK_ID_usuario_en_pedido FOREIGN KEY (ID_usuario_en_pedido) REFERENCES usuario (cedula)
);

create table factura (
  ID_factura numeric(5),
  ID_usuario_en_factura varchar(20),
  fecha_factura date,
  total numeric(10,2),
  PRIMARY KEY (ID_factura),
  CONSTRAINT FK_ID_usuario_en_factura FOREIGN KEY (ID_usuario_en_factura) REFERENCES usuario (cedula)
);

create table detalle_factura (
  ID_factura_en_detalle numeric(5),
  ID_plato_en_detalle numeric(3),
  cantidad numeric(3),
  subtotal numeric(10,2),
  PRIMARY KEY (ID_factura_en_detalle, ID_plato_en_detalle),
  CONSTRAINT FK_ID_factura_en_detalle FOREIGN KEY (ID_factura_en_detalle) REFERENCES factura (ID_factura),
  CONSTRAINT FK_ID_plato_en_detalle FOREIGN KEY (ID_plato_en_detalle) REFERENCES plato(ID_plato)
);

create table entrega (
  ID_entrega numeric(5),
  ID_pedido_en_entrega numeric(5),
  direccion_entrega varchar(200),
  repartidor varchar(70),
  fecha_entrega date,
  estado varchar(20),
  PRIMARY KEY (ID_entrega),
  CONSTRAINT FK_ID_pedido_en_entrega FOREIGN KEY (ID_pedido_en_entrega) REFERENCES pedido(ID_pedido)
);