#Alta de Ciudad
#Formato de inserción: (cod_postal, nombre)
INSERT INTO Ciudad VALUE (8000, 'Bahía Blanca');
INSERT INTO Ciudad VALUE (9000, 'Comodoro Rivadavia');
INSERT INTO Ciudad VALUE (8500, 'Viedma');
INSERT INTO Ciudad VALUE (5400, 'Rawson');
INSERT INTO Ciudad VALUE (8300, 'Neuquen');
INSERT INTO Ciudad VALUE (1000,'Buenos Aires');
INSERT INTO Ciudad VALUE (7600,'Mar del Plata');

#Alta de Sucursal
#Formato de inserción: (nro_suc, nombre, direccion, telefono, horario, cod_postal)
INSERT INTO Sucursal VALUE (1, 'Banco Patagonia', 'Chiclana 326', 02914500337, 'Lunes a viernes de 10 a 15hs', 8000); 
INSERT INTO Sucursal VALUE (2, 'Banco Patagonia', 'Av. Rivadavia 202', 02974472061, 'Lunes a viernes de 8 a 13hs', 9000); 
INSERT INTO Sucursal VALUE (3, 'Banco Patagonia', 'Sarmiento 373', 02920441500, 'Lunes a viernes de 8 a 13hs', 8500); 
INSERT INTO Sucursal VALUE (4, 'Banco Patagonia', 'Sarmiento 780', 02804482743, 'Lunes a viernes de 8 a 13hs', 5400); 
INSERT INTO Sucursal VALUE (5, 'Banco Patagonia', 'Carlos H.Rodríguez 160', 02994470378, 'Lunes a viernes de 8 a 13hs', 8300);
INSERT INTO Sucursal VALUE (6, 'Banco Patagonia', 'Av. Pedro Luro 3101', 02234934341, 'Lunes a viernes de 10 a 15hs', 7600);
INSERT INTO Sucursal VALUE (7, 'Banco Patagonia', 'Av. Eva Perón 4902', 01146825229, 'Lunes a viernes de 10 a 15hs', 1000);


#Alta de Cliente
#Formato de inserción: (nro_cliente, apellido, nombre, tipo_doc, nro_doc, direccion, telefono, fecha_nac)
INSERT INTO Cliente VALUE (1, 'Gutierrez', 'Gabriel', 'DNI','32456789', '12 de Octubre 833', '15638475', '1989-08-15');
INSERT INTO Cliente VALUE (2, 'Mercado', 'Santiago', 'DNI','37665554', 'Zapiola 180', '15847569', '1994-01-06');
INSERT INTO Cliente VALUE (3, 'Hernandez', 'Rodrigo', 'DNI','24123746', 'Saavedra 729', '155048722', '1969-02-09');
INSERT INTO Cliente VALUE (4, 'Carrasco', 'Ailen', 'DNI', '24569789', 'Alvear 179', '15669932', '1963-05-21');
INSERT INTO Cliente VALUE (5, 'Tejada', 'Mauro', 'DNI', '38679854', 'Uruguay 135', '15454577', '2000-12-16');
INSERT INTO Cliente VALUE (6, 'Grande','Julieta','DNI','25488754','Estomba 254','0291-4540026','1980-05-06');
INSERT INTO Cliente VALUE (7, 'Ferraro','Javier','DNI','24122365','Arenales 2254','0291-4540027','1980-05-07');

