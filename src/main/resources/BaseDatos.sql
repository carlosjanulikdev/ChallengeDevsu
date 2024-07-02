CREATE SCHEMA `devsu`;

CREATE TABLE `devsu`.`persona` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `genero` varchar(100) DEFAULT NULL,
  `edad` int NULL,
  `identificacion` varchar(100) DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `telefono` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `devsu`.`cliente` (
  `id` int NOT NULL AUTO_INCREMENT,
  `contrasenia` varchar(32) DEFAULT NULL,
  `estado` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`id`) REFERENCES persona(`id`)
);

CREATE TABLE `devsu`.`tipo_cuenta` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `devsu`.`cuenta` (
  `id` int NOT NULL AUTO_INCREMENT,
  `numero` varchar(32) DEFAULT NULL,
  `tipo_cuenta_id` INT NOT NULL,
  `saldo_inicial` double DEFAULT NULL,
  `estado` boolean DEFAULT True,
  `edad` int NULL,
  `cliente_id` int,
  PRIMARY KEY (`id`),
  FOREIGN KEY (tipo_cuenta_id) REFERENCES tipo_cuenta(id),
  FOREIGN KEY (cliente_id) REFERENCES cliente(id)
);

CREATE TABLE `devsu`.`tipo_movimiento` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `devsu`.`movimiento` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fecha` timestamp,
  `tipo_movimiento_id` INT NOT NULL,
  `valor` double DEFAULT NULL,
  `saldo` double DEFAULT NULL,
  `cuenta_id` int,
  PRIMARY KEY (`id`),
  FOREIGN KEY (tipo_movimiento_id) REFERENCES tipo_movimiento(id),
  FOREIGN KEY (cuenta_id) REFERENCES cuenta(id)
);


--INSERTS
INSERT INTO devsu.tipo_cuenta (descripcion) VALUES ('Ahorros');
INSERT INTO devsu.tipo_cuenta (descripcion) VALUES ('Corriente');

INSERT INTO devsu.tipo_movimiento (descripcion) VALUES ('Deposito');
INSERT INTO devsu.tipo_movimiento (descripcion) VALUES ('Retiro');

