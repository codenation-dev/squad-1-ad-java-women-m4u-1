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

CREATE TABLE IF NOT EXISTS users_applications (
    users_applications_id integer PRIMARY KEY,
    application_id integer,
    user_id integer,
    FOREIGN KEY (application_id) REFERENCES applications(application_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    created_at timestamp with time zone DEFAULT CURRENT_TIMESTAMP
);

CREATE SEQUENCE users_applications_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE users_applications
    ALTER users_applications_id set default nextval('users_applications_seq');