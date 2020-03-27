CREATE TABLE IF NOT EXISTS "log_type" (
     "log_type_id" integer PRIMARY KEY,
     "title" character varying(100) NOT NULL,
     "error_level" character varying(100) NOT NULL,
     "description" text NOT NULL
);

CREATE SEQUENCE log_type_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE log_type
    ALTER log_type_id set default nextval('log_type_id_seq');