#Alta de Empleado
#Formato de inserción: (legajo, apellido, nombre, tipo_doc, nro_doc, direccion, telefono, cargo, password, nro_suc)
#Alta Empleado -------- Sucursal 1 Bahia Blanca
INSERT INTO Empleado VALUE (100, 'Arranz', 'Agustin', 'DNI', '37456852', 'Rodriguez 450', '156384756', 'caja', md5('caja'),1);
INSERT INTO Empleado VALUE (200, 'Frak', 'Santiago', 'DNI', '35693233', 'Zapiola 1150', '154475697', 'caja', md5('caja'),1);
INSERT INTO Empleado VALUE (300, 'Hernandez', 'Lautaro', 'DNI','29865432', 'Darregueria 229', '155048722', 'recepcion', md5('recepcion'),1);
INSERT INTO Empleado VALUE (400, 'Feliu', 'Anabel', 'DNI', '31456855', 'Colombia 412', '156699332', 'atencion al cliente', md5('atecliente'),1);
INSERT INTO Empleado VALUE (500, 'Tejerin', 'Maximo', 'DNI', '36221499', 'Caronti 325', '154545757', 'prestamos', md5('prestamos'),1);
#Alta Empleado -------- Sucursal 2 Comodoro Rivadavia
INSERT INTO Empleado VALUE (600, 'Sly', 'Agustin', 'DNI', '37456455', 'Av alem 450', '156387855', 'caja', md5('caja'),2);
INSERT INTO Empleado VALUE (700, 'Amigo', 'Leandro', 'DNI', '35456774', 'Zapiola 780', '154474559', 'caja', md5('caja'),2);
INSERT INTO Empleado VALUE (800, 'Hernandez', 'Soledad', 'DNI','29236598', 'Av Colon 229', '155789231', 'recepcion', md5('recepcion'),2);
INSERT INTO Empleado VALUE (900, 'Aldana', 'Manuel', 'DNI', '31789552', 'Uruguay 123', '156699329', 'atencion al cliente', md5('atecliente'),2);
INSERT INTO Empleado VALUE (1000, 'Gonzales', 'Hernan', 'DNI', '36221789', 'Caronti 754', '154456123', 'prestamos', md5('prestamos'),2);
#Alta Empleado -------- Sucursal 3 Viedma
INSERT INTO Empleado VALUE (1100, 'Arranz', 'Micaela', 'DNI', '37563232', 'Urquiza 320', '156445211', 'caja', md5('caja'),3);
INSERT INTO Empleado VALUE (1200, 'Alario', 'Manuel', 'DNI', '35456554', 'San juan 452', '155412221', 'caja', md5('caja'),3);
INSERT INTO Empleado VALUE (1300, 'Rojo', 'Mercedes', 'DNI','29865432', 'Moreno 214', '155048447', 'recepcion', md5('recepcion'),3);
INSERT INTO Empleado VALUE (1400, 'Mieres', 'Brian', 'DNI', '31789655', 'Floresta 55', '154211578', 'atencion al cliente', md5('atecliente'),3);
INSERT INTO Empleado VALUE (1500, 'De Ciancio', 'Rodrigo', 'DNI', '36896665', 'Casanova 325', '154223366', 'prestamos', md5('prestamos'),3);
#Alta Empleado -------- Sucursal 4 Rawson
INSERT INTO Empleado VALUE (1600, 'Ferro', 'Monica', 'DNI', '37445665', 'Sarmiento 210', '156332174', 'caja', md5('caja'),4);
INSERT INTO Empleado VALUE (1700, 'Dorazio', 'Gonzalo', 'DNI', '35698887', 'Av Rivadavia 350', '154665558', 'caja', md5('caja'),4);
INSERT INTO Empleado VALUE (1800, 'Fracapane', 'Florencia', 'DNI','29865432', 'Viamonte 785', '155321965', 'recepcion', md5('recepcion'),4);
INSERT INTO Empleado VALUE (1900, 'Garcia', 'Tomas', 'DNI', '31456855', '25 de Mayo 432', '156664112', 'atencion al cliente', md5('atecliente'),4);
INSERT INTO Empleado VALUE (2000, 'Osimani', 'Federico', 'DNI', '36123854', 'Figueroa Alcorta 1477', '154455554', 'prestamos', md5('prestamos'),4);
#Alta Empleado -------- Sucursal 5 Neuquen
INSERT INTO Empleado VALUE (2100, 'Lagarde', 'Geronimo', 'DNI', '37521365', 'Patagonia 123', '156332224', 'caja', md5('caja'),5);
INSERT INTO Empleado VALUE (2200, 'Pantaleone', 'Javier', 'DNI', '35788997', 'Alsina 455', '154203801', 'caja', md5('caja'),5);
INSERT INTO Empleado VALUE (2300, 'Carrizo', 'Javier', 'DNI','29023001', 'España 458', '154003808', 'recepcion', md5('recepcion'),5);
INSERT INTO Empleado VALUE (2400, 'Figueroa', 'Santiago', 'DNI', '31110230', 'Francia 120', '154780331', 'atencion al cliente', md5('atecliente'),5);
INSERT INTO Empleado VALUE (2500, 'Tejada', 'Federico', 'DNI', '36058741', 'Santa Cruz 480', '154440398', 'prestamos', md5('prestamos'),5);

