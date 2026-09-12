CREATE SEQUENCE sq_missao
    START WITH 1
    INCREMENT BY 1;

CREATE TABLE t_missao (
                          id_missao NUMBER PRIMARY KEY,
                          nm_missao VARCHAR2(100) NOT NULL,
                          ds_missao VARCHAR2(1000),
                          tp_dificuldade NUMBER(1) CHECK (tp_dificuldade BETWEEN 1 AND 3),
                          nr_pontos_recompensa NUMBER NOT NULL,
                          ds_imagem VARCHAR2(255),
                          st_missao CHAR(1) DEFAULT 'A' NOT NULL
);

CREATE SEQUENCE sq_recompensa
    START WITH 1
    INCREMENT BY 1;

CREATE TABLE t_recompensa (
                              id_recompensa NUMBER PRIMARY KEY,
                              nm_recompensa VARCHAR2(100) NOT NULL,
                              ds_recompensa VARCHAR2(1000),
                              tp_acessorio VARCHAR2(50),
                              nr_custo_pontos NUMBER NOT NULL,
                              ds_imagem VARCHAR2(255),
                              st_recompensa CHAR(1) DEFAULT 'A' NOT NULL
);

INSERT INTO t_missao
VALUES (
           sq_missao.NEXTVAL,
           'Economizar água',
           'Feche a torneira ao escovar os dentes',
           1,
           10,
           NULL,
           'A'
       );

INSERT INTO t_recompensa
VALUES (
           sq_recompensa.NEXTVAL,
           'Adesivo Gaia',
           'Adesivo ecológico',
           'ADESIVO',
           20,
           NULL,
           'A'
       );

COMMIT;

SELECT table_name
FROM user_tables
WHERE table_name IN ('T_MISSAO', 'T_RECOMPENSA');

T_MISSAO
T_RECOMPENSA