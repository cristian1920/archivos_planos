create database peliculas
use Peliculas
go 

create table inventario(
cod_peliculas int primary key not  null,
nom_pelicula varchar(20) not null,
genero varchar(20)not null,
precio_venta int not null,
can_bodega int not null,
)

create table empleado(
cod_empleado int primary key not null,
nombre_emp varchar(20) not null,
apellido varchar(20) not null,
)

create table venta_articulo(
cod int IDENTITY(1,1) PRIMARY KEY,
articulo_vend varchar(20) not null,
nombre_ven varchar(20)not null,
cantidad_ven int not null,
valor_total int not null,
fecha varchar(20)not null,
hora varchar(20)not null,
)


SELECT*FROM inventario
select*from venta_articulo

create table usuarios(
id_usuario int IDENTITY(1,1) PRIMARY KEY not null,
usuario varchar(15)not null,
clave VARCHAR(15) NOT NULL,
)
insert into usuarios(usuario,clave)values('Admin',1234);