#Alta de Prestamo
#Formato de inserción: (nro_prestamo. fecha, cant_meses, monto, tasa_interes, interes, valor_cuota, legajo, nro_cliente)
INSERT INTO Prestamo VALUE (10000000,'2018-10-04',6,8000.00,20.00,800.00,1466.66,500,1);
INSERT INTO Prestamo VALUE (20000000,'2018-10-04',12,20000.00,25.50,5100.00,2091.66,800,4);
INSERT INTO Prestamo VALUE (30000000,'2018-10-07',24,23000.00,27.00,12420.00,1475.83,100,3);
INSERT INTO Prestamo VALUE (40000000,'2018-10-07',24,17000.00,27.00,9180.00,1090.83,100,3);
INSERT INTO Prestamo VALUE (50000000,'2018-10-07',12,9000.00,21.50,1935.00,911.25,100,5);
INSERT INTO Prestamo VALUE (60000000,'2018-10-07',12,8500.00,21.50,1827.50,860.63,200,2);
INSERT INTO Prestamo VALUE (70000000,'2018-10-07',24,17000.00,27.00,9180.00,1090.83,100,3);

#Alta de Pago
#Formato de inserción: (nro_prestamo, nro_pago, fecha_venc, fecha_pago)
INSERT INTO Pago VALUE  (10000000,1,'2018-11-04','2018-10-04');
INSERT INTO Pago VALUE	(10000000,2,'2018-12-04','2018-10-04');
INSERT INTO Pago VALUE	(10000000,3,'2019-01-04','2018-10-04');
INSERT INTO Pago VALUE	(10000000,4,'2019-02-04','2018-10-07');
INSERT INTO Pago VALUE	(10000000,5,'2019-03-04','2018-10-06');
INSERT INTO Pago VALUE	(10000000,6,'2019-04-04','2018-10-07');
INSERT INTO Pago VALUE	(20000000,1,'2018-11-04','2018-10-04');
INSERT INTO Pago VALUE	(20000000,2,'2018-12-04','2018-10-04');
INSERT INTO Pago VALUE	(20000000,3,'2019-01-04','2018-10-04');
INSERT INTO Pago VALUE	(20000000,4,'2019-02-04','2018-10-04');
INSERT INTO Pago VALUE	(20000000,5,'2019-03-04','2018-10-04');
INSERT INTO Pago VALUE	(20000000,6,'2019-04-04',NULL);
INSERT INTO Pago VALUE	(20000000,7,'2019-05-04',NULL);
INSERT INTO Pago VALUE	(20000000,8,'2019-06-04',NULL);
INSERT INTO Pago VALUE	(20000000,9,'2019-07-04',NULL);
INSERT INTO Pago VALUE	(20000000,10,'2019-08-04',NULL);
INSERT INTO Pago VALUE	(20000000,11,'2019-09-04',NULL);
INSERT INTO Pago VALUE	(20000000,12,'2019-10-04',NULL);
INSERT INTO Pago VALUE	(40000000,1,'2018-11-07','2018-10-07');
INSERT INTO Pago VALUE	(50000000,1,'2018-06-01',NULL);
INSERT INTO Pago VALUE	(50000000,2,'2018-07-01',NULL);
INSERT INTO Pago VALUE	(50000000,3,'2018-08-01',NULL);
INSERT INTO Pago VALUE	(50000000,4,'2018-09-01',NULL);
INSERT INTO Pago VALUE	(50000000,5,'2018-10-01',NULL);
INSERT INTO Pago VALUE	(50000000,6,'2019-04-07',NULL);
INSERT INTO Pago VALUE	(50000000,7,'2019-05-07',NULL);
INSERT INTO Pago VALUE	(50000000,8,'2019-06-07',NULL);
INSERT INTO Pago VALUE	(50000000,9,'2019-07-07',NULL);
INSERT INTO Pago VALUE	(50000000,10,'2019-08-07',NULL);
INSERT INTO Pago VALUE	(50000000,11,'2019-09-07',NULL);
INSERT INTO Pago VALUE	(60000000,1,'2018-11-07','2018-10-07');
INSERT INTO Pago VALUE	(60000000,2,'2018-12-07','2018-10-07');
INSERT INTO Pago VALUE	(60000000,3,'2019-01-07','2018-10-07');
INSERT INTO Pago VALUE	(60000000,4,'2019-02-07','2018-10-07');
INSERT INTO Pago VALUE	(60000000,5,'2019-03-07','2018-10-07');
INSERT INTO Pago VALUE	(60000000,6,'2019-04-07','2018-10-07');
INSERT INTO Pago VALUE	(60000000,7,'2019-05-07','2018-10-07');
INSERT INTO Pago VALUE	(60000000,8,'2019-06-07','2018-10-07');
INSERT INTO Pago VALUE	(60000000,9,'2019-07-07','2018-10-07');
INSERT INTO Pago VALUE	(60000000,10,'2019-08-07','2018-10-07');
INSERT INTO Pago VALUE	(60000000,11,'2019-09-07',NULL);
INSERT INTO Pago VALUE	(60000000,12,'2019-10-07',NULL);
INSERT INTO Pago VALUE	(70000000,1,'2018-11-07',NULL);
INSERT INTO Pago VALUE	(70000000,2,'2018-12-07',NULL);
INSERT INTO Pago VALUE	(70000000,3,'2019-01-07',NULL);
INSERT INTO Pago VALUE	(70000000,4,'2019-02-07',NULL);
INSERT INTO Pago VALUE	(70000000,5,'2019-03-07',NULL);
INSERT INTO Pago VALUE	(70000000,6,'2019-04-07',NULL);
INSERT INTO Pago VALUE	(70000000,7,'2019-05-07',NULL);
INSERT INTO Pago VALUE	(70000000,8,'2019-06-07',NULL);
INSERT INTO Pago VALUE	(70000000,9,'2019-07-07',NULL);
INSERT INTO Pago VALUE	(70000000,10,'2019-08-07',NULL);
INSERT INTO Pago VALUE	(70000000,11,'2019-09-07',NULL);
INSERT INTO Pago VALUE	(70000000,12,'2019-10-07',NULL);
INSERT INTO Pago VALUE	(70000000,13,'2019-11-07',NULL);
INSERT INTO Pago VALUE	(70000000,14,'2019-12-07',NULL);
INSERT INTO Pago VALUE	(70000000,15,'2020-01-07',NULL);
INSERT INTO Pago VALUE	(70000000,16,'2020-02-07',NULL);
INSERT INTO Pago VALUE	(70000000,17,'2020-03-07',NULL);
INSERT INTO Pago VALUE	(70000000,18,'2020-04-07',NULL);
INSERT INTO Pago VALUE	(70000000,19,'2020-05-07',NULL);
INSERT INTO Pago VALUE	(70000000,20,'2020-06-07',NULL);
INSERT INTO Pago VALUE	(70000000,21,'2020-07-07',NULL);
INSERT INTO Pago VALUE	(70000000,22,'2020-08-07',NULL);
INSERT INTO Pago VALUE	(70000000,23,'2020-09-07',NULL);
INSERT INTO Pago VALUE	(70000000,24,'2020-10-07',NULL);
   
