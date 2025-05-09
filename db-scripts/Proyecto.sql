create database bdDatos;
use bdDatos;

create table sexo(
    id int auto_increment not null primary key,
    sexo varchar(50)
); 

insert into sexo (sexo) values ("Masculino");
insert into sexo (sexo) values ("Femenino");

-- Verificar que los datos se han insertado correctamente
select * from sexo;

CREATE TABLE usuarios (
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    nombre VARCHAR(100),
    materia VARCHAR(100),
    alumnos INT,
    observacion VARCHAR(150),
    fksexo INT,
    dia DATE,
    hora VARCHAR(20), -- Agregar la columna 'hora'
    FOREIGN KEY(fksexo) REFERENCES sexo(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE usuarios2 (
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    nombre VARCHAR(100),
    materia VARCHAR(100),
    alumnos INT,
    observacion VARCHAR(150),
    fksexo INT,
    dia DATE,
    hora VARCHAR(20), -- Agregar la columna 'hora'
    FOREIGN KEY(fksexo) REFERENCES sexo(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE usuarios3 (
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    nombre VARCHAR(100),
    materia VARCHAR(100),
    alumnos INT,
    observacion VARCHAR(150),
    fksexo INT,
    dia DATE,
    hora VARCHAR(20), -- Agregar la columna 'hora'
    FOREIGN KEY(fksexo) REFERENCES sexo(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE usuarios4 (
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    nombre VARCHAR(100),
    materia VARCHAR(100),
    alumnos INT,
    observacion VARCHAR(150),
    fksexo INT,
    dia DATE,
    hora VARCHAR(20), -- Agregar la columna 'hora'
    FOREIGN KEY(fksexo) REFERENCES sexo(id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Insertar un registro de ejemplo en la tabla usuarios
insert into usuarios(dia, materia, nombre, fksexo, alumnos, observacion, hora) 
values ("2024-02-09", "Estructura de datos", "Darwin", 1, 16, "Monitor de la maquina esta dañada, arreglar.","07:00-09:00");

insert into usuarios2(dia, materia, nombre, fksexo, alumnos, observacion, hora) 
values ("2024-02-09", "Estructura de datos", "Darwin", 1, 16, "Monitor de la maquina esta dañada, arreglar.","07:00-09:00");

insert into usuarios3(dia, materia, nombre, fksexo, alumnos, observacion, hora) 
values ("2024-02-09", "Estructura de datos", "Darwin", 1, 16, "Monitor de la maquina esta dañada, arreglar.","07:00-09:00");

insert into usuarios4(dia, materia, nombre, fksexo, alumnos, observacion, hora) 
values ("2024-02-09", "Estructura de datos", "Darwin", 1, 16, "Monitor de la maquina esta dañada, arreglar.","07:00-09:00");

-- Verificar que el registro se ha insertado correctamente
select * from usuarios;
select * from usuarios2;
select * from usuarios3;
select * from usuarios4;


-- Consultas adicionales
SHOW VARIABLES LIKE 'max_connectios';
SHOW STATUS LIKE 'threads_connected';
select usuarios.id,usuarios.dia, usuarios.materia,usuarios.nombre,sexo.sexo,usuarios.alumnos,usuarios.observacion
from usuarios INNER JOIN sexo ON usuarios.fksexo = sexo.id;

DELETE FROM usuarios WHERE usuarios.id=14;
DELETE FROM usuarios WHERE usuarios2.id=1;
DELETE FROM usuarios WHERE usuarios3.id=1;
DELETE FROM usuarios WHERE usuarios4.id=1;