drop database if exists DB_VentaPerifericos;
create database DB_VentaPerifericos;
use DB_VentaPerifericos;
 
create table DispositivosPerifericos(
	codigoDispositivo int auto_increment,
    nombre varchar(100) not null,
    tipo varchar(100) not null,
    precio decimal(10,2) not null,
    primary key PK_codigoDispositivo(codigoDispositivo) 
);
 
create table Ventas(
	codigoVenta int auto_increment,
    cantidad int not null,
    total  decimal(10,2) not null,
	primary key PK_codigoVenta(codigoVenta),
    codigoDispositivo int,
    constraint FK_Dispositivo foreign key (codigoDispositivo) 
        references DispositivosPerifericos(codigoDispositivo) on delete cascade
);
 
Delimiter $$
	create procedure sp_AgregarDispositivos(
		in nombre varchar(100),
		in tipo varchar(100),
		in precio decimal(10,2))
	begin
		insert into DispositivosPerifericos (nombre, tipo, precio)
		values (nombre, tipo, precio);
	end $$
Delimiter ;
call sp_AgregarDispositivos('Teclado Mecánico', 'Teclado', '100.50');
call sp_AgregarDispositivos('Mouse Óptico', 'Mouse', '38.99');
call sp_AgregarDispositivos('Auriculares Bluetooth', 'Auricular', '50.00');
call sp_AgregarDispositivos('Webcam HD', 'Cámara', '70.00');
call sp_AgregarDispositivos('Pantalla 24" LED', 'Monitor', '200.00');
call sp_AgregarDispositivos('Micrófono USB', 'Micrófono', '40.00');
call sp_AgregarDispositivos('Altavoces Estéreo', 'Altavoces', '60.60');
call sp_AgregarDispositivos('Lámpara LED RGB', 'Accesorio', '25.35');
call sp_AgregarDispositivos('Soporte para PC', 'Soporte', '15.60');
call sp_AgregarDispositivos('Hub USB 3.0', 'Accesorio', '20.30');
 
Delimiter $$
	create procedure sp_ListarDispositivos()
		begin
			select codigoDispositivo, nombre, tipo, precio
			from DispositivosPerifericos;
		end $$
Delimiter ;
call sp_ListarDispositivos();
 
Delimiter $$
	create procedure sp_EliminarDispositivos(in cod int)
		begin
			delete from DispositivosPerifericos 
				where codigoDispositivo = cod;
		end $$
Delimiter ;
-- call sp_EliminarDispositivos(1);
 
Delimiter $$
	create procedure sp_EditarDispositivos(
		in cod int,
		in nom varchar(100),
		in tip varchar(100),
		in pre decimal(10,2))
	begin
		update DispositivosPerifericos
		set nombre = nom,
			tipo = tip,
			precio = pre
		where codigoDispositivo = cod;
	end $$
Delimiter ;
call sp_EditarDispositivos(1, 'Teclado Gamer', 'Teclado', '530.50');
 
Delimiter $$
	create procedure sp_AgregarVentas(
		in cantidad int,
		in total decimal(10,2),
        in codigoDispositivo int)
	begin
		insert into Ventas (cantidad, total ,codigoDispositivo)
		values (cantidad, total,codigoDispositivo);
	end $$
Delimiter ;
call sp_AgregarVentas(3, 301.50, 1); 
call sp_AgregarVentas(5, 194.95,  2);  
call sp_AgregarVentas(2, 100.00, 3); 
call sp_AgregarVentas(4, 280.00, 4);  
call sp_AgregarVentas(1, 200.00,  5);  
call sp_AgregarVentas(10, 400.00, 6);
call sp_AgregarVentas(3, 181.80, 7); 
call sp_AgregarVentas(6, 152.10, 8); 
call sp_AgregarVentas(5, 78.00, 9);  
call sp_AgregarVentas(7, 142.10, 10);
 
Delimiter $$
	create procedure sp_ListarVentas()
		begin
			select codigoVenta, cantidad, total, codigoDispositivo
			from Ventas;
		end $$
Delimiter ;
call sp_ListarVentas();
 
Delimiter $$
	create procedure sp_EliminarVentas(in codV int)
		begin
			delete from Ventas 
				where codigoVenta = codV;
		end $$
Delimiter ;
-- call sp_EliminarDispositivos(1);
 
Delimiter $$
	create procedure sp_EditarVentas(
		in codV int,
		in can int,
		in tot decimal(10,2),
        in codigoD int)
	begin
		update Ventas
		set cantidad = can,
			total = tot,
            codigoDispositivo = codigoD
		where codigoVenta = codV;
	end $$
Delimiter ;
call sp_EditarVentas(1, 5, '580.20',3);