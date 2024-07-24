--CREATE DATABASE Devsu

Use Devsu

DROP TABLE IF EXISTS Movimientos;
DROP TABLE IF EXISTS Cuentas;
DROP TABLE IF EXISTS Clientes;
DROP TABLE IF EXISTS Personas;

CREATE TABLE Personas(
	Identidad VARCHAR(255) NOT NULL primary key,
	Nombre VARCHAR(1000) NOT NULL,
	Genero VARCHAR(50) NOT NULL,
	Edad TINYINT NOT NULL,
	Direccion VARCHAR(4000) NOT NULL,
	Telefono VARCHAR(20) NOT NULL
)

CREATE TABLE Clientes(
	Id INT IDENTITY(1,1) NOT NULL  primary key,
	[Password] NVARCHAR(4000) NOT NULL,
	Estado BIT NOT NULL,
	Persona_Id VARCHAR(255)  NOT NULL,
	CONSTRAINT FK_Cliente_Persona FOREIGN KEY (Persona_Id) REFERENCES Personas(Identidad)
)
CREATE INDEX idx_identidad ON Clientes (Persona_Id);

CREATE TABLE Cuentas(
	Cuenta VARCHAR(255) NOT NULL primary key,
	Tipo VARCHAR(255) NOT NULL,
	SaldoInicial MONEY NOT NULL,
	Estado BIT NOT NULL,
	SaldoDisponible MONEY NOT NULL,
	Cliente_Id INT NOT NULL,
	CONSTRAINT FK_Cuenta_Cliente FOREIGN KEY (Cliente_Id) REFERENCES Clientes(Id)
)
CREATE INDEX idx_cliente ON Cuentas (Cliente_Id);

CREATE TABLE Movimientos(
	Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
	Fecha DATETIME NOT NULL,
	Valor MONEY NOT NULL,
	SaldoDisponible MONEY NOT NULL,
	Cuenta_Id VARCHAR(255) NOT NULL,
	CONSTRAINT FK_Movimiento_Cuenta FOREIGN KEY (Cuenta_Id) REFERENCES Cuentas(Cuenta)
)
CREATE INDEX idx_cuenta ON Movimientos (Cuenta_Id);