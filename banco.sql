#Proyecto_2 Implementación de un sistema de base de datos bancario
#Comisión: Mercado Santiago LU:103500 y Gutierrez Gabriel LU:91619

# Creo la Base de Datos
CREATE DATABASE banco;

# selecciono la base de datos sobre la cual voy a hacer modificaciones
USE banco;

#-------------------------------------------------------------------------
# Creación Tablas para las entidades

CREATE TABLE Ciudad(
    cod_postal INT unsigned NOT NULL, 
    nombre VARCHAR(250) NOT NULL,
        
    CONSTRAINT pk_Ciudad PRIMARY KEY (cod_postal)
)ENGINE=InnoDB;

CREATE TABLE Sucursal(
    nro_suc INT unsigned NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(250) NOT NULL,
    direccion VARCHAR(250) NOT NULL,
    telefono VARCHAR(250) NOT NULL,
    horario VARCHAR(250) NOT NULL,
    cod_postal INT unsigned NOT NULL, 

    CONSTRAINT pk_Sucursal PRIMARY KEY (nro_suc),
    CONSTRAINT FK_Sucursal_Ciudad FOREIGN KEY (cod_postal) REFERENCES Ciudad(cod_postal)
)ENGINE=InnoDB;

CREATE TABLE Empleado(
    legajo INT unsigned NOT NULL AUTO_INCREMENT,
    apellido VARCHAR(40) NOT NULL,
    nombre VARCHAR(40) NOT NULL,
    tipo_doc VARCHAR(20) NOT NULL,
    nro_doc INT unsigned NOT NULL,
    direccion VARCHAR(250) NOT NULL,
    telefono VARCHAR(50) NOT NULL,
    cargo VARCHAR(250) NOT NULL,
    password CHAR(32) NOT NULL,
    nro_suc INT unsigned NOT NULL,

    CONSTRAINT pk_Empleado PRIMARY KEY (legajo),
    CONSTRAINT FK_Empleado_Sucursal FOREIGN KEY (nro_suc) REFERENCES Sucursal(nro_suc)
)ENGINE=InnoDB;

CREATE TABLE Cliente(
    nro_cliente INT unsigned NOT NULL AUTO_INCREMENT,
    apellido VARCHAR(40) NOT NULL,
    nombre VARCHAR(40) NOT NULL,
    tipo_doc VARCHAR(20) NOT NULL,
    nro_doc INT unsigned NOT NULL,
    direccion VARCHAR(250) NOT NULL,
    telefono VARCHAR(40) NOT NULL,
    fecha_nac DATE NOT NULL,

    CONSTRAINT pk_Cliente PRIMARY KEY (nro_cliente)
)ENGINE=InnoDB;

CREATE TABLE Plazo_Fijo(
    nro_plazo INT unsigned NOT NULL AUTO_INCREMENT,
    capital DECIMAL(16,2) unsigned NOT NULL,
    fecha_inicio DATE NOT NULL,
    fecha_fin DATE NOT NULL,
    tasa_interes DECIMAL(4,2) unsigned NOT NULL,
    interes DECIMAL(16,2) unsigned NOT NULL,
    nro_suc INT unsigned NOT NULL,

    CONSTRAINT pk_Plazo_Fijo PRIMARY KEY (nro_plazo),
    CONSTRAINT FK_Plazo_Fijo_Sucursal FOREIGN KEY (nro_suc) REFERENCES Sucursal(nro_suc)
)ENGINE=InnoDB;

CREATE TABLE Tasa_Plazo_Fijo(
    periodo TINYINT unsigned NOT NULL,
    monto_inf DECIMAL(16,2) unsigned NOT NULL,
    monto_sup DECIMAL(16,2) unsigned NOT NULL,
    tasa DECIMAL(4,2) unsigned NOT NULL,

    CONSTRAINT pk_Tasa_Plazo_Fijo PRIMARY KEY (periodo, monto_inf, monto_sup)
)ENGINE=InnoDB;

CREATE TABLE Plazo_Cliente(
    nro_plazo INT unsigned NOT NULL,
    nro_cliente INT unsigned NOT NULL,

    CONSTRAINT pk_Plazo_Cliente PRIMARY KEY (nro_plazo, nro_cliente),
    CONSTRAINT FK_Plazo_Cliente_Plazo_Fijo FOREIGN KEY (nro_plazo) REFERENCES Plazo_Fijo (nro_plazo),
    CONSTRAINT FK_Plazo_Cliente_Cliente FOREIGN KEY (nro_cliente) REFERENCES Cliente (nro_cliente)
)ENGINE=InnoDB;

