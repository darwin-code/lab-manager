select * from usuarios;
select * from usuarios2;
select * from usuarios3;
select * from usuarios4;

CREATE TABLE usuarios(
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    nombre VARCHAR(100),
    materia VARCHAR(100),
    alumnos INT,
    observacion VARCHAR(150),
    fksexo INT,
    dia DATE,
    hora VARCHAR(20), -- Agregar la columna 'hora'
    firma varchar(50),
    carrera varchar(50),
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

