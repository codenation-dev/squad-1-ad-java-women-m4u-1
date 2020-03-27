CREATE TABLE IF NOT EXISTS users (
    user_id integer PRIMARY KEY,
    name character varying(100) NOT NULL,
    token character varying(100) NOT NULL,
    email character varying(100) NOT NULL,
    password character varying(100) NOT NULL,
    created_at timestamp with time zone DEFAULT CURRENT_TIMESTAMP
);

CREATE SEQUENCE user_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE users
    ALTER user_id set default nextval('user_id_seq');