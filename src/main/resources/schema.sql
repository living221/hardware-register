DROP TABLE IF EXISTS hw_reg CASCADE;
DROP TABLE IF EXISTS hw_type CASCADE;
DROP TABLE IF EXISTS tv_models CASCADE;
DROP TABLE IF EXISTS hoover_models CASCADE;
DROP TABLE IF EXISTS refrigerator_models CASCADE;
DROP TABLE IF EXISTS smartphone_models CASCADE;
DROP TABLE IF EXISTS computer_models CASCADE;

CREATE TABLE IF NOT EXISTS hw_reg
(
    id           BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    hw_type_id   BIGINT       NOT NULL,
    name         VARCHAR(255) NOT NULL,
    country      VARCHAR(100) NOT NULL,
    manufacturer VARCHAR(100) NOT NULL,
    online_order boolean      NOT NULL,
    credit       boolean      NOT NULL
);

CREATE TABLE IF NOT EXISTS hw_type
(
    id      BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    hw_type VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS tv_models
(
    id         BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    model_name VARCHAR(255) NOT NULL,
    serial     VARCHAR(255) NOT NULL,
    colour     VARCHAR(255) NOT NULL,
    size       INTEGER      NOT NULL,
    price      NUMERIC(19, 2),
    category   VARCHAR(255) NOT NULL,
    technology VARCHAR(255) NOT NULL,
    in_stock   boolean      NOT NULL,
    hw_reg_id  BIGINT       NOT NULL,
    FOREIGN KEY (hw_reg_id) REFERENCES hw_reg (id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS hoover_models
(
    id            BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    model_name    VARCHAR(255) NOT NULL,
    serial        VARCHAR(255) NOT NULL,
    colour        VARCHAR(255) NOT NULL,
    size          INTEGER      NOT NULL,
    price         NUMERIC(19, 2),
    dust_capacity INTEGER      NOT NULL,
    modes_count   INTEGER      NOT NULL,
    in_stock      boolean      NOT NULL,
    hw_reg_id     BIGINT       NOT NULL,
    FOREIGN KEY (hw_reg_id) REFERENCES hw_reg (id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS refrigerator_models
(
    id              BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    model_name      VARCHAR(255) NOT NULL,
    serial          VARCHAR(255) NOT NULL,
    colour          VARCHAR(255) NOT NULL,
    size            INTEGER      NOT NULL,
    price           NUMERIC(19, 2),
    doors_count     INTEGER      NOT NULL,
    compressor_type VARCHAR(255) NOT NULL,
    in_stock        boolean      NOT NULL,
    hw_reg_id       BIGINT       NOT NULL,
    FOREIGN KEY (hw_reg_id) REFERENCES hw_reg (id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS smartphone_models
(
    id            BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    model_name    VARCHAR(255) NOT NULL,
    serial        VARCHAR(255) NOT NULL,
    colour        VARCHAR(255) NOT NULL,
    size          INTEGER      NOT NULL,
    price         NUMERIC(19, 2),
    memory        VARCHAR(255) NOT NULL,
    cameras_count INTEGER      NOT NULL,
    in_stock      boolean      NOT NULL,
    hw_reg_id     BIGINT       NOT NULL,
    FOREIGN KEY (hw_reg_id) REFERENCES hw_reg (id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS computer_models
(
    id             BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    model_name     VARCHAR(255) NOT NULL,
    serial         VARCHAR(255) NOT NULL,
    colour         VARCHAR(255) NOT NULL,
    size           INTEGER      NOT NULL,
    price          NUMERIC(19, 2),
    category       VARCHAR(255) NOT NULL,
    processor_type VARCHAR(255) NOT NULL,
    in_stock       boolean      NOT NULL,
    hw_reg_id      BIGINT       NOT NULL,
    FOREIGN KEY (hw_reg_id) REFERENCES hw_reg (id) ON DELETE CASCADE
);