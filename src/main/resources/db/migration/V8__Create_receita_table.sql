CREATE TABLE receita
(
    id        NUMBER DEFAULT receita_seq.NEXTVAL PRIMARY KEY,
    descricao VARCHAR2(255)                NOT NULL,
    categoria VARCHAR2(255),
    valor     NUMBER                       NOT NULL,
    data      TIMESTAMP                    NOT NULL,
    conta_id  NUMBER REFERENCES conta (id) NOT NULL
);