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