CREATE TABLE Prestamo(
    nro_prestamo INT unsigned NOT NULL AUTO_INCREMENT,
    fecha DATE NOT NULL,
    cant_meses TINYINT unsigned NOT NULL,
    monto DECIMAL(10,2) unsigned NOT NULL,
    tasa_interes DECIMAL(4,2) unsigned NOT NULL,
    interes DECIMAL(9,2) unsigned NOT NULL,
    valor_cuota DECIMAL(9,2) unsigned NOT NULL,
    legajo INT unsigned NOT NULL,
    nro_cliente INT unsigned NOT NULL,

    CONSTRAINT pk_Prestamo PRIMARY KEY (nro_prestamo),
    CONSTRAINT FK_Prestamo_Empleado FOREIGN KEY (legajo) REFERENCES Empleado (legajo),
    CONSTRAINT FK_Prestamo_Cliente FOREIGN KEY (nro_cliente) REFERENCES Cliente (nro_cliente)

)ENGINE=InnoDB;

CREATE TABLE Pago(
    nro_prestamo INT unsigned NOT NULL,
    nro_pago INT unsigned NOT NULL,
    fecha_venc DATE NOT NULL,
    fecha_pago DATE,

    CONSTRAINT pk_Pago PRIMARY KEY (nro_prestamo,nro_pago),
    CONSTRAINT FK_Pago_Prestamo FOREIGN KEY (nro_prestamo) REFERENCES Prestamo (nro_prestamo)

)ENGINE=InnoDB;

CREATE TABLE Tasa_Prestamo(
    periodo TINYINT unsigned NOT NULL,
    monto_inf DECIMAL(10,2) unsigned NOT NULL,
    monto_sup DECIMAL(10,2) unsigned NOT NULL,
    tasa DECIMAL(4,2) unsigned NOT NULL,

    CONSTRAINT pk_Tasa_Prestamo PRIMARY KEY (periodo, monto_inf, monto_sup)

)ENGINE=InnoDB;

CREATE TABLE Caja_Ahorro(
    nro_ca INT unsigned NOT NULL AUTO_INCREMENT,
    CBU BIGINT unsigned NOT NULL,
    saldo DECIMAL(16,2) unsigned NOT NULL,

    CONSTRAINT pk_Caja_Ahorro PRIMARY KEY (nro_ca)

)ENGINE=InnoDB;

CREATE TABLE Cliente_CA(
    nro_cliente INT unsigned NOT NULL,
    nro_ca INT unsigned NOT NULL,

    CONSTRAINT pk_Cliente_CA PRIMARY KEY (nro_cliente, nro_ca),
    CONSTRAINT FK_Caja_Ahorro_Cliente FOREIGN KEY (nro_cliente) REFERENCES Cliente(nro_cliente),
    CONSTRAINT FK_Cliente_CA_Cliente FOREIGN KEY (nro_ca) REFERENCES Caja_Ahorro(nro_ca)

)ENGINE=InnoDB;

CREATE TABLE Tarjeta(
    nro_tarjeta BIGINT unsigned NOT NULL AUTO_INCREMENT,
    PIN CHAR(32) NOT NULL,
    CVT CHAR(32) NOT NULL,
    fecha_venc DATE NOT NULL,
    nro_cliente INT unsigned NOT NULL,
    nro_ca INT unsigned NOT NULL,

    CONSTRAINT pk_Tarjeta PRIMARY KEY (nro_tarjeta),
    CONSTRAINT FK_Tarjeta FOREIGN KEY (nro_cliente, nro_ca) REFERENCES Cliente_CA(nro_cliente, nro_ca)

)ENGINE=InnoDB;

CREATE TABLE Caja(
    cod_caja INT unsigned NOT NULL AUTO_INCREMENT,

    CONSTRAINT pk_Caja PRIMARY KEY (cod_caja)

)ENGINE=InnoDB;

CREATE TABLE Ventanilla(
    cod_caja INT unsigned NOT NULL,
    nro_suc INT unsigned NOT NULL,

    CONSTRAINT pk_Ventanilla PRIMARY KEY (cod_caja),
    CONSTRAINT FK_Ventanilla_Caja FOREIGN KEY (cod_caja) REFERENCES Caja(cod_caja),
    CONSTRAINT FK_Ventanilla_Sucursal FOREIGN KEY (nro_suc) REFERENCES Sucursal(nro_suc)

)ENGINE=InnoDB;