#Alta de Caja_Ahorro
#Formato de inserción: (nro_ca, cbu, saldo)
INSERT INTO caja_ahorro VALUE (1, '11223344', 50000.00);
INSERT INTO caja_ahorro VALUE (2, '12345678', 100000.00);
INSERT INTO caja_ahorro VALUE (3, '87654321', 500000.00);
INSERT INTO caja_ahorro VALUE (4, '10000001', 1000000.00);
INSERT INTO caja_ahorro VALUE (5, '11223399', 75000.00);
INSERT INTO caja_ahorro VALUE (6, '11223345', 250000.00);

#Alta de Cliente_CA
#Formato de inserción: (nro_cliente, nro_ca)
INSERT INTO Cliente_CA VALUE (1,1);
INSERT INTO Cliente_CA VALUE (1,2);
INSERT INTO Cliente_CA VALUE (2,2);
INSERT INTO Cliente_CA VALUE (3,3);
INSERT INTO Cliente_CA VALUE (3,4);
INSERT INTO Cliente_CA VALUE (3,6);
INSERT INTO Cliente_CA VALUE (4,3);
INSERT INTO Cliente_CA VALUE (4,4);
INSERT INTO Cliente_CA VALUE (5,4);
INSERT INTO Cliente_CA VALUE (5,5);
INSERT INTO Cliente_CA VALUE (6,4);
INSERT INTO Cliente_CA VALUE (7,1);
INSERT INTO Cliente_CA VALUE (7,4);

