CREATE DATABASE VETERINARIA;
USE VETERINARIA;

CREATE TABLE CLIENTE(
    ID INT NOT NULL AUTO_INCREMENT,
    NOMBRE VARCHAR(50) NOT NULL,
    APELLIDOS VARCHAR(50) NOT NULL,
    TELEFONO VARCHAR(50) NOT NULL,
    EMAIL VARCHAR(50) NOT NULL,
    PRIMARY KEY (ID)
);


CREATE TABLE MASCOTA(
    ID INT NOT NULL AUTO_INCREMENT,
    NOMBRE VARCHAR(50) NOT NULL,
    FECHA_NACIMIENTO TIMESTAMP NOT NULL,
    PESO DECIMAL(5,2) NOT NULL,
    NOTAS VARCHAR(50) NOT NULL,
    FOTO VARCHAR(50) NOT NULL,
    ID_CLIENTE INT NOT NULL,
    SEXO VARCHAR(1),
    ESPECIE VARCHAR(50),
    RAZA VARCHAR(50),
    INDEX ID_CTE (ID_CLIENTE),
    FOREIGN KEY (ID_CLIENTE)
        REFERENCES CLIENTE(ID)
        ON DELETE CASCADE,
    PRIMARY KEY (ID)
);

CREATE TABLE PRODUCTO(
    ID INT NOT NULL AUTO_INCREMENT,
    DESCRIPCION VARCHAR(50) NOT NULL,
    PRIMARY KEY (ID)
);

CREATE TABLE CITA(
    ID INT NOT NULL AUTO_INCREMENT,
    FECHA TIMESTAMP NOT NULL,
    DESCRIPCION VARCHAR(50),
    ID_CLIENTE INT NOT NULL,
    ID_MASCOTA INT NOT NULL,
    INDEX ID_CTE (ID_CLIENTE),
    INDEX ID_MTA (ID_MASCOTA),
    FOREIGN KEY (ID_CLIENTE)
        REFERENCES CLIENTE(ID)
        ON DELETE CASCADE,
    FOREIGN KEY (ID_MASCOTA)
        REFERENCES MASCOTA(ID)
        ON DELETE CASCADE,
    PRIMARY KEY (ID)
);


INSERT INTO CLIENTE (NOMBRE, APELLIDOS, TELEFONO, EMAIL)
VALUES ('Paula Cesandarey', 'Ruiz Fernandez', '111-1234', 'paula@example.com');
INSERT INTO CLIENTE (NOMBRE, APELLIDOS, TELEFONO, EMAIL)
VALUES ('Karla Alejandra', 'Yiven Anaya', '222-1234', 'karla@example.com');
INSERT INTO CLIENTE (NOMBRE, APELLIDOS, TELEFONO, EMAIL)
VALUES ('Moises', 'Navarro Galvan', '333-1234', 'moises@example.com');
INSERT INTO CLIENTE (NOMBRE, APELLIDOS, TELEFONO, EMAIL)
VALUES ('Fidel', 'Espino Palacios', '444-1234', 'fidel@example.com');
INSERT INTO CLIENTE (NOMBRE, APELLIDOS, TELEFONO, EMAIL)
VALUES ('Luis Fernando', 'Morales Garduño', '555-1234', 'luis@example.com');




INSERT INTO MASCOTA (NOMBRE, FECHA_NACIMIENTO, PESO, NOTAS, ID_CLIENTE, SEXO, ESPECIE, RAZA)
VALUES ('Cecina', '2022-10-01 04:58:00', 2.200, 'Muerde los sillones', , 1, 'M', 'GATO', 'ATIGRADO');
INSERT INTO MASCOTA (NOMBRE, FECHA_NACIMIENTO, PESO, NOTAS, FOTO, ID_CLIENTE, SEXO, ESPECIE, RAZA)
VALUES ('Turin', '2022-10-01 04:58:00', 2.200, 'Hace mucho del baño', 1, 'M', 'GATO', 'ATIGRADO');


INSERT INTO MASCOTA (NOMBRE, FECHA_NACIMIENTO, PESO, NOTAS, FOTO, ID_CLIENTE, SEXO, ESPECIE, RAZA)
VALUES ('Miawricio', '2022-10-01 04:58:00', 3.600, 'Le gusta dormir', 2, 'M', 'GATO', 'NARANJA');


INSERT INTO MASCOTA (NOMBRE, FECHA_NACIMIENTO, PESO, NOTAS, FOTO, ID_CLIENTE, SEXO, ESPECIE, RAZA)
VALUES ('Amaterasu', '2022-10-01 04:58:00', 26.100, 'Es muy dramatica', 3, 'H', 'PERRO', 'GOLDEN RETRIEVER');
INSERT INTO MASCOTA (NOMBRE, FECHA_NACIMIENTO, PESO, NOTAS, FOTO, ID_CLIENTE, SEXO, ESPECIE, RAZA)
VALUES ('Uzume', '2022-10-01 04:58:00', 6.8, 'No se cansa', 3, 'H', 'PERRO', 'SHIBA INU');


INSERT INTO MASCOTA (NOMBRE, FECHA_NACIMIENTO, PESO, NOTAS, FOTO, ID_CLIENTE, SEXO, ESPECIE, RAZA)
VALUES ('Wrex', '2022-10-01 04:58:00', 0.65, 'Muerde', 4, 'M', 'PERRO', 'ESPONJOSO');


INSERT INTO MASCOTA (NOMBRE, FECHA_NACIMIENTO, PESO, NOTAS, FOTO, ID_CLIENTE, SEXO, ESPECIE, RAZA)
VALUES ('Solovino', '2022-10-01 04:58:00', 23.700, 'Come como si cooperara', 5, 'M', 'PERRO', 'BULLDOG INGLES');


INSERT INTO CITA(FECHA, DESCRIPCION, ID_CLIENTE, ID_MASCOTA)
VALUES('2023-04-03 17:30:00','MUERDE MUCHO', 1,1);

INSERT INTO CITA(FECHA, DESCRIPCION, ID_CLIENTE, ID_MASCOTA)
VALUES('2023-04-03 18:00:00','SE PELEA EN LOS TECHOS', 1,2);

INSERT INTO CITA(FECHA, DESCRIPCION, ID_CLIENTE, ID_MASCOTA)
VALUES('2023-04-03 18:30:00','HUELE A CHETOS', 2,3);

INSERT INTO CITA(FECHA, DESCRIPCION, ID_CLIENTE, ID_MASCOTA)
VALUES('2023-04-03 19:00:00','NO COME POLLITO', 3,4);

INSERT INTO CITA(FECHA, DESCRIPCION, ID_CLIENTE, ID_MASCOTA)
VALUES('2023-04-03 19:30:00','SOLO COME POLLITO', 3,5);

INSERT INTO CITA(FECHA, DESCRIPCION, ID_CLIENTE, ID_MASCOTA)
VALUES('2023-04-03 20:00:00','DUERME MUCHO', 4,6);

INSERT INTO CITA(FECHA, DESCRIPCION, ID_CLIENTE, ID_MASCOTA)
VALUES('2023-04-03 20:30:00','CORRE MUCHO', 5,7);
