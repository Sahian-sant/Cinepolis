CREATE TABLE PELICULAS(
ID NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,--se hace autoincremento
CLAVE VARCHAR2(50)NOT NULL UNIQUE,
NOMBRE VARCHAR2(100)NOT NULL UNIQUE,
GENERO VARCHAR2 (70)NOT NULL,
PRECIO NUMBER NOT NULL
);

INSERT INTO PELICULAS(CLAVE,NOMBRE,GENERO,PRECIO)VALUES('A1001','LA LISTA DE SCHINDLER','DRAMA',70);
INSERT INTO PELICULAS(CLAVE,NOMBRE,GENERO,PRECIO)VALUES('B2002','PARASITE','TRILLER',90);
INSERT INTO PELICULAS(CLAVE,NOMBRE,GENERO,PRECIO)VALUES('A3003','GLADIADOR', 'ACCION', 105);
INSERT INTO PELICULAS(CLAVE,NOMBRE,GENERO,PRECIO)VALUES('C1004','MACARIO','DRAMA',90);
COMMIT;