#Alta de Plazo_Fijo
#Formato de inserción: (nro_plazo, capital, fecha_inicio, fecha_fin, tasa_interes, interes, nro_suc)
INSERT INTO Plazo_Fijo VALUE (105, 100000000.00, '2018.05.30', '2021.05.30', 10.00, 15000.00, 1);
INSERT INTO Plazo_Fijo VALUE (106, 200000000.00, '2018.08.30', '2022.08.30', 15.00, 15000.00, 2);
INSERT INTO Plazo_Fijo VALUE (107, 30000000.00, '2018.10.30', '2020.10.30', 10.00, 15000.00, 3);
INSERT INTO Plazo_Fijo VALUE (108, 5500000.00, '2018.03.30', '2019.03.30', 5.00, 15000.00, 4);
INSERT INTO Plazo_Fijo VALUE (109, 2000000.00, '2018.11.30', '2020.11.30', 20.00, 15000.00, 5); 

#Alta de Tasa_Plazo_Fijo
#Formato de inserción: (periodo, monto_inf, monto_sup, tasa)
INSERT INTO Tasa_Plazo_Fijo VALUE (12,20000.00,30000.00,70.00);
INSERT INTO Tasa_Plazo_Fijo VALUE (14,30000.00,40000.00,60.00);
INSERT INTO Tasa_Plazo_Fijo VALUE (15,40000.00,50000.00,50.00);
INSERT INTO Tasa_Plazo_Fijo VALUE (18,10000.00,20000.00,90.00);
INSERT INTO Tasa_Plazo_Fijo VALUE (19,50000.00,60000.00,90.00);

#Alta de Plazo_Cliente
#Formato de inserción: (nro_plazo, nro_cliente)
INSERT INTO Plazo_Cliente VALUE (105, 1);
INSERT INTO Plazo_Cliente VALUE (106, 2);
INSERT INTO Plazo_Cliente VALUE (107, 3);
INSERT INTO Plazo_Cliente VALUE (108, 4);
INSERT INTO Plazo_Cliente VALUE (109, 5);

#Alta de Tarjeta
#Formato de inserción: (nro_tarjeta, PIN, CVT, fecha_venc, nro_cliente, nro_ca)
INSERT INTO Tarjeta VALUE (1, md5('1'), md5('103'), '2018-08-30', 1, 1);
INSERT INTO Tarjeta VALUE (2, md5('2'), md5('985'), '2020-09-30', 2, 2);
INSERT INTO Tarjeta VALUE (3, md5('3'), md5('123'), '2019-10-30', 3, 4);
INSERT INTO Tarjeta VALUE (4, md5('4'), md5('201'), '2018-11-30', 4, 4);
INSERT INTO Tarjeta VALUE (5, md5('5'), md5('567'), '2021-12-30', 5, 5);
INSERT INTO Tarjeta VALUE (6, md5('6'), md5('621'), '2017-04-16', 6, 4);
INSERT INTO Tarjeta VALUE (7, md5('7'), md5('702'), '2017-04-16', 7, 4);
INSERT INTO Tarjeta VALUE (8, md5('8'), md5('874'), '2017-04-16', 7, 1);

