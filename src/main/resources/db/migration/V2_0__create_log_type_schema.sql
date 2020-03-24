CREATE TABLE IF NOT EXISTS "log_type" (
     "log_type_id" integer PRIMARY KEY,
     "title" character varying(100) NOT NULL,
     "error_level" character varying(100) NOT NULL,
     "description" text NOT NULL
);