CREATE TABLE ATM(
    cod_caja INT unsigned NOT NULL,
    cod_postal INT unsigned NOT NULL, 
    direccion VARCHAR(250) NOT NULL,

    CONSTRAINT pk_ATM PRIMARY KEY (cod_caja),
    CONSTRAINT FK_ATM_Caja FOREIGN KEY (cod_caja) REFERENCES Caja(cod_caja),
    CONSTRAINT FK_ATM_Ciudad FOREIGN KEY (cod_postal) REFERENCES Ciudad(cod_postal)
)ENGINE=InnoDB;

CREATE TABLE Transaccion(
    nro_trans INT unsigned NOT NULL AUTO_INCREMENT,
    fecha DATE NOT NULL,
    hora TIME NOT NULL,
    monto DECIMAL(16,2) unsigned NOT NULL,

    CONSTRAINT pk_Transaccion PRIMARY KEY (nro_trans)
)ENGINE=InnoDB;

CREATE TABLE Debito(
    nro_trans INT unsigned NOT NULL,
    descripcion TEXT,
    nro_cliente INT unsigned NOT NULL,
    nro_ca INT unsigned NOT NULL,

    CONSTRAINT pk_Debito PRIMARY KEY (nro_trans),
    CONSTRAINT FK_Debito_Transaccion FOREIGN KEY (nro_trans) REFERENCES Transaccion(nro_trans),
    CONSTRAINT FK_Debito FOREIGN KEY (nro_cliente, nro_ca) REFERENCES Cliente_CA(nro_cliente, nro_ca)
)ENGINE=InnoDB;

CREATE TABLE Transaccion_por_Caja(
    nro_trans INT unsigned NOT NULL,
    cod_caja INT unsigned NOT NULL,

    CONSTRAINT pk_Transaccion_por_Caja PRIMARY KEY (nro_trans),
    CONSTRAINT FK_Transaccion_por_Caja_Transaccion FOREIGN KEY (nro_trans) REFERENCES Transaccion(nro_trans),
    CONSTRAINT FK_Transaccion_por_Caja_Caja FOREIGN KEY (cod_caja) REFERENCES Caja(cod_caja)
)ENGINE=InnoDB;

CREATE TABLE Deposito(
    nro_trans INT unsigned NOT NULL,
    nro_ca INT unsigned NOT NULL,

    CONSTRAINT pk_Deposito PRIMARY KEY (nro_trans),
    CONSTRAINT FK_Deposito_Transaccion_por_Caja FOREIGN KEY (nro_trans) REFERENCES Transaccion_por_Caja(nro_trans),
    CONSTRAINT FK_Deposito_Caja_Ahorro FOREIGN KEY (nro_ca) REFERENCES Caja_Ahorro(nro_ca)
)ENGINE=InnoDB;

CREATE TABLE Extraccion(
    nro_trans INT unsigned NOT NULL,
    nro_cliente INT unsigned NOT NULL,
    nro_ca INT unsigned NOT NULL,

    CONSTRAINT pk_Extraccion PRIMARY KEY (nro_trans),
    CONSTRAINT FK_Extraccion_Transaccion_por_Caja FOREIGN KEY (nro_trans) REFERENCES Transaccion_por_Caja(nro_trans),
    CONSTRAINT FK_Extraccion_Cliente_CA FOREIGN KEY (nro_cliente, nro_ca) REFERENCES Cliente_CA(nro_cliente, nro_ca)

)ENGINE=InnoDB;

CREATE TABLE Transferencia(
    nro_trans INT unsigned NOT NULL,
    nro_cliente INT unsigned NOT NULL AUTO_INCREMENT,
    origen INT unsigned NOT NULL,
    destino INT unsigned NOT NULL,

    CONSTRAINT pk_Transferencia PRIMARY KEY (nro_trans),
    CONSTRAINT FK_Transferencia_Transaccion_por_Caja FOREIGN KEY (nro_trans) REFERENCES Transaccion_por_Caja(nro_trans),
    CONSTRAINT FK_Transferencia_Cliente_CA FOREIGN KEY (nro_cliente, origen) REFERENCES Cliente_CA(nro_cliente, nro_ca),
    CONSTRAINT FK_Transferencia_Caja_Ahorro FOREIGN KEY (destino) REFERENCES Caja_Ahorro(nro_ca)
)ENGINE=InnoDB;

