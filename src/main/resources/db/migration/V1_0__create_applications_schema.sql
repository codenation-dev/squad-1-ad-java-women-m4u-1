CREATE TABLE IF NOT EXISTS applications (
    application_id integer PRIMARY KEY,
    application_name varchar (100) NOT NULL,
    description text NOT NULL,
    created_at timestamp with time zone DEFAULT CURRENT_TIMESTAMP
);

CREATE SEQUENCE application_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE applications
    ALTER application_id set default nextval('application_id_seq');