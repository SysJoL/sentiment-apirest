CREATE TABLE comentarios (
    id SERIAL PRIMARY KEY,
    texto VARCHAR(2000) NOT NULL,
    sentimiento VARCHAR(50) NOT NULL,
    probabilidad DOUBLE PRECISION NOT NULL,
    fecha TIMESTAMP NOT NULL
);