#-------------------------------------------------------------------------
# Creación de la vista

-- CREATE VIEW vista_debito(nro_ca, saldo, nro_trans, fecha, hora, tipo, monto, destino, cod_caja, nro_cliente, tipo_doc, nro_doc, nombre, apellido)
CREATE VIEW vista_debito(nro_ca, saldo, nro_trans, fecha, hora, tipo, monto, destino, cod_caja, nro_cliente, tipo_doc, nro_doc, nombre, apellido) AS
SELECT nro_ca, saldo, nro_trans, fecha, hora, 'Debito' AS tipo, monto, NULL AS destino, NULL AS cod_caja, Cliente.nro_cliente, Cliente.tipo_doc, Cliente.nro_doc, Cliente.nombre, Cliente.apellido
FROM Transaccion NATURAL JOIN Debito NATURAL JOIN Cliente_CA NATURAL JOIN Caja_Ahorro NATURAL JOIN Cliente
WHERE 1;

-- CREATE VIEW vista_extraccion(nro_ca, saldo, nro_trans, fecha, hora, tipo, monto, destino, cod_caja, nro_cliente, tipo_doc, nro_doc, nombre, apellido)
CREATE VIEW vista_extraccion(nro_ca, saldo, nro_trans, fecha, hora, tipo, monto, destino, cod_caja, nro_cliente, tipo_doc, nro_doc, nombre, apellido) AS
SELECT nro_ca, saldo, nro_trans, fecha, hora, 'Extraccion' AS tipo, monto, NULL AS destino, cod_caja, Cliente.nro_cliente, Cliente.tipo_doc, Cliente.nro_doc, Cliente.nombre, Cliente.apellido
FROM Transaccion NATURAL JOIN Transaccion_por_Caja NATURAL JOIN Extraccion NATURAL JOIN Cliente_CA NATURAL JOIN Caja_Ahorro NATURAL JOIN Cliente
WHERE 1;

-- CREATE VIEW vista_transferencia(nro_ca, saldo, nro_trans, fecha, hora, tipo, monto, destino, cod_caja, nro_cliente, tipo_doc, nro_doc, nombre, apellido)
CREATE VIEW vista_transferencia(nro_ca, saldo, nro_trans, fecha, hora, tipo, monto, destino, cod_caja, nro_cliente, tipo_doc, nro_doc, nombre, apellido) AS
SELECT Caja_Ahorro.nro_ca, saldo, nro_trans, fecha, hora, 'Transferencia' AS tipo, monto, destino, cod_caja, Transferencia.nro_cliente, Cliente.tipo_doc, Cliente.nro_doc, Cliente.nombre, Cliente.apellido 
FROM Transaccion NATURAL JOIN Transaccion_por_Caja NATURAL JOIN Transferencia  NATURAL JOIN Cliente JOIN Cliente_CA ON Transferencia.nro_cliente=Cliente_CA.nro_cliente and Transferencia.origen=Cliente_CA.nro_ca JOIN Caja_Ahorro ON Transferencia.origen=Caja_Ahorro.nro_ca;

-- CREATE VIEW vista_deposito(nro_ca, saldo, nro_trans, fecha, hora, tipo, monto, destino, cod_caja, nro_cliente, tipo_doc, nro_doc, nombre, apellido)
CREATE VIEW vista_deposito(nro_ca, saldo, nro_trans, fecha, hora, tipo, monto, destino, cod_caja, nro_cliente, tipo_doc, nro_doc, nombre, apellido) AS
SELECT nro_ca, saldo, nro_trans, fecha, hora, 'Deposito' AS tipo, monto, NULL AS destino, cod_caja, NULL AS nro_cliente, NULL AS tipo_doc, NULL AS nro_doc, NULL AS nombre, NULL AS apellido
FROM Transaccion NATURAL JOIN Transaccion_por_Caja NATURAL JOIN Deposito NATURAL JOIN Cliente_CA NATURAL JOIN Caja_Ahorro NATURAL JOIN Cliente;

-- CREATE VIEW trans_cajas_ahorro(nro_ca, saldo, nro_trans, fecha, hora, tipo, monto, destino, cod_caja, nro_cliente, tipo_doc, nro_doc, nombre, apellido)
CREATE VIEW trans_cajas_ahorro(nro_ca, saldo, nro_trans, fecha, hora, tipo, monto, destino, cod_caja, nro_cliente, tipo_doc, nro_doc, nombre, apellido) AS
(SELECT * FROM vista_debito) UNION (SELECT * FROM vista_deposito) UNION (SELECT * FROM vista_extraccion) UNION (SELECT * FROM vista_transferencia);


