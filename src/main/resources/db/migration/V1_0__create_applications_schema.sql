CREATE TABLE IF NOT EXISTS applications (
    application_id integer PRIMARY KEY,
    application_name varchar (100) NOT NULL,
    description text NOT NULL,
    created_at timestamp with time zone DEFAULT CURRENT_TIMESTAMP
);