#Alta de Tasa_Prestamo
#Formato de inserción: (periodo, monto_inf, monto_sup, tasa)
INSERT INTO Tasa_Prestamo VALUE (6,0.00,3000.00,17.00);
INSERT INTO Tasa_Prestamo VALUE	(6,3000.00,10000.00,20.00);
INSERT INTO Tasa_Prestamo VALUE	(6,10000.00,30000.00,24.00);
INSERT INTO Tasa_Prestamo VALUE	(12,0.00,3000.00,18.50);
INSERT INTO Tasa_Prestamo VALUE	(12,3000.00,10000.00,21.50);
INSERT INTO Tasa_Prestamo VALUE	(12,10000.00,30000.00,25.50);
INSERT INTO Tasa_Prestamo VALUE	(24,0.00,3000.00,20.00);
INSERT INTO Tasa_Prestamo VALUE	(24,3000.00,10000.00,23.00);
INSERT INTO Tasa_Prestamo VALUE	(24,10000.00,30000.00,27.00);
INSERT INTO Tasa_Prestamo VALUE	(60,0.00,3000.00,25.00);
INSERT INTO Tasa_Prestamo VALUE	(60,3000.00,10000.00,28.00);
INSERT INTO Tasa_Prestamo VALUE	(60,10000.00,30000.00,32.00);
INSERT INTO Tasa_Prestamo VALUE	(120,0.00,3000.00,30.00);
INSERT INTO Tasa_Prestamo VALUE	(120,3000.00,10000.00,33.00);
INSERT INTO Tasa_Prestamo VALUE	(120,10000.00,30000.00,37.00);

#Alta de Caja
#Formato de inserción: (cod_caja)
INSERT INTO Caja VALUE (1);
INSERT INTO Caja VALUE (2);
INSERT INTO Caja VALUE (3);
INSERT INTO Caja VALUE (4);
INSERT INTO Caja VALUE (5);
INSERT INTO Caja VALUE (6);
INSERT INTO Caja VALUE (7);
INSERT INTO Caja VALUE (8);
INSERT INTO Caja VALUE (9);
INSERT INTO Caja VALUE (10);
INSERT INTO Caja VALUE (11);
INSERT INTO Caja VALUE (12);
INSERT INTO Caja VALUE (13);

#Alta de ATM
#Formato de inserción: (cod_caja, cod_postal, direccion)
INSERT INTO ATM VALUE (1, 8000, 'Chiclana 326');
INSERT INTO ATM VALUE (2, 8000, '11 de Abril y Zapiola');
INSERT INTO ATM VALUE (3, 9000, 'Av. Rivadavia 202');
INSERT INTO ATM VALUE (4, 9000, 'Esq. Ruta Nac. Nº 3 y Calle Alberto Blanc Barrio Industrial');
INSERT INTO ATM VALUE (5, 8500, 'Sarmiento 373');
INSERT INTO ATM VALUE (6, 8500, 'Gallardo 121');
INSERT INTO ATM VALUE (7, 5400, 'Sarmiento 780');
INSERT INTO ATM VALUE (8, 8300, 'Carlos H.Rodríguez 160');
INSERT INTO ATM VALUE (9, 8300, 'San Luis 260');
INSERT INTO ATM VALUE (10,1000,'Abasto Shopping');
INSERT INTO ATM VALUE (11,1000,'Av Santa fe 2545');
INSERT INTO ATM VALUE (12,1000,'Paraguay 754');
INSERT INTO ATM VALUE (13,7600,'Carlos Cazares 4566');

#Alta de Ventanilla
#Formato de inserción: (cod_caja, nro_suc)
INSERT INTO Ventanilla VALUE (1, 1);
INSERT INTO Ventanilla VALUE (2, 1);
INSERT INTO Ventanilla VALUE (3, 2);
INSERT INTO Ventanilla VALUE (4, 2);
INSERT INTO Ventanilla VALUE (5, 3);
INSERT INTO Ventanilla VALUE (6, 3);
INSERT INTO Ventanilla VALUE (7, 4);
INSERT INTO Ventanilla VALUE (8, 5);
INSERT INTO Ventanilla VALUE (9, 5);

#Alta de Transaccion
#Formato de inserción: (nro_trans, fecha, hora, monto)