delimiter !
#-------------------------------------------------------------------------------
# Transacción para transferir un monto de la cuentaA a la cuentaB

CREATE PROCEDURE transferir(IN monto DECIMAL(16,2), IN cuentaA INT, IN cuentaB INT,IN cod_caja INT, IN nro_cliente INT)
BEGIN
	DECLARE saldo_actual_cuentaA DECIMAL(16,2);
    # Declaro variables locales para recuperar los errores 
	 DECLARE codigo_SQL  CHAR(5) DEFAULT '00000';	 
	 DECLARE codigo_MYSQL INT DEFAULT 0;
	 DECLARE mensaje_error TEXT;
	DECLARE EXIT HANDLER FOR SQLEXCEPTION
		BEGIN 
			GET DIAGNOSTICS CONDITION 1  codigo_MYSQL= MYSQL_ERRNO,  
		                             codigo_SQL= RETURNED_SQLSTATE, 
									 mensaje_error= MESSAGE_TEXT;
	    SELECT 'SQLEXCEPTION!, transacción abortada' AS resultado, 
		        codigo_MySQL, codigo_SQL,  mensaje_error;
			ROLLBACK;
		END;
	START TRANSACTION;
		IF EXISTS (SELECT * FROM Caja_Ahorro WHERE nro_ca=cuentaA) AND
			EXISTS (SELECT * FROM Caja_Ahorro WHERE nro_ca=cuentaB) THEN
			SELECT saldo INTO saldo_actual_cuentaA
			FROM Caja_Ahorro WHERE nro_ca = cuentaA FOR UPDATE;
				IF saldo_actual_cuentaA >= monto THEN
					UPDATE Caja_Ahorro SET saldo = saldo - monto WHERE nro_ca=cuentaA;
					UPDATE Caja_Ahorro SET saldo = saldo + monto WHERE nro_ca=cuentaB;
					INSERT INTO Transaccion(fecha,hora,monto) VALUES (curdate(), curtime(), monto);
					INSERT INTO Transaccion_por_caja VALUES (LAST_INSERT_ID(), cod_caja);
					INSERT INTO Transferencia VALUES (LAST_INSERT_ID(), nro_cliente, cuentaA, cuentaB);
					INSERT INTO Deposito VALUES (LAST_INSERT_ID(),cuentaB);
					SELECT 'La transferencia se realizo con exito' AS resultado;
				ELSE
					SELECT 'Saldo insuficiente para realizar la transferencia' AS resultado;
				END IF;
		ELSE
			SELECT 'Error: cuenta inexistente' AS resultado;
		END IF;
	COMMIT;
END; !

#-------------------------------------------------------------------------------
# Transacción para extraer un monto de la cuentaA 

CREATE PROCEDURE extraccion(IN monto DECIMAL(16,2), IN cuentaA INT, IN cod_caja INT, IN nro_cliente INT)
BEGIN
	DECLARE saldo_actual_cuentaA DECIMAL(16,2);
    # Declaro variables locales para recuperar los errores 
	 DECLARE codigo_SQL  CHAR(5) DEFAULT '00000';	 
	 DECLARE codigo_MYSQL INT DEFAULT 0;
	 DECLARE mensaje_error TEXT;
	DECLARE EXIT HANDLER FOR SQLEXCEPTION
		BEGIN 
			GET DIAGNOSTICS CONDITION 1  codigo_MYSQL= MYSQL_ERRNO,  
		                             codigo_SQL= RETURNED_SQLSTATE, 
									 mensaje_error= MESSAGE_TEXT;
	    SELECT 'SQLEXCEPTION!, transacción abortada' AS resultado, 
		        codigo_MySQL, codigo_SQL,  mensaje_error;
			ROLLBACK;
		END;
	START TRANSACTION;
		IF EXISTS (SELECT * FROM Caja_Ahorro WHERE nro_ca=cuentaA) THEN
			SELECT saldo INTO saldo_actual_cuentaA
			FROM Caja_Ahorro WHERE nro_ca = cuentaA FOR UPDATE;
				IF saldo_actual_cuentaA >= monto THEN
					UPDATE Caja_Ahorro SET saldo = saldo - monto WHERE nro_ca=cuentaA;
					INSERT INTO Transaccion(fecha,hora,monto) VALUES (curdate(), curtime(), monto);
					INSERT INTO Transaccion_por_caja VALUES (LAST_INSERT_ID(), cod_caja);
					INSERT INTO Extraccion VALUES (LAST_INSERT_ID(), nro_cliente, cuentaA);
					SELECT 'La transferencia se realizo con exito' AS resultado;
				ELSE
					SELECT 'Saldo insuficiente para realizar la extraccion' AS resultado;
				END IF;
		ELSE
			SELECT 'Error: cuenta inexistente' AS resultado;
		END IF;
	COMMIT;
