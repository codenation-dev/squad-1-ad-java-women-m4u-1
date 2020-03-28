CREATE TABLE IF NOT EXISTS applications (
    Id integer PRIMARY KEY,
    application_name varchar (100) NOT NULL,
    description text NOT NULL,
    createdAt timestamp with time zone DEFAULT CURRENT_TIMESTAMP
);

CREATE SEQUENCE Id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE applications
    ALTER Id set default nextval('Id_seq');

CREATE TABLE IF NOT EXISTS "log_type" (
    "log_type_id" integer PRIMARY KEY,
    "title" character varying(100) NOT NULL,
    "errorLevel" character varying(100) NOT NULL,
    "description" text NOT NULL
);

CREATE SEQUENCE log_type_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE log_type
    ALTER log_type_id set default nextval('log_type_id_seq');

CREATE TABLE IF NOT EXISTS logs (
    log_id integer PRIMARY KEY ,
    Id integer,
    log_type_id integer,
    data date,
    environment character varying(100) NOT NULL,
    createdAt timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (Id) REFERENCES applications(Id),
    FOREIGN KEY (log_type_id) REFERENCES log_type(log_type_id)
);

CREATE SEQUENCE log_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE logs
    ALTER log_id set default nextval('log_id_seq');

CREATE TABLE IF NOT EXISTS users (
    userId integer PRIMARY KEY,
    name character varying(100) NOT NULL,
    token character varying(100) NOT NULL,
    email character varying(100) NOT NULL,
    password character varying(100) NOT NULL,
    createdAt timestamp with time zone DEFAULT CURRENT_TIMESTAMP
);

CREATE SEQUENCE userId_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE users
    ALTER userId set default nextval('userId_seq');

CREATE TABLE IF NOT EXISTS users_applications (
    users_applications_id integer PRIMARY KEY,
    Id integer,
    userId integer,
    FOREIGN KEY (Id) REFERENCES applications(Id),
    FOREIGN KEY (userId) REFERENCES users(userId),
    createdAt timestamp with time zone DEFAULT CURRENT_TIMESTAMP
);

CREATE SEQUENCE users_applications_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE users_applications
    ALTER users_applications_id set default nextval('users_applications_seq');