#Transacciones de depósitos
INSERT INTO Transaccion VALUE   (1,'2018-10-04','15:43:12',10000.00);
INSERT INTO Transaccion VALUE	(2,'2018-10-04','15:43:12',20000.00);
INSERT INTO Transaccion VALUE	(3,'2018-10-04','15:43:12',30000.00);
INSERT INTO Transaccion VALUE	(4,'2018-10-04','15:43:13',40000.00);
INSERT INTO Transaccion VALUE	(5,'2018-10-04','15:43:13',5500.00);
INSERT INTO Transaccion VALUE	(6,'2018-10-04','15:43:13',12000.00);
INSERT INTO Transaccion VALUE	(100,'2018-10-04','15:43:13',1500.00);
INSERT INTO Transaccion VALUE	(101,'2018-10-04','15:43:13',2000.00);
INSERT INTO Transaccion VALUE	(102,'2018-10-04','15:43:13',3000.00);
INSERT INTO Transaccion VALUE	(200,'2018-10-04','15:43:14',800.00);
INSERT INTO Transaccion VALUE	(201,'2018-10-04','15:43:14',1200.00);
INSERT INTO Transaccion VALUE	(202,'2018-10-04','15:43:14',600.00);
INSERT INTO Transaccion VALUE	(203,'2018-10-04','15:43:14',4000.00);
INSERT INTO Transaccion VALUE	(204,'2018-10-04','15:43:14',2300.00);
INSERT INTO Transaccion VALUE	(300,'2018-10-04','15:43:14',3500.00);
INSERT INTO Transaccion VALUE	(301,'2018-10-04','15:43:14',5000.00);
INSERT INTO Transaccion VALUE	(302,'2018-10-04','15:43:14',2000.00);
INSERT INTO Transaccion VALUE	(303,'2018-10-04','15:43:15',1000.00);
INSERT INTO Transaccion VALUE	(304,'2018-10-04','15:43:15',7500.00);
INSERT INTO Transaccion VALUE	(1001,'2015-10-01','13:30:00',40.50);
INSERT INTO Transaccion VALUE	(1002,'2015-10-02','13:30:00',1001.00);
INSERT INTO Transaccion VALUE	(1003,'2015-10-03','13:30:00',101.00);
INSERT INTO Transaccion VALUE	(1004,'2015-10-04','13:30:00',501.00);
INSERT INTO Transaccion VALUE	(1005,'2015-10-05','13:30:00',50.50);
INSERT INTO Transaccion VALUE	(1006,'2015-10-06','13:30:00',1002.00);
INSERT INTO Transaccion VALUE	(1007,'2015-10-07','13:30:00',102.00);
INSERT INTO Transaccion VALUE	(1008,'2015-10-08','13:30:00',502.00);
INSERT INTO Transaccion VALUE	(1009,'2015-10-09','13:30:00',60.50);
INSERT INTO Transaccion VALUE	(1010,'2015-10-10','13:30:00',1003.00);
INSERT INTO Transaccion VALUE	(1011,'2015-10-11','13:30:00',103.00);
INSERT INTO Transaccion VALUE	(1012,'2015-10-12','13:30:00',503.00);
INSERT INTO Transaccion VALUE	(1013,'2015-10-13','13:30:00',70.50);
INSERT INTO Transaccion VALUE	(1014,'2015-10-14','13:30:00',1004.00);
INSERT INTO Transaccion VALUE	(1015,'2015-10-15','13:30:00',104.00);
INSERT INTO Transaccion VALUE	(1016,'2015-10-16','13:30:00',504.00);