END; !

#..............................................................................
# Trigger para cargar automaticamente todos los pagos asociados a un prestamo

CREATE TRIGGER prestamo_insert
AFTER INSERT ON prestamo
FOR EACH ROW
BEGIN
	DECLARE cont INT;
	DECLARE fecha DATE;
	set cont=NEW.cant_meses;
	WHILE cont>0 DO
	SELECT date_add(curdate(),interval cont month) INTO fecha;
    INSERT INTO pago VALUES(NEW.nro_prestamo, cont, fecha, NULL);
	SET cont=cont-1;
	END WHILE;
END; !extraccion

delimiter ;
#---------------------------------------------------------------------------------------------

# Creación de usuarios y otorgamiento de privilegios

-- Usuario admin  
   
CREATE USER IF NOT EXISTS 'admin'@'localhost' IDENTIFIED BY 'admin';

GRANT ALL PRIVILEGES ON banco.* TO 'admin'@'localhost';
GRANT GRANT OPTION ON banco.* TO 'admin'@'localhost';

-- Usuario empleado
    
CREATE USER IF NOT EXISTS 'empleado'@'%' IDENTIFIED BY 'empleado'; 

GRANT SELECT ON banco.Empleado TO 'empleado'@'%';    
GRANT SELECT ON banco.Sucursal TO 'empleado'@'%';
GRANT SELECT ON banco.Tasa_plazo_fijo TO 'empleado'@'%';
GRANT SELECT ON banco.Tasa_prestamo TO 'empleado'@'%';
GRANT SELECT ON banco.Prestamo TO 'empleado'@'%';
GRANT SELECT ON banco.Plazo_fijo TO 'empleado'@'%';
GRANT SELECT ON banco.Plazo_cliente TO 'empleado'@'%';
GRANT SELECT ON banco.Caja_ahorro TO 'empleado'@'%';
GRANT SELECT ON banco.Tarjeta TO 'empleado'@'%';
GRANT SELECT ON banco.Cliente_ca TO 'empleado'@'%';
GRANT SELECT ON banco.Cliente TO 'empleado'@'%';
GRANT SELECT ON banco.Pago TO 'empleado'@'%';

GRANT INSERT ON banco.Prestamo TO 'empleado'@'%';
GRANT INSERT ON banco.Plazo_fijo TO 'empleado'@'%';
GRANT INSERT ON banco.Plazo_cliente TO 'empleado'@'%';
GRANT INSERT ON banco.Caja_ahorro TO 'empleado'@'%';
GRANT INSERT ON banco.Tarjeta TO 'empleado'@'%';
GRANT INSERT ON banco.Cliente_ca TO 'empleado'@'%';
GRANT INSERT ON banco.Cliente TO 'empleado'@'%';
GRANT INSERT ON banco.Pago TO 'empleado'@'%';

GRANT UPDATE ON banco.Cliente_ca TO 'empleado'@'%';
GRANT UPDATE ON banco.Cliente TO 'empleado'@'%';
GRANT UPDATE ON banco.Pago TO 'empleado'@'%';

-- Usuario atm

CREATE USER IF NOT EXISTS 'atm'@'%' IDENTIFIED BY 'atm';

GRANT EXECUTE ON banco.* TO atm;
	
	GRANT SELECT ON banco.trans_cajas_ahorro TO atm@'%';
	
	GRANT SELECT ON banco.Tarjeta TO atm@'%';
	GRANT SELECT ON banco.Caja_Ahorro TO atm@'%';
	
	GRANT UPDATE ON banco.Tarjeta TO atm@'%';
	GRANT UPDATE ON banco.Caja_Ahorro TO atm@'%';
	
	GRANT INSERT ON banco.Transaccion TO atm@'%';
	GRANT INSERT ON banco.Transaccion_por_caja TO atm@'%';
	GRANT INSERT ON banco.Deposito TO atm@'%';
	GRANT INSERT ON banco.Extraccion TO atm@'%';