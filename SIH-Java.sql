create database sih;

use sih;

create table Pacientes (
	ID int primary key auto_increment,
    Nombres varchar(200) not null,
    Apellidos varchar(200) not null,
    Edad tinyint not null,
    Fecha_Ingreso date
);

create table Empleados (
	ID int primary key auto_increment,
    Nombres varchar(200) not null,
    Apellidos varchar(200) not null,
    Cargo varchar(100) not null,
    Salario decimal(10,2) not null
);

create table Departamento (
	ID int primary key,
    Nombre_Departamento varchar(100) not null,
    Empleado_Acargo int,
	Fecha_vinculacion date,
    foreign key (Empleado_Acargo) references Empleados(ID)
);

create table Grupos (
	ID int primary key,
    Coordinador int not null,
    Doctor_junior int,
    Numero_grupo int unique not null,
    foreign key (Coordinador) references Empleados(ID),
    foreign key (Doctor_junior) references Empleados(ID)
);

create table Hospital (
	ID int primary key,
    Nombre_Hospital varchar(100) not null,
	Capacidad int not null,
    Ambulancias tinyint not null,
    Director int,
    Numero_Hospital varchar(15) unique,
    Direccion varchar(100) not null,
    foreign key (Director) references Empleados(ID)
);