#Alta de Transaccion_por_Caja para depósitos
#Formato de inserción: (nro_trans, cod_caja)
INSERT INTO Transaccion_por_Caja VALUE  (1,1);
INSERT INTO Transaccion_por_Caja VALUE	(2,1);
INSERT INTO Transaccion_por_Caja VALUE	(200,1);
INSERT INTO Transaccion_por_Caja VALUE	(203,1);
INSERT INTO Transaccion_por_Caja VALUE	(304,1);
INSERT INTO Transaccion_por_Caja VALUE	(3,2);
INSERT INTO Transaccion_por_Caja VALUE	(204,2);
INSERT INTO Transaccion_por_Caja VALUE	(302,2);
INSERT INTO Transaccion_por_Caja VALUE	(1002,2);
INSERT INTO Transaccion_por_Caja VALUE	(1010,2);
INSERT INTO Transaccion_por_Caja VALUE	(1014,2);
INSERT INTO Transaccion_por_Caja VALUE	(5,3);
INSERT INTO Transaccion_por_Caja VALUE	(6,3);
INSERT INTO Transaccion_por_Caja VALUE	(202,3);
INSERT INTO Transaccion_por_Caja VALUE	(301,3);
INSERT INTO Transaccion_por_Caja VALUE	(303,3);
INSERT INTO Transaccion_por_Caja VALUE	(1006,3);
INSERT INTO Transaccion_por_Caja VALUE	(4,4);
INSERT INTO Transaccion_por_Caja VALUE	(201,4);
INSERT INTO Transaccion_por_Caja VALUE	(300,4);
INSERT INTO Transaccion_por_Caja VALUE	(1003,10);
INSERT INTO Transaccion_por_Caja VALUE	(1011,10);
INSERT INTO Transaccion_por_Caja VALUE	(1004,11);
INSERT INTO Transaccion_por_Caja VALUE	(1012,11);
INSERT INTO Transaccion_por_Caja VALUE	(1007,12);
INSERT INTO Transaccion_por_Caja VALUE	(1015,12);
INSERT INTO Transaccion_por_Caja VALUE	(1008,13);
INSERT INTO Transaccion_por_Caja VALUE	(1016,13);

#Alta de Deposito
#Formato de inserción: (nro_trans, nro_ca)
INSERT INTO Deposito VALUE  (2,1);
INSERT INTO Deposito VALUE	(1002,1);
INSERT INTO Deposito VALUE	(1006,1);
INSERT INTO Deposito VALUE	(1010,1);
INSERT INTO Deposito VALUE	(1014,1);
INSERT INTO Deposito VALUE	(4,2);
INSERT INTO Deposito VALUE	(3,3);
INSERT INTO Deposito VALUE	(1,4);
INSERT INTO Deposito VALUE	(5,5);
INSERT INTO Deposito VALUE	(6,6);

#Alta de debito
#Formato de inserción: (nro_trans, descripcion, nro_cliente, nro_ca)
INSERT INTO Debito VALUE (100, 'Chromecast 2', 3, 6);
INSERT INTO Debito VALUE (101, 'Camuzi', 3, 4);
INSERT INTO Debito VALUE (102, 'Mercadolibre', 1, 2);
INSERT INTO Debito VALUE (1001,'Pago Servicios',1,1);
INSERT INTO Debito VALUE (1005,'Pago servicios',7,1);
INSERT INTO Debito VALUE (1009,'Pago servicios',1,1);
INSERT INTO Debito VALUE (1013,'Pago servicios',1,1);

#Alta de Extraccion
#Formato de inserción: (nro_trans, nro_cliente, nro_ca)
INSERT INTO Extraccion VALUE (201,1,1);
INSERT INTO Extraccion VALUE (1007,1,1);
INSERT INTO Extraccion VALUE (1011,1,1);
INSERT INTO Extraccion VALUE (1015,1,1);
INSERT INTO Extraccion VALUE (202,2,2);
INSERT INTO Extraccion VALUE (204,3,4);
INSERT INTO Extraccion VALUE (203,4,4);
INSERT INTO Extraccion VALUE (200,5,5);
INSERT INTO Extraccion VALUE (1003,7,1);

#Alta de Transferencia
#Formato de inserción: (nro_trans, nro_cliente, origen, destino)
INSERT INTO Transferencia VALUE (300, 1, 1, 3);
INSERT INTO Transferencia VALUE (301, 2, 2, 4);
INSERT INTO Transferencia VALUE (302, 5, 5, 1);
INSERT INTO Transferencia VALUE (303, 1, 2, 6);
INSERT INTO Transferencia VALUE (304, 4, 3, 5);
INSERT INTO Transferencia VALUE (1004,1,1,2);
INSERT INTO Transferencia VALUE	(1008,7,1,3);
INSERT INTO Transferencia VALUE	(1012,7,1,4);
INSERT INTO Transferencia VALUE	(1016,7,1,4);