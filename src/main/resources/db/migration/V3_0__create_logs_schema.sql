CREATE TABLE IF NOT EXISTS logs (
    log_id integer PRIMARY KEY ,
    application_id integer,
    log_type_id integer,
    data date,
    environment character varying(100) NOT NULL,
    created_at timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (application_id) REFERENCES applications(application_id),
    FOREIGN KEY (log_type_id) REFERENCES log_type(log_type_id)
);

CREATE SEQUENCE log_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE logs
    ALTER log_id set default nextval('log_id_seq');